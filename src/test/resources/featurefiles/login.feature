Feature: As a registered user with valid email and password I will be able to login to the website

  Background: Setting up the Browser
    Given I am on the login page

  @login
  Scenario: Getting to the My Account page from the homepage
    When I enter my registered email
    And I enter my correct password
    And I click on the login button
    Then I will go to the My Account page
    And I should see my account information

  @login
  Scenario: Staying in the Login Page as result of unregistered email address
    When I insert an unregistered email
    And I insert a valid password
    And I click on the login button
    Then I will stay in the Login Page

  @login
  Scenario: Staying in the Login Page as result of invalid password
    When I insert a registered email
    And I insert an invalid password
    And I click on the login button
    Then I will stay in the Login Page