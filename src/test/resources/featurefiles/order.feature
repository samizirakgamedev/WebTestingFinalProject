Feature: As a registered user with valid email and password I will be able to place my order

  Background:
    Given I am on the homepage

  Scenario Outline: Buying products successfully
    When I click on the black Sign in button
    And I enter the Email Address "<email>" and  the Password "<password>"
    And I click Sign in green button
    And I move my cursor to the WOMEN tab
    And I click on the sub menu T-shirts
    And I hover over the first product displayed
    And I click on the More button
    And I click on the plus button to increase the quantity to two
    And I select size M
    And I click on the Add to cart blue button
    And I click on the green Proceed to checkout button
    And I click on the Proceed to checkout button on the summary page
    And I click on the Proceed to checkout button on the address page
    And I click on the agree to terms and conditions
    And I click on the Proceed to checkout button on the shipping page
    And I click on the Pay by bank wire button
    And I click on the I confirm my order button on the payment page
    Then Your order on My Store is complete. should be displayed

    Examples:
      | email                 | password     |
      | finalproject@test.com | SpartaGlobal |