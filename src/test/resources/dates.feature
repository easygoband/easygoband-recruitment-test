Feature: Converting a string to epoch

  Scenario: Nothing
    Given a date 2017-05-30T17:42:27.000Z
    When I call the parseDateToEpoch method
    Then I will obtain 1496095200