@Review
Feature:  Filter result based on review
  AS A    Customer
  I WANT TO  filter a products by review
  SO THAT   I can view results of my filtered choice

  @Rating_review
  Scenario: Filter By Rating
    Given   I am on a Homepage
    When    I search for a Product "nike"
    And     I apply review filter "3or more" on result page
    Then    I should see all products of my filtered choice

  @Regression
  Scenario Outline: : Search for a product
    Given   I am on a Homepage
    When    I search for a Product "nike"
    And     I apply review filter "<reviewFilter>"
    Then    I should see all products of my filtered choice
    Examples:

      | reviewFilter |
      | 5only        |
      | 4or more     |
      | 3or more     |
      | 2or more     |
      | 1or more      |
