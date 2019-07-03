@Search
  Feature: search function
  AS A    Customer
  I WANT  TO Search for  a product
  SO THAT I  can view respective product

  @SmokeTest_search
  Scenario: Search for a product
    Given   I am on  Homepage
    When   i search of product "nike"
    Then   Then i should be able to see respective products

  @RegressionTest
  Scenario Outline: search product with valid inputs
    Given  I am on  Homepage
    When   i search of product "<products>"
    Then   Then i should be able to see respective products
    Examples:

      | products     |
      | puma         |
      | camera       |
      | mobile phone |

