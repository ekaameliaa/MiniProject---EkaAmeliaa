Feature: As an User I want to see the transaction history

  @Transaction
  Scenario: User I want to see transaction history
    Given User on Alta Shop page
    When User click icon transaction
    Then User on transaction page