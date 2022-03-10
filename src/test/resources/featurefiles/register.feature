Feature: As a customer, I want to be able to register an acccount on automationpractice.com website

  @register
  Scenario: As a customer, I want to be able to navigate to the sign up page
    Given I open the Home Page
    When I click on Sign in button
    Then The registration page is open

  @register
  Scenario: As a customer I want to be able to create an account using a valid email address
    Given The registration page is open
    When I type a valid email address
    And I click the Create an account button
    Then The Create an account page should open

  @register
  Scenario Outline: As a customer I can't create an account if the email is incorrect format
    Given The registration page is open
    When I type an invalid <email> email
    And I click the Create an account button
    Then The error <message> should be displayed
    Examples:
      | email       | message                 |
      | test        | Invalid email address.  |
      | test@test   | Invalid email address.  |
      | test.com    | Invalid email address.  |

  @register
  Scenario Outline: As a customer I can't create another account with the same email address
    Given The registration page is open
    When I type a valid <email> email address
    And I click the Create an account button
    Then The error <message> should be displayed on the screen
    Examples:
      | email         | message                                                           |
      | test@test.com | An account using this email address has already been registered.  |

  @register
  Scenario: As a customer I want to be able to create an account by filling out only the required fields
    Given The Create an account page is open
    When I type my first name
    And I type my last name
    And I type my address
    And I type my city
    And I select my state from the list
    And I type my 12345 zipcode
    And I type my mobile phone
    And I click the Register button
    Then The My Account page should open