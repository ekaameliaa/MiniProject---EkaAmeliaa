Feature: As a user i want to create a new order

  @PostOrder
  Scenario: as user i want to input valid data in post new order
    Given User has endpoint post new order
    When user send method post endpoint add new order
    Then user see response code post new order 200

  @FailPostOrder
  Scenario: as user i want to input invalid data to then i can see fail add new order
    Given User has endpoint post new order
    When user send invalid data add new order
    Then user see response code Failed Add new order 400