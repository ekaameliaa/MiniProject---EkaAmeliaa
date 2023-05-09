Feature: As a user i have be able to success login so that i can see Alta shop page

  @Login
  Scenario: as user i want to input valid to then i can see success login
    Given user onlogin page
    When user input valid email login
    And user input valid password login
    And user click login button
    Then user on AltaShop page