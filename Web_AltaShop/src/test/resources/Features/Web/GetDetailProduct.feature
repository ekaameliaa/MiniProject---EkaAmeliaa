Feature: As a user i want to see detail product so that i can see detail products page

  @GetDetail
  Scenario: as user i want to select valid product detail by id
    Given user on Alta Shop page
    When user select valid product
    And user click detail button
    Then user on detail products page