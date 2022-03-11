Feature: Able to navigate to Twitter page from the website

  Background: Checking Twitter page
    Given I am on the Home Page

  @twitter
  Scenario: Getting to the Twitter page from the Home page
    When I click on TWITTER icon
    Then I will go to the TWITTER page