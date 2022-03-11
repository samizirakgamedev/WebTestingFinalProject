Feature: Able to navigate to Google plus page from the website

  Background: Checking the Google plus page
    Given I am on the HomePage

  @google
  Scenario: Getting to the Google plus page from the Home page
    When I click on Google plus icon
    Then I will go to the Google plus page