Feature: Check jokes by id

  Scenario: should get proper jokes by id
    Given Api is available
    When Get random jokes as datatable
      | type        | setup                                     | punchline                               | id  |
      | general     | Where do you learn to make banana splits? | At sundae school.                       | 288 |
      | programming | Hey, wanna hear a joke?                   | Parsing HTML with regex.                | 395 |
      | dad         | Why don't eggs tell jokes?                | Because they would crack each other up. | 384 |
    And Get jokes by id
    Then Joke data is consistent