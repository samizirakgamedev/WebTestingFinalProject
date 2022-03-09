Feature: As a customer, I want to be able to register an acccount on automationpractice.com website
  Scenario: As a customer, I want to be able to navigate to the sign up page
    Given I open the Home Page
    When I click on Sign in button
    Then The registration page is open

  Scenario: As a customer I want to be able to create an account using a valid email address
    Given The registration page is open
    When I type a valid email address
    And I click the Create an account button
    Then The Create an account page should open

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
      |             | Invalid email address.  |

  Scenario Outline: As a customer I can't create another account with the same email address
    Given The registration page is open
    When I type a valid <email> email address
    And I click the Create an account button
    Then The error <message> should be displayed on the screen
    Examples:
      | email         | message                                                           |
      | test@test.com | An account using this email address has already been registered.  |

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

    Scenario Outline: As a customer I shouldn't be able to create an account if one of the required fields is missing
      Given The Create an account page is open
      When I type my <firstname> first name
      And I type my <lastname> last name
      And I type my <address> address
      And I type my <city> city
      And I choose my <state> state
      And I type my <zipcode> zipcode
      And I type my <mobilephone> mobile phone
      And I click the Register button
      Then The <errormessage> message should be displayed
      Examples:
        | firstname | lastname | address | city | state   | zipcode | mobilephone | errormessage                                                                    |
        | test      | test     | test    | test |         | 12345   | 12345678    | This country requires you to choose a State.                                    |
        | test      | test     | test    | test | Florida | 12345   | 12345678    | firstname is required.                                                          |
        | test      |          | test    | test | Florida | 12345   | 12345678    | lastname is required.                                                           |
        | test      | test     |         | test | Florida | 12345   | 12345678    | address1 is required.                                                           |
        | test      | test     | test    |      | Florida | 12345   | 12345678    | city is required.                                                               |
        | test      | test     | test    | test | Florida |         | 12345678    | The Zip/Postal code you've entered is invalid. It must follow this format: 00000|
        | test      | test     | test    | test | Florida | 12345   |             | You must register at least one phone number.                                    |
