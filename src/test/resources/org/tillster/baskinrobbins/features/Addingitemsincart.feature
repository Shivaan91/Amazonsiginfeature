@Cart
Feature: validate if the user is able to add an item to the cart and Order Information would be displayed, re-confirm the product details, subtotal, tax and order total. 

Scenario: Validate if the user is able to add an item to the cart
	Given user navigates to the baskinrobbins website
  When user click on order online in the webpage to select item
  And user enter valid store locator address
  And user select order from list of stores
  Then user navigate to list of availble products on the page
  When user click on cakes and pies from the list
 