package package1;

import org.openqa.selenium.By;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;
public class POMLocators {
	WebDriver driver;
	By Desktops = By.xpath("//a[text()='Desktops']");
	By Mac1 = By.xpath("//a[text()='Mac (1)']");
	By macHeading =By.cssSelector("h2");
	By sortDown = By.xpath("//select[@id='input-sort']");
	By Addtocart = By.xpath("//span[text()='Add to Cart']");
	By successMessage = By.cssSelector(".alert.alert-success");
	By searchBox = By.xpath("//input[@name='search']");
	By searchButton = By.xpath("//button[@class='btn btn-default btn-lg']");
	By resultPageHeading = By.xpath("//div[@id='content']//h1");
	public POMLocators(WebDriver driver){
		this.driver = driver;
	}
	
	public void gotoMacPage() {
		driver.findElement(Desktops).click();
		Reporter.log("Clicked on Desktops", true);
		driver.findElement(Mac1).click();
		
	}
	public String getMacHeading() {
		return driver.findElement(macHeading).getText();
	}
	
	public void addtoCart(String sortOption) {
		WebElement sortDropdown = driver.findElement(sortDown);
		sortDropdown.click();
		Select select = new Select(sortDropdown);
		select.selectByVisibleText(sortOption);
		driver.findElement(Addtocart).click();
		
	}
	
	public String verifySuccessMessage() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
		WebElement successMessage1 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(successMessage));
		String actualMessage = successMessage1.getText();
		//Assert.assertTrue(actualMessage.contains("Success: You have added iMac to your shopping cart!"));
		//Reporter.log("Add to Cart Verified", true);
		return actualMessage;
	}
	
	public void searchText(String firstSearch,String secondSearch) {
		WebElement searchBoxElement = driver.findElement(searchBox);
		searchBoxElement.sendKeys(firstSearch);
		searchBoxElement.clear();
		searchBoxElement.sendKeys(secondSearch);
		driver.findElement(searchButton).click();
		
	}
	
	public String resultPageHeading() {
		return driver.findElement(resultPageHeading).getText();
		//Assert.assertEquals("Search - "+secondSearch, resultPageHeading1);
		//Reporter.log("Search Verified", true);
		
	}
}
