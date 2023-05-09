Feature: As an user i want to get data product by comment

  @GetCommentProduct
  Scenario: As user i want to get product by comment
    Given user has endpoint get product comment
    When user send endpoint get detail product by comment
    Then user see response code get product comment 200

  @FailGetCommentProduct
  Scenario: As user i want to failed get product by comment
    Given user has endpoint get product comment
    When user send invalid method get product by comment
    Then user see response code failed get product comment 405