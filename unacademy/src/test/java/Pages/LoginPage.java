package Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

	WebDriver driver;
	WebDriverWait wait;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(65));
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[text()='Log in']")
	WebElement LoginpageButton;

	@FindBy(xpath = "//div[contains(@class,'login-wrapper')]//input[@placeholder='Enter your mobile number']")
	WebElement mobileNumber;

	@FindBy(xpath = "//input[@placeholder='One time password']")
	WebElement otpField;

	@FindBy(xpath = "//button[text()='Login']")
	WebElement LoginButton;

	@FindBy(xpath = "//button[text()='Verify OTP']")
	WebElement VerifyOTPButton;

	@FindBy(xpath = "//h1[contains(normalize-space(),'Crack IIT JEE with Unacademy')]")
	WebElement homePageHeading;

	@FindBy(xpath = "//h6[text()='Continue with email']")
	WebElement continueWithEmailButton;

	@FindBy(xpath = "//input[@placeholder='Email address']")
	WebElement emailAddressField;

	@FindBy(xpath = "//p[@color='var(--color-i-red)']")
	WebElement emailErrorMessage;

	@FindBy(xpath = "//p[@color='var(--color-i-red)']")
	WebElement invalidOTPerrorMessage;

    @FindBy(xpath="//h6[text()='Resend OTP ']")
    WebElement resendOTPButton;
    
    // @FindBy(xpath="//img[@height='32px']")
    //WebElement profileIcon;
    
    @FindBy(xpath="//p[text()='Sign out']")
    WebElement SignOutButton;

    By profileIconLocator =
    	    By.xpath("//div[contains(@class,'ProfileAvatarWrapper')]//img");
    
	public void gotoLoginPage() {
		wait.until(ExpectedConditions.elementToBeClickable(LoginpageButton));
		LoginpageButton.click();
	}

	public void enterMobileNumber(String mobile) {
		wait.until(ExpectedConditions.visibilityOf(mobileNumber));
		mobileNumber.sendKeys(mobile);
	}

	public void clickLogin() {
		wait.until(ExpectedConditions.elementToBeClickable(LoginButton));
		LoginButton.click();
	}

	public void waitForManualOTP() {
		System.out.println("Please enter the REAL OTP in the browser...");
		wait.until(driver -> {
			String otp = (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].value;", otpField);
			return otp != null && otp.length() == 6;
		});

		System.out.println("6-digit OTP entered successfully.");
	}

	public void clickVerifyOTP() {
		wait.until(ExpectedConditions.elementToBeClickable(VerifyOTPButton));
		VerifyOTPButton.click();
		System.out.println("Clicked verify OTP Button");
	}

	public boolean isHomePageDisplayed() {
	    wait.until(ExpectedConditions.visibilityOfElementLocated(
	        profileIconLocator
	    ));
	    return true;
	}

	public void clickContinueWithEmailButton() {
		wait.until(ExpectedConditions.visibilityOf(continueWithEmailButton));
		continueWithEmailButton.click();
	}

	public void enterEmailAddress(String emailid) {
		wait.until(ExpectedConditions.visibilityOf(emailAddressField));
		emailAddressField.sendKeys(emailid);
	}

	public boolean isOTPFieldDisplayed() {
		try {
			return otpField.isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}

	public void clearMobileNumber() {
		mobileNumber.clear();
	}

	public String getMobileNumberValue() {
		return mobileNumber.getAttribute("value");
	}

	public String get_invalid_otp_error_messsage(String expectedMessage) {
		wait.until(ExpectedConditions.visibilityOf(emailErrorMessage));
		wait.until(ExpectedConditions.textToBePresentInElement(emailErrorMessage, expectedMessage));
		return emailErrorMessage.getText();
	}

	public void clearEmailAddress() {

		wait.until(ExpectedConditions.elementToBeClickable(emailAddressField));

		emailAddressField.click();
		emailAddressField.sendKeys(Keys.CONTROL, "a");
		emailAddressField.sendKeys(Keys.BACK_SPACE);
	}

	public void enterInvalidOTP(String string) {
		wait.until(ExpectedConditions.visibilityOf(otpField));
		otpField.sendKeys("123456");
	}
	
	public String get_invalid_otp_error_messsage() {
    	wait.until(ExpectedConditions.visibilityOf(invalidOTPerrorMessage));
    	return invalidOTPerrorMessage.getText();
    }

	public void enterExpiredOTPManually() {
		System.out.println("Please enter the EXPIRED OTP in the browser...");
        wait.until(driver -> {
            String otp = (String) ((JavascriptExecutor) driver)
                    .executeScript("return arguments[0].value;", otpField);
            return otp != null && otp.length() == 6;
        });
        System.out.println("6-digit OTP entered successfully.");
	}

	public void waitTillOTPExpires() {
		wait.until(ExpectedConditions.visibilityOf(resendOTPButton));
	}

	public void clickProfileIcon() {
	    WebElement profile = wait.until(
	        ExpectedConditions.elementToBeClickable(profileIconLocator)
	    );
	    profile.click();
	    System.out.println("Clicked the Profile Icon.");
	}
	
	public void clickSignOutButton() {
		wait.until(ExpectedConditions.visibilityOf(SignOutButton));
		SignOutButton.click();
	}

	public boolean verifyLoginPage() {
	    wait.until(ExpectedConditions.visibilityOf(LoginpageButton));
	    try {
	        return LoginpageButton.isDisplayed();
	    } catch (Exception e) {
	        return false;
	    }
	}
}