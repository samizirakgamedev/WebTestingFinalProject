Feature: As a user I would like to see results of searching word so that I can use the functionalities available on the search page

  Background: Setting up the Browser
    Given I am on the Index page

  @search
  Scenario Outline: As a user I want to use the search box and be able to see the results of: "<search input>"
    When I enter the word "<search input>"
    And I click on search button
    Then I will see the number of results equal to "<expected result>"
    And I will see that every result which have been found will contain the word "<search input>"

    Examples:
      | search input  | expected result  |
      | Printed Dress | 5                |
      | T-shirts      | 1                |
      | Blouse        | 1                |
      | !@#$%^        | 0                |

  @search
  Scenario Outline: As a user I want to use the search box and be able to see results sorted by: "<sort by>"
    When I enter the word "<search input>"
    And I click on search button
    And I can see numbers of results equals to "<expected result>"
    And I click on the dropdown Sort by
    And I click on "<sort by>"
    Then I will see that results are correctly sorted by "<sorted>"

    Examples:
      | search input  | expected result  | sort by                  | sorted                   |
      | Printed Dress | 5                | Price: Lowest first      | Price: Lowest first      |
      | Printed Dress | 5                | Price: Highest first     | Price: Highest first     |
      | Printed Dress | 5                | Product Name: A to Z     | Product Name: A to Z     |
      | Printed Dress | 5                | Product Name: Z to A     | Product Name: Z to A     |
      | Printed Dress | 5                | In stock                 | In stock                 |
      | Printed Dress | 5                | Reference: Lowest first  | Reference: Lowest first  |
      | Printed Dress | 5                | Reference: Highest first | Reference: Highest first |

  @search
  Scenario: As a user I want to use the search box and be able to discover the stores
    When I enter any word in the search bar
    And I click on search button
    And I click on black Discover our stores button
    Then I will go to the Our stores page

  @search
  Scenario: As a user I want to use the search box and be able to navigate to the Fashion Supplier page
    When I enter any word in the search bar
    And I click on search button
    And I click on Fashion Supplier button
    Then I will go to the Fashion Supplier page