package package1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
 
public class POM_properties {
 
    WebDriver driver;
    String desktops = Repository_readfromproperties.getlocator("Desktops");
    String macs = Repository_readfromproperties.getlocator("Mac1");
    String macHeading1 = Repository_readfromproperties.getlocator("macHeading");
    String sortdown = Repository_readfromproperties.getlocator("sortDown");
    String AddtoCart = Repository_readfromproperties.getlocator("Addtocart");
    String successmessage = Repository_readfromproperties.getlocator("successMessage");
    String searchbox =Repository_readfromproperties.getlocator("searchbox");
    String searchbutton = Repository_readfromproperties.getlocator("searchbutton");
    String resultpageheading = Repository_readfromproperties.getlocator("resultpageheading");
   
    By Desktops = getBy(desktops);
    By Mac1 = getBy(macs);
    By macHeading = getBy(macHeading1);
    By sortDown = getBy(sortdown);
    By Addtocart = getBy(AddtoCart);
    By successMessage = getBy(successmessage);
    
    By searchBox = getBy(searchbox);
    By searchButton = getBy(searchbutton);
    By ResultPageHeading = getBy(resultpageheading);
    
 
  
    public POM_properties(WebDriver driver) {
        this.driver = driver;
    }
 
 
    private By getBy(String locator) {
 
        String[] parts = locator.split(":", 2);
 
        String type = parts[0];
        String value = parts[1];
 
        if (type.equalsIgnoreCase("name")) {
 
            return By.name(value);
 
        } else if (type.equalsIgnoreCase("id")) {
 
            return By.id(value);
 
        } else if (type.equalsIgnoreCase("xpath")) {
 
            return By.xpath(value);
 
        } else if (type.equalsIgnoreCase("css")) {
 
            return By.cssSelector(value);
 
        } else {
 
            throw new RuntimeException("Invalid Locator type: " + type);
        }
    }
    
    public void gotoMacPage() {
		driver.findElement(Desktops).click();
		Reporter.log("Clicked on Desktops", true);
		driver.findElement(Mac1).click();
		
	}
	public String getMacHeading() {
		return driver.findElement(macHeading).getText();
	}
	
	public void addToCart(String sortOption) {
		WebElement sortDropdown = driver.findElement(sortDown);
		sortDropdown.click();
		Select select = new Select(sortDropdown);
		select.selectByVisibleText(sortOption);
		driver.findElement(Addtocart).click();
		
	}
	
	public String getSuccessMessage() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
		WebElement successMessage1 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(successMessage));
		String actualMessage = successMessage1.getText();
		return actualMessage;
	}

 
    public void searchText(String firstSearch, String secondSearch) {
		WebElement searchBoxElement = driver.findElement(searchBox);
		searchBoxElement.sendKeys(firstSearch);
		searchBoxElement.clear();
		searchBoxElement.sendKeys(secondSearch);
		driver.findElement(searchButton).click();

	}

	public String resultPageHeading() {
		return driver.findElement(ResultPageHeading).getText();

	}
}