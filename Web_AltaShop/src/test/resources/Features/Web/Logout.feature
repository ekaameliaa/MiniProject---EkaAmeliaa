Feature: As an user i want to logout

  @Logout
  Scenario: User i want to logout web altaShop
    Given User on AltaShop page
    When User click icon user
    And User click button logout
    Then User on login page
