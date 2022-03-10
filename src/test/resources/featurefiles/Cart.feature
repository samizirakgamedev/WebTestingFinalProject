Feature: As a customer I want to be able to access and manipulate Cart page

  @cart
  Scenario: Empty cart page
    Given I am on the Cart Page
    And No items have been added
    Then Cart should be empty
    And "Your shopping cart is empty." should appear

  @cart
  Scenario: Show item
    Given I am on the Cart Page
    And An item has been added
    Then Item should be shown in the page

  @cart
  Scenario: Remove item
    Given I am on the Cart Page
    And An item has been added
    When I click on the remove item button next to the item
    Then Cart should be empty
    And "Your shopping cart is empty." should appear

  @cart
  Scenario: Remove item through minus button
    Given I am on the Cart Page
    And An item has been added
    When I click on the minus button next to the item
    Then Cart should be empty
    And "Your shopping cart is empty." should appear

  @cart
  Scenario: Increase item's quantity
    Given I am on the Cart Page
    And An item has been added
    When I click on the plus button next to the item
    Then Item's quantity should increase from 1 to 2

  @cart
  Scenario: Decrease item's quantity
    Given I am on the Cart Page
    And An item has been added and its quantity increased
    When I click on the minus button next to the item
    Then Item's quantity should be 1

  @cart
  Scenario: Edit item's quantity though text box
    Given I am on the Cart Page
    And An item has been added and its quantity increased
    When I edit quantity text box with number 4
    Then Item's quantity should be 4 and total should be updated
    And Total number of products should be 4





