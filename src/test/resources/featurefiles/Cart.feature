Feature: As a customer I want to be able to access and manipulate Cart page

  Scenario: Empty cart page
    Given I am on the Cart Page
    And No items have been added
    Then Cart should be empty
    And Your shopping cart is empty. should appear
#
  Scenario: Show item
    Given I have added an item to the cart
    When I go to the Cart Page
    Then Item should be shown in the page

  Scenario: Remove item
    Given I have added an item to the cart
    When I go to the Cart Page
    And I click on the remove item button next to the item
    Then Cart should be empty
    And Your shopping cart is empty. should appear

  Scenario: Remove item through minus button
    Given I have added an item to the cart
    And I go to the Cart Page
    When I click on the minus button next to the item
    Then Cart should be empty
    And Your shopping cart is empty. should appear

  Scenario: Increase item's quantity
    Given I have added an item to the cart
    And I go to the Cart Page
    When I click on the plus button next to the item
    Then Item's quantity should increase from 1 to 2

  Scenario: Decrease item's quantity
    Given I have added an item to the cart
    And I go to the Cart Page
    And I click on the plus button next to the item
    When I click on the minus button next to the item
    Then Item's quantity should be 1




