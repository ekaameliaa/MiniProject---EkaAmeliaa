Feature: As a user i want to buy product

  @BuyProduct
  Scenario: as user i want to buy product with select valid product detail
    Given user on Alta Shop page product
    When user select valid product by id
    And user click button buy
    Then user see buy product