Feature: As a customer I would like to navigate through my account pages and edit information after logging in
  Scenario: As a customer I would like to safely logout from my account
    Given I am on my account page
    When I click the Sign out link
    And The registration page opens
    And I click back on my browser
    And I click any link
    Then I should see the authentication form

  Scenario: As a customer I want to be able to see my order history
    Given I am on my account page
    When I click on the Order History And Details button
    Then The Order History And Details page should open

  Scenario: As a customer I want to be able to see my credit slips
    Given I am on my account page
    When I click on the Credit Slips button
    Then The Credit Slips page should open

  Scenario: As a customer I want to be able to see my addresses
    Given I am on my account page
    When I click on the My Addresses button
    Then The My Addresses page should open

  Scenario: As a customer I want to be able to see my personal information
    Given I am on my account page
    When I click on the My Personal Information button
    Then The My Personal Information page should open

  Scenario: As a customer I want to be able to see my wishlist
    Given I am on my account page
    When I click on the My Wishlist button
    Then The My Wishlist page should open

  Scenario: As a customer I want to be able to go back to my account dashboard
    Given I am on Order History page
    When I click the Back to your account. button
    Then I should be on My Account page

  Scenario: As a customer I want to be able to add a new address
    Given I am on My Addresses page
    When I click the Add a new address button
    Then The page to add new address should open

  Scenario: As a customer I want to be able to delete an address
    Given I am on My Addresses page
    When I click the Delete button
    And I confirm the deletion
    Then The address should be deleted

  Scenario: As a customer I want to have the option to update an address
    Given I am on My Addresses page
    When I click the Update button
    Then The page to update the address should open

  Scenario: As a customer I want to be able to update an address
    Given I am on the update address page
    When I edit the fields
    And click the button Save
    Then the address should be updated

  Scenario: As a customer I want to be able to update my first name
    Given I am on My Personal Information page
    When I edit the first name field
    And I click the button Save
    Then the first name should be updated

  Scenario: As a customer I want to be able to update my last name
    Given I am on My Personal Information page
    When I edit the last name field
    And I click the button Save
    Then the last name should be updated

  Scenario: As a customer I want to be able to update my email address
    Given I am on My Personal Information page
    When I edit the email address field
    And I click the button Save
    Then the email address should be updated

  Scenario: As a customer I want to not be able to update my email address with an invalid value
    Given I am on My Personal Information page
    When I edit the email address field with an invalid value
    And I click the button Save
    Then an error message should be displayed

  Scenario: As a customer I want to be able to update my password if both fields match
    Given I am on My Personal Information page
    When I fill the new password field
    And the confirmation password field with the same password
    And I click the button Save
    Then the password should be updated

  Scenario: As a customer I want to not be able to update my password if both fields don't match
    Given I am on My Personal Information page
    When I fill the new password field
    And the confirmation password field with different password
    And I click the button Save
    Then the error The password and confirmation do not match. should be displayed

  Scenario: As a customer I want to be able to create a wishlist
    Given I am on My Wishlist page
    When I fill the name field for my wishlist
    And I click the button Save
    Then the wishlist should be created

  Scenario: As a customer I want to be able to delete a wish list
    Given I am on My Wishlist page
    When I click the delete button next to my wishlist
    And I confirm the deletion
    Then the wishlist should be deleted

  Scenario: As a customer I want to be able to see the content of my wishlist
    Given I am on My Wishlist page
    When I click on the wishlist name
    Then the content of my wishlist should be loaded

  Scenario: As a customer I want to be able to delete items from my wishlist
    Given I am on My Wishlist page
    And the content of my wishlist is loaded
    When I click on the delete button next to the item's name
    Then the item should be removed from my wishlist

  Scenario: As a customer I want to be able to see my previous orders details
    Given I am on the Order History page
    When I click on Order Reference link
    Then the order details should load

  Scenario: As a customer I want to be able to see my invoices
    Given I am on the Order History page
    And the order details are loaded
    When I click on the Invoice link
    Then the invoice pdf should open