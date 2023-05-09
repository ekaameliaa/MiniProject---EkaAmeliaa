Feature: As a user i want to pay for the product

  @PayProduct
  Scenario: as user i want to pay for the product purchased
    Given user on AltaShop page product
    When user click icon cart
    Then user click button pay