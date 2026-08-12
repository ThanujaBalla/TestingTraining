package package1;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

public class POMPageFactory {
	WebDriver driver;
	@FindBy(css = "title")
	WebElement title;

	@FindBy(xpath = "//a[@title='My Account']")
	WebElement myAccount;

	@FindBy(xpath = "//a[text()='Register']")
	WebElement register;

	@FindBy(css = "title")
	WebElement registerTitle;

	@FindBy(xpath = "//input[@id='input-firstname']")
	WebElement firstname;

	@FindBy(xpath = "//input[@id='input-lastname']")
	WebElement lastname;

	@FindBy(xpath = "//input[@id='input-email']")
	WebElement email;

	@FindBy(xpath = "//input[@id='input-telephone']")
	WebElement telephone;

	@FindBy(xpath = "//input[@id='input-password']")
	WebElement password;

	@FindBy(xpath = "//input[@id='input-confirm']")
	WebElement confirmPassword;

	@FindBy(xpath = "//input[@value='0']")
	WebElement Subscribebutton;

	@FindBy(xpath = "//input[@type='checkbox']")
	WebElement policy;

	@FindBy(xpath = "//input[@type='submit']")
	WebElement Continuebutton;

	@FindBy(xpath = "//div[@id='content']//h1")
	WebElement resultPageHeading;

	@FindBy(css = ".alert.alert-danger")
	WebElement registrationWarning;

	public POMPageFactory(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public String getHomePagetitle() {
		return driver.getTitle();
	}

	public void gotoRegisterPage() {
		myAccount.click();
		register.click();
		Reporter.log("Clicked on Register button", true);
	}

	public String verifyRegisterPage() {
		return driver.getTitle();
	}

	public void fillPersonalDetails(String fname, String lname, String emailid, String phno) {
		firstname.sendKeys(fname);
		lastname.sendKeys(lname);
		email.sendKeys(emailid);
		telephone.sendKeys(phno);
		Reporter.log("Filled personal Details", true);
	}

	public void fillPasswords(String fpassword, String cPassword) {
		password.sendKeys(fpassword);
		confirmPassword.sendKeys(cPassword);
		Reporter.log("Filled password Details", true);
	}

	public void submittingForm() {
		Subscribebutton.click();
		policy.click();
		Continuebutton.click();
		Reporter.log("Submitted successfully", true);
	}

	public String getRegistrationResult() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		try {
			wait.until(ExpectedConditions.or(
					ExpectedConditions.textToBePresentInElement(resultPageHeading, "Your Account Has Been Created!"),
					ExpectedConditions.visibilityOf(registrationWarning)));
			if (resultPageHeading.getText().contains("Your Account Has Been Created!")) {
				return resultPageHeading.getText();
			}
			if (registrationWarning.isDisplayed()) {
				return registrationWarning.getText();
			}
		} catch (Exception e) {
			return "Registration result not found";
		}
		return "Registration result not found";
	}

	
}
