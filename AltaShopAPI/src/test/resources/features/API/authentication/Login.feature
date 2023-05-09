Feature: As a user i have be able to success login

  @Login
  Scenario: as user i want to input valid data to then i can see success login
    Given user has set endpoint login
    When user send method post login endpoint
    Then user see response code login 200

  @FailLogin1
  Scenario: as user i want to select invalid method to then i can see fail login
    Given user has set endpoint login
    When user send method invalid login endpoint
    Then user see response code Faillogin 405

  @FailLogin2
  Scenario: as user i want to input invalid data to then i can see fail login
    Given user has set endpoint login
    When user send invalid data login
    Then user see response code Failedlogin 400

