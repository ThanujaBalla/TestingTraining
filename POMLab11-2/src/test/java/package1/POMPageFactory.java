package package1;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;

public class POMPageFactory {
	WebDriver driver;
	@FindBy(xpath = "//a[text()='Desktops']")
	WebElement desktops;

	@FindBy(xpath = "//a[text()='Mac (1)']")
	WebElement mac;

	@FindBy(css = "h2")
	WebElement macHeading;

	@FindBy(id = "input-sort")
	WebElement sortDropdown;

	@FindBy(xpath = "//span[text()='Add to Cart']")
	WebElement addToCart;

	@FindBy(css = ".alert.alert-success")
	WebElement successMessage;

	@FindBy(name = "search")
	WebElement searchBox;

	@FindBy(css = "button.btn.btn-default.btn-lg")
	WebElement searchButton;

	@FindBy(xpath = "//div[@id='content']//h1")
	WebElement resultPageHeading;

	public POMPageFactory(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void gotoMacPage() {
		desktops.click();
		Reporter.log("Clicked on Desktops", true);
		mac.click();
		Reporter.log("Clicked on Mac", true);
	}

	public String getMacHeading() {
		return macHeading.getText();
	}

	public void addToCart(String sortOption) {
		Select select = new Select(sortDropdown);
		select.selectByVisibleText(sortOption);
		addToCart.click();
	}

	public String getSuccessMessage() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(successMessage));
		return successMessage.getText();
	}

	public void searchText(String firstSearch, String secondSearch) {
		searchBox.sendKeys(firstSearch);
		searchBox.clear();
		Reporter.log("Searching " + secondSearch, true);
		searchBox.sendKeys(secondSearch);
		searchButton.click();
	}
	public String getResultPageHeading() {
        return resultPageHeading.getText();
    }
}
