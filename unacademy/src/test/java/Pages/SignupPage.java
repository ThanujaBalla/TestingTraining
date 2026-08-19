package Pages;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;

public class SignupPage {

    WebDriver driver;
    WebDriverWait wait;

    public SignupPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(65));
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//header//button[.//span[normalize-space()='Join for free']]")
    WebElement joinForFreeButton;

    @FindBy(xpath = "//div[@class='login-wrapper css-1cb62fb-Wrapper e10p360r0']//input")
    WebElement mobileNumber;

    @FindBy(xpath = "//div[@class='login-wrapper css-1cb62fb-Wrapper e10p360r0']//button")
    WebElement continueButton;

    @FindBy(xpath = "//input[@placeholder='One time password']")
    WebElement otpField;

    @FindBy(xpath = "//h1[contains(normalize-space(),'Crack IIT JEE with Unacademy')]")
    WebElement homePageHeading;
    
    @FindBy(xpath="//p[@color='var(--color-i-red)']")
    WebElement invalidOTPerrorMessage;
    
    @FindBy(xpath="//h6[text()='Resend OTP ']")
    WebElement resendOTPButton;
    
    @FindBy(xpath = "//input[@placeholder='Name']")
    WebElement nameField;
    
    @FindBy(xpath = "//button[contains(normalize-space(),'Select - State of residence')]")
    WebElement stateDropdown;
    
    @FindBy(xpath = "//li[.//span[normalize-space()='Telangana']]")
    WebElement telanganaOption;
    
    @FindBy(xpath = "//button[@aria-label='Submit']")
    WebElement verifyButton;
    
    public void clickJoinForFree() {
        wait.until(ExpectedConditions.elementToBeClickable(joinForFreeButton));
        joinForFreeButton.click();
    }


    public void enterMobileNumber(String mobile) {
        wait.until(ExpectedConditions.visibilityOf(mobileNumber));
        mobileNumber.sendKeys(mobile);
    }


    public void clickContinue() {
        wait.until(ExpectedConditions.elementToBeClickable(continueButton));
        continueButton.click();
    }
    
    public void waitForManualOTP() {
        System.out.println("Please enter the REAL OTP in the browser...");
        wait.until(driver -> {
            String otp = (String) ((JavascriptExecutor) driver)
                    .executeScript("return arguments[0].value;", otpField);
            return otp != null && otp.length() == 6;
        });
        System.out.println("6-digit OTP entered successfully.");
    }
    
    public String getMobileNumberValue() {
        return mobileNumber.getAttribute("value");
    }
    
    public boolean isContinueButtonEnabled() {
        System.out.println("Button enabled: " + continueButton.isEnabled());
        System.out.println("disabled attribute: " + continueButton.getAttribute("disabled"));
        System.out.println("aria-disabled: " + continueButton.getAttribute("aria-disabled"));
        System.out.println("class: " + continueButton.getAttribute("class"));
        return continueButton.isEnabled();
    }
    
    public boolean isHomePageDisplayed() {
        wait.until(ExpectedConditions.visibilityOf(homePageHeading));
        return homePageHeading.isDisplayed();
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
   
    public void enterInvalidOTP() {
    	wait.until(ExpectedConditions.visibilityOf(otpField));
    	otpField.sendKeys("123456");
    }
    
    public String get_invalid_otp_error_messsage() {
    	wait.until(ExpectedConditions.visibilityOf(invalidOTPerrorMessage));
    	return invalidOTPerrorMessage.getText();
    }


	public void waitTillOTPExpires() {
		wait.until(ExpectedConditions.visibilityOf(resendOTPButton));
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
	
	public void enterName(String name) {
	    wait.until(ExpectedConditions.visibilityOf(nameField));
	    nameField.sendKeys(name);
	}
	
	public void clickStateDropdown() {
	    wait.until(ExpectedConditions.elementToBeClickable(stateDropdown));
	    stateDropdown.click();
	}
	
	public void selectState(String state) {
	    wait.until(ExpectedConditions.elementToBeClickable(stateDropdown));
	    stateDropdown.click();
	    wait.until(ExpectedConditions.elementToBeClickable(
	        telanganaOption
	    ));
	    telanganaOption.click();
	}
	public void clickSubmit() {
	    wait.until(ExpectedConditions.elementToBeClickable(verifyButton));
	    verifyButton.click();
	}
}