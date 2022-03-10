Feature: As a customer I want to be able to access and manipulate Cart page

  @cart
  Scenario: Empty cart page
    Given I am on the Cart Page
    And No items have been added
    Then Cart should be empty
    And Your shopping cart is empty. should appear

  @cart
  Scenario: Show item
    Given I have added an item to the cart
    When I go to the Cart Page
    Then Item should be shown in the page

  @cart
  Scenario: Remove item
    Given I have added an item to the cart
    When I go to the Cart Page
    And I click on the remove item button next to the item
    Then Cart should be empty
    And Your shopping cart is empty. should appear

  @cart
  Scenario: Remove item through minus button
    Given I have added an item to the cart
    And I go to the Cart Page
    When I click on the minus button next to the item
    Then Cart should be empty
    And Your shopping cart is empty. should appear

  @cart
  Scenario: Increase item's quantity
    Given I have added an item to the cart
    And I go to the Cart Page
    When I click on the plus button next to the item
    Then Item's quantity should increase from 1 to 2

  @cart
  Scenario: Decrease item's quantity
    Given I have added an item to the cart
    And I go to the Cart Page
    And I click on the plus button next to the item
    When I click on the minus button next to the item
    Then Item's quantity should be 1

  @cart
  Scenario: Continuing shopping from the summary cart page
    Given I have added an item to the cart
    And I go to the Cart Page
    When I click on the continue shopping button on the summary page
    Then I should be taken to the index page

  @cart
  Scenario Outline: Continuing shopping from the address cart page
    Given I have added an item to the cart
    And I click on the Sign in button
    And I enter Email Address "<email>" and Password "<password>"
    And I click Sign in button
    And I go to the Cart address Page
    When I click on the continue shopping button on the address page
    Then I should be taken to the index page
    Examples:
      | email                 | password     |
      | finalproject@test.com | SpartaGlobal |




