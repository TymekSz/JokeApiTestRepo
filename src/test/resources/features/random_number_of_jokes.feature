Feature: Jokes Api Verification


Scenario: should return proper response structure
When Get random joke
Then Schema should contains proper fields


Scenario Outline: should return expected number of jokes
When Get <numberOfJokes> random jokes
Then Number of jokes should be equal to: <numberOfJokes>

Examples:
| numberOfJokes |
| 1             |
| 6             |
| 18            |


Scenario: should get proper jokes by id
Given Get random jokes as datatable
| type        | setup                                     | punchline                               | id  |
| general     | Where do you learn to make banana splits? | At sundae school.                       | 288 |
| programming | Hey, wanna hear a joke?                   | Parsing HTML with regex.                | 395 |
| dad         | Why don't eggs tell jokes?                | Because they would crack each other up. | 384 |
When Get jokes by id
Then Joke data is consistent