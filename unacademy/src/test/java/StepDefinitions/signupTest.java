package StepDefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import Pages.SignupPage;
import Utilities.DriverManager;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class signupTest {

    WebDriver driver;
    SignupPage signupPage;


    @Given("I am on the Unacademy home page")
    public void i_am_on_the_unacademy_signup_page() {
        driver = DriverManager.getDriver();
        signupPage = new SignupPage(driver);
        System.out.println("Unacademy home page opened.");
    }


    @When("I click on Join for free")
    public void i_click_on_join_for_free() {
        signupPage.clickJoinForFree();
    }


    @And("I enter a valid signup mobile number")
    public void i_enter_a_valid_signup_mobile_number() {
        signupPage.enterMobileNumber("1234567890");
    }


    @And("I click on Signup Continue")
    public void i_click_on_signup_continue() {
        signupPage.clickContinue();
    }


    @And("I enter the OTP manually")
    public void i_enter_the_otp_manually() {
        signupPage.waitForManualOTP();
    }
    
    @And("I enter an invalid missing digits mobile number")
    public void i_enter_an_invalid_signup_mobile_number() {
        signupPage.enterMobileNumber("12345");
    }
    
    @And("I enter an invalid extra digits mobile number")
    public void i_enter_an_invalid_extra_mobile_number() {
        signupPage.enterMobileNumber("1234567890123");
    }
    
    @Then("the extra digit should not be considered")
    public void extra_digit_non_consider_check() {
    	Assert.assertTrue(signupPage.getMobileNumberValue().length()==10,"Invalid mobile number is considering for otp");
    }
    
    @Then("the Continue button should remain disabled")
    public void the_continue_button_should_remain_disabled() {
        Assert.assertFalse(
            signupPage.isContinueButtonEnabled(),
            "Continue button became enabled for an invalid mobile number."
        );
    }
   
    @And("I clear the mobile number")
    public void i_clear_the_mobile_number() {
        signupPage.clearMobileNumber();
    }
    
    @Then("I should remain on the signup page")
    public void i_should_remain_on_signup_page() {
        Assert.assertFalse(
            signupPage.isOTPFieldDisplayed(),
            "OTP screen appeared for an invalid mobile number."
        );
    }
    
    @Then("I should be registered successfully")
    public void i_should_be_registered_successfully() {
        Assert.assertTrue(
            signupPage.isHomePageDisplayed(),
            "Home page was not displayed after successful signup."
        );

        System.out.println("Registration completed successfully.");
    }
    
    @And("I enter the invalid OTP")
    public void i_entered_invalid_otp() {
    	signupPage.enterInvalidOTP();
    	System.out.println("Entered invalid OTP");
    }
    
    @And("I wait till the OTP expires")
    public void i_wait_till_otp_expired() {
    	signupPage.waitTillOTPExpires();
    	System.out.println("Waited till the OTP expires");
    }
    
    @And("I enter the expired OTP manually")
    public void i_enter_expired_otp() {
    	signupPage.enterExpiredOTPManually();
    	System.out.println("Entered Expired OTP");
    }
    
    @Then("the invalid OTP error should be visible")
    public void i_should_get_invalid_otp_error_message() {
    	Assert.assertEquals(signupPage.get_invalid_otp_error_messsage(),"This OTP is not valid");
    }
    
    @And("I enter a valid new signup mobile number")
    public void i_enter_a_valid_new_signup_mobile_number() {
        signupPage.enterMobileNumber("1234567890");
    }
    
    @And("I enter my name")
    public void i_enter_my_name() {
        signupPage.enterName("BT");
    }
    
    @And("I select Telangana as state")
    public void i_select_telangana_as_state() {
        signupPage.selectState("Telangana");
    }
    
    @And("I click on Submit")
    public void i_click_on_submit() {
        signupPage.clickSubmit();
    }
    
}