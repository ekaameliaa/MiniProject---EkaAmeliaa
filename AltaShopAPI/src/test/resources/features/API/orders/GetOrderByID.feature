Feature: As an user i want to get detail by id of data orders

  @GetOrderID
  Scenario: As user i want to get detail order by id
    Given user has endpoint
    When user send endpoint get detail order by id
    Then user see response code get detail order 200

  @FailGetOrderID
  Scenario: As user i want to failed get detail order by id
    Given user has endpoint order
    When user send invalid endpoint get detail order by id
    Then user see response code failed get detail order 404