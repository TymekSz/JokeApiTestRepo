Feature: Schema verification

  Scenario: should return proper response structure
    Given Api is available
    When Get random joke
    Then Schema should contains proper fields