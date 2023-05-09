Feature: as a user i want to create a comment for product

  @Comment
  Scenario: user i want to input valid id and create a comment for product
    Given user has endpoint add comment product
    When user input valid id add comment product
    Then user see response code add comment product 200