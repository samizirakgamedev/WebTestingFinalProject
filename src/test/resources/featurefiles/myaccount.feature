Feature: As a customer I would like to navigate through my account pages and edit information after logging in

  @myaccount
  Scenario: As a customer I would like to safely logout from my account
    Given I am on my account page
    When I click the Sign out link
    And The registration page opens
    And I click back on my browser
    And I click any link
    Then I should see the authentication form

  @myaccount
  Scenario: As a customer I want to be able to see my order history
    Given I am on my account page
    When I click on the Order History And Details button
    Then The Order History And Details page should open

  @myaccount
  Scenario: As a customer I want to be able to see my credit slips
    Given I am on my account page
    When I click on the Credit Slips button
    Then The Credit Slips page should open

  @myaccount
  Scenario: As a customer I want to be able to see my addresses
    Given I am on my account page
    When I click on the My Addresses button
    Then The My Addresses page should open

  @myaccount
  Scenario: As a customer I want to be able to see my personal information
    Given I am on my account page
    When I click on the My Personal Information button
    Then The My Personal Information page should open

  @myaccount
  Scenario: As a customer I want to be able to see my wishlist
    Given I am on my account page
    When I click on the My Wishlist button
    Then The My Wishlist page should open

  @myaccount
  Scenario: As a customer I want to not be able to update my email address with an invalid value
    Given I am on my account page
    When I click on the My Personal Information button
    When I edit the email address field with an invalid value
    And I click the button Save
    Then an error message should be displayed

  @myaccount
  Scenario: As a customer I want to be able to create a wishlist
    Given I am on my account page
    When I click on the My Wishlist button
    When I fill the name field for my wishlist
    And I click the button Save
    Then the wishlist should be created

  @myaccount
  Scenario: As a customer I want to be able to see the content of my wishlist
    Given I am on my account page
    When I click on the My Wishlist button
    When I click on the wishlist name
    Then the content of my wishlist should be loaded

  @myaccount
  Scenario: As a customer I want to be able to delete items from my wishlist
    Given I am on my account page
    When I click on the My Wishlist button
    And the content of my wishlist is loaded
    When I click on the delete button next to the item's name
    Then the item should be removed from my wishlist
