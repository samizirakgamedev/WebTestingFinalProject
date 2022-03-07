Feature: As a customer I would like to navigate through my account pages after logging in
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