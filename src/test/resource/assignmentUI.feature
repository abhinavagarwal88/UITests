
@assignment
Feature: Order an item on amazon.com

  Scenario: Verify that price of an item is same in search, sub cart and order checkout page
   Given I open Amazon.com website
   And I click on Sign In option
   And I enter username "abhinavagarwal88@gmail.com" on login page
   And I click on continue on login page
   And I enter password "Hrimicsorn638!$" on login page
   And I click on Sign In Button
   When I search for item "qa testing for begineers"
   And I click on 1 search result
   Then I check price for search item
   And I click on Add to Cart link
   And I check price for added item in sub cart page
   And I click on proceed to checkout button sub cart page
   And I verify the price on item checkout page


