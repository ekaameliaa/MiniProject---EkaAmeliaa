Feature: As a User i want to get all orders

  @GetOrder
  Scenario: User i want to get all Order
    Given user has set endpoint Get all Order
    When user send endpoint Get all order
    Then user see response code Get all order 200

  @FailGetOrder
  Scenario: User i want to failed get all Order
    Given user has set invalid endpoint Get all Order
    When user send invalid endpoint Get all order
    Then user see response code failed Get all order 400
