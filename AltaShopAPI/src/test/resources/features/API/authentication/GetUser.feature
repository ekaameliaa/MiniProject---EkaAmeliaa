Feature: As an user i want to get user information

  @GetUser
  Scenario: As user i want to get user information
    Given user have endpoint auth
    When user send endpoint auth
    And user has set Get user endpoint
    And user send method Get user endpoint
    Then user see status code get user 200

  @FailGetUser
  Scenario: As user i want to failed get user information
    Given user has set Get user endpoint
    When user send method invalid user endpoint
    Then user see status code failed get user 405