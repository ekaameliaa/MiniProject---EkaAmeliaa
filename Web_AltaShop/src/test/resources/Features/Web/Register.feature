Feature: As a user i have be able to success Register so that i can see login page

  @Register
  Scenario: as user i want to input valid to then i can see success register
    Given user on register page
    When user input valid username
    And user input valid email
    And user input valid password
    And user click register button
    Then user on login page