
import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.Reporter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SearchTest {

	@Test
	public void searchFlowtest() throws InterruptedException {
		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();
		Reporter.log("Launching Browser", true);
		driver.get("https://tutorialsninja.com/demo/");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@name='search']")).sendKeys("Mobile");
		driver.findElement(By.xpath("//input[@name='search']")).clear();
		Reporter.log("Searching Monitors", true);
		driver.findElement(By.xpath("//input[@name='search']")).sendKeys("Monitors");
		driver.findElement(By.xpath("//button[@class='btn btn-default btn-lg']")).click();

		// checking the result page is correct to the search
		String resultPageHeading = driver.findElement(By.xpath("//div[@id='content']//h1")).getText();
		Assert.assertEquals("Search - Monitors", resultPageHeading);
		Reporter.log("Search Verified", true);
		driver.close();
	}

}