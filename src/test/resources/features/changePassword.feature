Feature: Change Password  

Scenario: Successfully change the user password  
Given user is logged in  
When user navigates to the change password page  
And user enters a new password "password1" and confirms it "password1"  
And user submits the password change request  
Then a confirmation message "Your password has been updated successfully." should be displayed  


