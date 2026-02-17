Feature: Random number of jokes

  Scenario Outline: should return expected number of jokes
    When Get <numberOfJokes> random jokes
    Then Number of jokes should be equal to: <numberOfJokes>

    Examples:
      | numberOfJokes |
      | 1             |
      | 6             |
      | 18            |