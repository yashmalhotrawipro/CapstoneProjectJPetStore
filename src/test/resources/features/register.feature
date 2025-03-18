Feature: User Registration

Scenario: Register an existing user
Given the user is on the registration page for existing user
When the user enters "<Username>", "<Password>", "<Repeat Password>", "<First Name>", "<Last Name>", "<Email>", "<Phone>", "<Address1>", "<Address2>", "<City>", "<State>", "<Zip>", "<Country>"
And selects the favourite category
And clicks on the Register button for existing user
Then the user should be encountered with an error

Examples: 
|   Username   | Password | Repeat Password | First Name | Last Name |      Email     |     Phone   | Address1 | Address2 | City  | State | Zip    | Country | 
| yashmalhotra | yash1234 |    yash1234     |    Yash    | Malhotra  | yash1@test.com | 08872638323 |  Delhi   |  Delhi   | Delhi | Delhi | 110055 | India   |   

Scenario: Registering a user with missing values 
Given the user is on the registration page 
When the user enters "user1" as username and "pass" as password and "pass" as repeat password
And selects the favourite category from the drop down
And clicks Register button with missing credentials
Then the user should face error  

