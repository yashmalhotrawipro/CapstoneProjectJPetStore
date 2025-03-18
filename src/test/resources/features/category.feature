Feature: Category Selection

Scenario: User selects a category and see relevant products
Given user is in the HomePage 
When user clicks on a specific category
Then the product table related to that category should be dispayed