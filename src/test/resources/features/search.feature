Feature: Search products

Scenario: Search for a product successfully
Given the user is in the HomePage
When user enters "fish" in the search bar 
And user clicks on the search button 
Then search results should display relevant products
 
