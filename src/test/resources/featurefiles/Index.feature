Feature: As a customer I want to be able navigate around the website. This includes navigating through side menus and viewing products that are on display.

  Background: Setting up the Browser
    Given I am on the home page

  @navigation
  Scenario: I want to return to the home page by clicking on the company logo.
    Given I am on the website
    When I click on the company logo
    Then I go to the home page

  @navigation
  Scenario: I want to explore the Women's Clothes section of the website.
    Given I am on the website
    When I click on the women's category
    Then I am sent to the women's department

  @navigation
  Scenario: I want to explore the Women's Dresses section of the website.
    Given I am on the website
    When I click on the dresses category
    Then I am sent to the women's department
    And I am sent to the dress section

  @navigation
  Scenario: I want to be able to see the Best Selling clothing from the home page.
    When I click on the Best Sellers tab
    Then I can see the best selling items

  @navigation
  Scenario: I want to be able to search for products using the search tab
    When I click on the search button
    Then I am taken to my search results

  @navigation
  Scenario Outline: I want to search the various categories that are advertised on the front of the home page.
    When I click on the "<Name>" panel
    Then I am taken to the "<Category>" page
    Examples:
      | Name | Category |
      |      |          |

  @navigation
  Scenario: I want to be able to contact the organization of the website.
    When I click on the button within the Call Us section
    Then I am taken to the organization's website

  @navigation
  Scenario Outline: I want to access the details of my account using the footer navigation bar
    When I click on the "<Name>" link
    Then I am taken to the "<Account Detail>" page
    Examples:
      | Name | Account Detail |
      |      |                |

  @navigation
  Scenario Outline: I want to access the information available from the footer of the website
    When I click on the "<Name>" link
    Then I am taken to the "<Information Page>" section.
    Examples:
      | Name | Information Page |
      |      |                  |



Feature: As a customer, I want to be able to sign up for the newsletter using my e-mail address to stay updated.

  Background: Setting up the Browser
    Given I am on the home page

  #todo

Feature: As a customer, I want to add products displayed on the home page that I find attractive to the cart and then checkout.

  Background: Setting up the Browser
    Given I am on the home page

  #todo

Feature: As a customer, I want to be able to contact help if I have any struggles regarding the website.

  Background: Setting up the Browser
    Given I am on the home page

  @contact
  Scenario: I want to access the contact and support page
    When I click on the contact us button
    Then I am taken to the contact us page

  @contact
  Scenario: I want to contact customer service regarding an inquiry

        #Todo