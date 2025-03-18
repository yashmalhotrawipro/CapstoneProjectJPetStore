Feature: logout functionality
Scenario: Logout from the application

Given the user is logged in
When the user clicks the logout button
Then the user should be logged out from the application
