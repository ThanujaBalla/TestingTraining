Feature: OrangeHRM Login 
Scenario: Successful Login with valid Credentials
Given Open the OrangeHRM login page
When Enter the username "Admin"
And Enter the password "admin123"
And Click on login button
Then Dashboard page should be displayed