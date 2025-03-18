Feature: Checkout Feature

Scenario: Complete the checkout process successfully
Given user is logged in with username "yash" and password "yash123" and has products in the cart
When the user proceeds to checkout 
And selects a payment method and fills the billing details
And reviews and confirms the order
Then the order confirmation message "Thank you, your order has been submitted." should be displayed 