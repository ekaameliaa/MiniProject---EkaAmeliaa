Feature: As an user i want to register so that i can see login page

  @Register
  Scenario: as user i want to register
    Given user has set endpoint register
    When user send method post register endpoint
    Then user see response code register 200

  @FailRegister
  Scenario: as user i want to failed register
    Given user has set endpoint register
    When user send method invalid register endpoint
    Then user see response code failregister 405