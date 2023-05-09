Feature: as a user i want to assign a product rating

  @Ratings
  Scenario: user i want to input valid id and valid data to assign a product rating
    Given user has endpoint add product rating
    When user input valid id add product rating
    Then user see responde code add product rating 200