Feature: As an user i want to delete data product

  @DeleteProduct
  Scenario: as user i want to delete data product by id
    Given user has set Delete product endpoint
    When user send delete product endpoint
    Then user accept response code delete product 200