
@tag
Feature: Purchase the order from Ecommerce Website
  I want to use this template for my feature file

Background:
 Given I landed on Ecommerce Page
 
 
  @Regressions
  Scenario Outline: Positive Test of StandAlone the order
    Given Logged in with username <name> and password <password>
    When I add product <productName> to Cart
    And checkout  <productName> and submit the order
    Then "THANKYOU FOR THE ORDER."message is displayed on ConfirmationPage

    Examples: 
      | name                              | password         |productName   |
      | chaimaammar.simplon@gmail.com     |    Ch@@2022      |  ZARA COAT 3 |
     
