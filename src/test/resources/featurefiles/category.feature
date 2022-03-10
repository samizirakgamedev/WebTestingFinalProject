Feature: As a customer I want to be able to navigate through categories and filter products by various attributes

  @categories
  Scenario Outline: As a customer I want to filter the products by composition
    Given I am on the category <category> page
    When I select a composition <composition>
    Then only the products with correct composition should appear
    Examples:
      | category | composition  |
      | 3        | cotton       |
      | 3        | polyester    |
      | 3        | viscose      |

  @categories
  Scenario Outline: As a customer I want to filter the products by style
    Given I am on the category <category> page
    When I select a style <style>
    Then only the products with correct style should appear
    Examples:
      | category | style      |
      | 3        | casual     |
      | 3        | dressy     |
      | 3        | girly      |

  @categories
  Scenario Outline: As a customer I want to filter the products by size
    Given I am on the category <category> page
    When I select a size <size>
    Then Only the products with correct size should appear
    Examples:
      | category | size       |
      | 3        | s          |
      | 3        | m          |
      | 3        | l          |

  @categories
  Scenario Outline: As a customer I want to filter by category
    Given I am on the category <category> page
    When I select category <categories>
    Then Only the products from correct category should appear
    Examples:
      | category | categories |
      | 3        | tops       |
      | 3        | dresses    |

  @categories
  Scenario Outline: As a customer I want to filter by properties
    Given I am on the category <category> page
    When I select property <property>
    Then only the products with selected property should appear
    Examples:
      | category | property         |
      | 3        | colourful dress  |
      | 3        | midi dress       |
      | 3        | short sleeve     |
      | 3        | maxi dress       |
      | 3        | short dress      |

  @categories
  Scenario: As a customer I want to select only products in stock
    Given I am on the category 3 page
    When I select in stock option
    Then only products in stock should appear

  @categories
  Scenario: As a customer I want to select only products from a manufacturer
    Given I am on the category 3 page
    When I select the manufacturer
    Then only products from the manufacturer should appear

  @categories
  Scenario: As a customer I want to select the condition of the products
    Given I am on the category 3 page
    When I select the condition new
    Then only products with condition new should appear