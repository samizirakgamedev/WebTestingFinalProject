Feature: As a customer I want to be able navigate around the website. This includes navigating through side menus and viewing products that are on display.

  Background: Setting up the Browser
    Given I am on the home page

  @index
  Scenario: I want to return to the home page by clicking on the company logo.
    Given I am on the website
    When I click on the company logo
    Then I go to the home page

  @index
  Scenario: I want to explore the Women's Clothes section of the website.
    Given I am on the website
    When I click on the women's category
    Then I am sent to the women's department

  @index
  Scenario: I want to explore the Women's Dresses section of the website.
    Given I am on the website
    When I click on the dresses category
    Then I am sent to the women's department
    And I am sent to the dress section

  @index
  Scenario: I want to be able to see the Best Selling clothing from the home page.
    When I click on the Best Sellers tab
    Then I can see the best selling items

  @index
  Scenario: I want to be able to search for products using the search tab
    When I click on the search button
    Then I am taken to my search results


  @index
  Scenario Outline: I want to search the various categories that are advertised on the front of the home page.
    When I click on the "<Name>" panel
    Then I am taken to the "<Category>" page
    Examples:
      | Name | Category |
      |      |          |

  @index
  Scenario: I want to be able to contact the organization of the website.
    When I click on the button within the Call Us section
    Then I am taken to the organization's website

  # need to be logged
  @index
  Scenario Outline: I want to access the details of my account using the footer navigation bar
    When I click on the "<Name>" link
    Then I am taken to the "<Account Detail>" page
    Examples:
      | Name             | Account Detail   |
      | My orders        | My orders        |
      | My addresses     | My addresses     |
      | My personal info | My personal info |

  @index
  Scenario Outline: I want to access the information available from the footer of the website
    When I click on the "<Name>" link
    Then I am taken to the "<Information Page>" section.
    Examples:
      | Name                        | Information Page            |
      | Specials                    | Specials                    |
      | New products                | New products                |
      | Best sellers                | Best sellers                |
      | Our stores                  | Our stores                  |
      | Terms and conditions of use | Terms and conditions of use |
      | About us                    | About us                    |
      | Sitemap                     | Sitemap                     |

  @index
  Scenario: I want to access the contact and support page
    When I click on the contact us button
    Then I am taken to the contact us page
