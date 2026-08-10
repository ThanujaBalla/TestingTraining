package package1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class POMLocators {
	WebDriver driver;
	String searchbox = XmlObjectRepository.getlocator("searchbox");
	String searchbutton = XmlObjectRepository.getlocator("searchbutton");
	String resultpageheading = XmlObjectRepository.getlocator("resultpageheading");

	By searchBox = getBy(searchbox);
	By searchButton = getBy(searchbutton);
	By resultPageHeading = getBy(resultpageheading);

	public POMLocators(WebDriver driver) {
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

	public void searchText(String firstSearch, String secondSearch) {
		WebElement searchBoxElement = driver.findElement(searchBox);
		searchBoxElement.sendKeys(firstSearch);
		searchBoxElement.clear();
		searchBoxElement.sendKeys(secondSearch);
		driver.findElement(searchButton).click();

	}

	public String resultPageHeading() {
		return driver.findElement(resultPageHeading).getText();

	}
}
