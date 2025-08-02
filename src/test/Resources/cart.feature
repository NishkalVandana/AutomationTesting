Feature: To add items to cart

  @smoke
  Scenario Outline: User on cart page
    Given The user select "<item>" to add into cart
    When The user clicks Add item to cart button
    Then The item is added into cart

    Examples:
      | item     |
      | Facewash |
      | Shampoo  |
      | Earpods  |
