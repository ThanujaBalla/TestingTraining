Feature: Unacademy Login

  @TC011
  Scenario: TC011 - Login with valid mobile number and valid OTP
    Given I am on the Unacademy home page for Login
    When I click on Log in
    And I enter a valid login mobile number
    And I click on login button
    And I manually verify the OTP
    Then I should be logged in successfully

  @TC012
  Scenario: TC012 - Login with valid email id and otp
    Given I am on the Unacademy home page for Login
    When I click on Log in
    And I click on Continue with Email button
    And I enter a valid email address
    And I click on login button
    And I manually verify the OTP
    Then I should be logged in successfully

  @TC013A
  Scenario: TC013A - Verify login with invalid mobile
    Given I am on the Unacademy home page for Login
    When I click on Log in
    And I enter an invalid missing digit mobile number in login
    And I click on login button
    Then I should remain on the login page
    And I clear the mobile number in login field
    And I enter an invalid extra digits mobile number in login
    Then the extra digit should not be considered in login

  @TC013B
  Scenario: TC013B - Verify login with invalid email
    Given I am on the Unacademy home page for Login
    When I click on Log in
    And I click on Continue with Email button
    And I enter non-email format in email coloumn
    And I click on login button
    Then the Email is not valid error should be visible
    And I clear the email address field
    And I enter formatted non existing email id
    And I click on login button
    Then the Login failed error should be displayed
    And I clear the email address field
    And I enter an unregistered email
    And I click on login button
    Then the email not registered error should be displayed

  @TC014
  Scenario: TC014 - Verify login with invalid OTP
    Given I am on the Unacademy home page for Login
    When I click on Log in
    And I click on Continue with Email button
    And I enter a valid email address
    And I click on login button
    And I manually enter the invalid OTP
    Then the invalid OTP error should be visible in login

  @TC015
  Scenario: TC015 - Verify login with expired OTP
    Given I am on the Unacademy home page for Login
    When I click on Log in
    And I enter a valid login mobile number
    And I click on login button
    And I wait till the OTP expires in login
    And I enter the expired OTP manually for login
    Then the invalid OTP error should be visible in login

  @TC017&TC018
  Scenario: TC017 - Login from Laptop TC018 - verify login from geographical location
    Given I am on the Unacademy home page for Login
    When I click on Log in
    And I enter a valid login mobile number
    And I click on login button
    And I manually verify the OTP
    Then I should be logged in successfully

    @TC019
    Scenario: TC019 - Verify Successfull logout
    Given I am on the Unacademy home page for Login
    When I click on Log in
    And I enter a valid login mobile number
    And I click on login button
    And I manually verify the OTP
    Then I should be logged in successfully
    And I click on the profile icon
    And I click on the SignOut button
    Then the Login button should be visible