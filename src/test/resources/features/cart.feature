Feature: Shopping Cart Management 

Scenario: Add a product to the cart
Given user is on the product page 
When the user adds the product to the cart
Then the product should be displayed in the cart

Scenario: Update the quantity of a product in the cart
Given the user has a product with some quantity in the cart
When the user update the qualtity to "4"
Then the cart should reflect the updated quantity which is "4"

Scenario: Remove a product from the cart
Given the user has a product in the cart 
When the user remove the product from the cart
Then the cart should be empty with a message "Your cart is empty."