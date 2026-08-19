Feature: Unacademy Sign Up

  @TC001
  Scenario: TC001 - Verify joining Unacademy with valid mobile number and valid OTP
    Given I am on the Unacademy home page
    When I click on Join for free
    And I enter a valid signup mobile number
    And I click on Signup Continue
    And I enter the OTP manually
    Then I should be registered successfully

  @TC002
  Scenario: TC002 - Verify joining with invalid mobile number
    Given I am on the Unacademy home page
    When I click on Join for free
    And I enter an invalid missing digits mobile number
    And I click on Signup Continue
    Then I should remain on the signup page
    And I clear the mobile number
    And I enter an invalid extra digits mobile number
    Then the extra digit should not be considered

  @TC003
  Scenario: TC003 - Verify login with invalid OTP
    Given I am on the Unacademy home page
    When I click on Join for free
    And I enter a valid signup mobile number
    And I click on Signup Continue
    And I enter the invalid OTP
    Then the invalid OTP error should be visible

  @TC004
  Scenario: TC004- Verify joining with expired OTP
    Given I am on the Unacademy home page
    When I click on Join for free
    And I enter a valid signup mobile number
    And I click on Signup Continue
    And I wait till the OTP expires
    And I enter the expired OTP manually
    Then the invalid OTP error should be visible

  @TC006&TC007
  Scenario: TC006 &TC007 - Verify sign up from Laptop using Chrome
    Given I am on the Unacademy home page
    When I click on Join for free
    And I enter a valid signup mobile number
    And I click on Signup Continue
    And I enter the OTP manually
    Then I should be registered successfully

  @TC008 @firefox
  Scenario: TC008 - Verify sign up using Firefox
    Given I am on the Unacademy home page
    When I click on Join for free
    And I enter a valid signup mobile number
    And I click on Signup Continue
    And I enter the OTP manually
    Then I should be registered successfully

  @TC009 @edge
  Scenario: TC009 - Verify sign up using Edge
    Given I am on the Unacademy home page
    When I click on Join for free
    And I enter a valid signup mobile number
    And I click on Signup Continue
    And I enter the OTP manually
    Then I should be registered successfully

  @TC010
  Scenario: TC010 - Verify first-time joining Unacademy with valid mobile number, OTP, name and state
    Given I am on the Unacademy home page
    When I click on Join for free
    And I enter a valid new signup mobile number
    And I click on Signup Continue
    And I enter the OTP manually
    And I enter my name
    And I select Telangana as state
    And I click on Submit
    Then I should be registered successfully
