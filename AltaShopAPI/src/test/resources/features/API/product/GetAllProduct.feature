Feature: As a User i want to get all products

  @GetProduct
  Scenario: User i want to get all product
    Given user has set endpoint Get all Product
    When user send endpoint Get all Product
    Then user see response code Get all product 200

  @FailGetProduct
  Scenario: User i want to failed get all product
    Given user has set endpoint Get all Product
    When user send invalid endpoint Get all Product
    Then user see response code failed Get all product 400