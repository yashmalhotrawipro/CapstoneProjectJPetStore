Feature: User Login

Scenario: Login with valid credentials
Given the user is on the login page for valid login
When the user enters valid username "yash" and password "yash123"
And clicks on the login button for valid login
Then the user should redirected to home page with a welcome message 

Scenario: Login with invalid credentials
Given the user is on the login page for invalid login
When the user enters invalid username "admin" and password "admin12"
And clicks on the login button for invalid login
Then an error message should be displayed 