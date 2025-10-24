Feature: User needs
  This show the groceries needed for user
  Scenario: Multiple items set
    Given The user want to buy:
      | item   | price |
      | Rice   | 800   |
      | Onions | 50    |
      | Wheat  | 200   |
    Then The user buys one month groceries