Feature: As an user i want to get detail by id of data product

  @GetProductID
  Scenario: As user i want to get detail product by id
    Given user has endpoint product
    When user send endpoint get detail product by id
    Then user see response code get detail product 200

  @FailGetProductID
  Scenario: As user i want to failed get detail product by id
    Given user has invalid endpoint product
    When user send invalid endpoint get detail product by id
    Then user see response code failed get detail product 404