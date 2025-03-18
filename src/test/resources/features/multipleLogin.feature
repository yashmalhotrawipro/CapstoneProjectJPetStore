Feature: Multiple user Login
Scenario Outline: User successfully logs in using valid credentials from Excel
Given the user is on the login page for multiple login
When the user enter their username and password from excel
Then user should be logged in successfully
