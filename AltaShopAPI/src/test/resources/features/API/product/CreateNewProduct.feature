Feature: As a user i want to create a new product

  @PostProduct
  Scenario: as user i want to input valid data in post new product
    Given User has endpoint create new product
    When user send method post endpoint add new product
    Then user see response code post new product 200

  @FailPostProduct
  Scenario: as user i want to input invalid data to then i can see fail add new product
    Given User has endpoint post new product
    When user send invalid data add new product
    Then user see response code Failed Add new product 400