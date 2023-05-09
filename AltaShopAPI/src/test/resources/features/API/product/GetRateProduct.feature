Feature: As an user i want to get detail rate of data product

  @GetRateProduct
  Scenario: As user i want to get rate product
    Given user has endpoint get rate product
    When user send endpoint get detail rate product
    Then user see response code get detail rate product 200

  @FailGetRateProduct
  Scenario: As user i want to failed get detail rate product
    Given user has endpoint get rate product
    When user send invalid method get detail rate product
    Then user see response code failed get detail rate product 405