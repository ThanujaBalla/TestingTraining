package StepDefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import Pages.LoginPage;
import Utilities.DriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class logintest {

    WebDriver driver;
    LoginPage loginPage;
    
    @Given("I am on the Unacademy home page for Login")
    public void i_am_on_the_unacademy_home_page() {
        driver = DriverManager.getDriver();
        loginPage = new LoginPage(driver);
        System.out.println("Unacademy home page opened.");
    }

    @When("I click on Log in")
    public void i_goto_login_page() {
    	loginPage.gotoLoginPage();
    }

    @And("I enter a valid login mobile number")
    public void i_enter_a_valid_mobile_number() {
        loginPage.enterMobileNumber("9493527869");
    }

    @And("I click on login button")
    public void i_click_on_login() {
        loginPage.clickLogin();
    }

    @And("I manually verify the OTP")
    public void i_manually_verify_the_otp() {
        loginPage.waitForManualOTP();
    }

    @Then("I should be logged in successfully")
    public void i_should_be_loggedin_successfully() {
        Assert.assertTrue(
            loginPage.isHomePageDisplayed(),
            "Home page was not displayed after successful signup."
        );

        System.out.println("Registration completed successfully.");
    }
    
    @And("I click on Continue with Email button")
    public void i_click_continue_with_email_button() {
    	loginPage.clickContinueWithEmailButton();
    	System.out.println("CLicked continue with email Button.");
    }
    
    @And("I enter a valid email address")
    public void enter_email_address() {
    	loginPage.enterEmailAddress("thanujaballahyd@gmail.com");
    	System.out.println("Entered valid email address0");
    }
    
    @And("I enter an invalid missing digit mobile number in login")
    public void i_enter_a_invalid_missing_mobile_number() {
        loginPage.enterMobileNumber("12345");
    }
    
    @When("I enter an invalid extra digits mobile number in login")
    public void i_enter_a_invalid_extra_mobile_number() {
        loginPage.enterMobileNumber("1234567890123");
    }
    
    @Then("I should remain on the login page")
    public void i_should_remain_on_login_page() {
        Assert.assertFalse(
            loginPage.isOTPFieldDisplayed(),
            "OTP screen appeared for an invalid mobile number."
        );
    }
    
    @And("I clear the mobile number in login field")
    public void i_clear_the_mobile_number() {
        loginPage.clearMobileNumber();
    }
    
    @Then("the extra digit should not be considered in login")
    public void extra_digit_non_consider_check() {
    	Assert.assertTrue(loginPage.getMobileNumberValue().length()==10,"Invalid mobile number is considering for otp");
    }
    
    @And("I enter non-email format in email coloumn")
    public void i_enter_non_format_email() {
    	loginPage.enterEmailAddress("tgamil.com");
    	System.out.println("Entered non email formatted email id.");
    }
    
    @Then("the Email is not valid error should be visible")
    public void Email_is_not_valid_error_verify() {
    	Assert.assertEquals(loginPage.get_invalid_otp_error_messsage("Email is not valid"),"Email is not valid");
    }
    
    @And("I clear the email address field")
    public void i_clear_the_email_address() {
    	loginPage.clearEmailAddress();
    	System.out.println("Cleared email address");
    }
    
    @And("I enter formatted non existing email id")
    public void i_enter_formatted_invalid_email() {
    	loginPage.enterEmailAddress("b@gmail.com");
    	System.out.println("Entered email formatted non existing email id.");
    }
    
    @Then("the Login failed error should be displayed")
    public void login_failed_error_verify() {
    	Assert.assertEquals(loginPage.get_invalid_otp_error_messsage("Login failed."),"Login failed. Please reach out to our support team");
    }
    
    @And("I enter an unregistered email")
    public void enter_valid_unregistered_emailid(){
    	loginPage.enterEmailAddress("thanuja213@gmail.com");
    	System.out.println("Entered email formatted non existing email id.");
    }
    
    @And("the email not registered error should be displayed")
    public void unregistered_emailid_error_verify() {
    	Assert.assertEquals(loginPage.get_invalid_otp_error_messsage("not registered"),"This email is not registered with us");
    }
    
    @And("I manually enter the invalid OTP")
    public void enter_invalid_otp() {
    	loginPage.enterInvalidOTP("123456");
    }
    
    @Then("the invalid OTP error should be visible in login")
    public void i_should_get_invalid_otp_error_message() {
    	Assert.assertEquals(loginPage.get_invalid_otp_error_messsage(),"This OTP is not valid");
    }
    
    @And("I wait till the OTP expires in login")
    public void i_wait_till_otp_expired() {
    	loginPage.waitTillOTPExpires();
    	System.out.println("Waited till the OTP expires");
    }
    
    @And("I enter the expired OTP manually for login")
    public void i_enter_expired_otp() {
    	loginPage.enterExpiredOTPManually();
    	System.out.println("Entered Expired OTP");
    }
    
    @And("I click on the profile icon")
    public void i_click_profile_button() {
    	loginPage.clickProfileIcon();
    	System.out.println("CLicked the Profile Icon.");
    }
    
    @And("I click on the SignOut button")
    public void i_click_sign_out_button() {
    	loginPage.clickSignOutButton();
    	System.out.println("CLicked the Sign Out Button.");
    }
    
    @Then("the Login button should be visible")
    public void login_button_verified() {
        Assert.assertTrue(
            loginPage.verifyLoginPage(),
            "Still Signed in. No successful Sign Out."
        );
        System.out.println("Successfully logged out.");
    }
}