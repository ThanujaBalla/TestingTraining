
import org.junit.Test;
import static org.junit.Assert.*;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class SearchTest {

	@Test
	public void searchFlowtest() throws InterruptedException {
		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		driver.get("https://tutorialsninja.com/demo/");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@name='search']")).sendKeys("Mobile");
		driver.findElement(By.xpath("//input[@name='search']")).clear();
		driver.findElement(By.xpath("//input[@name='search']")).sendKeys("Monitors");
		driver.findElement(By.xpath("//button[@class='btn btn-default btn-lg']")).click();

		// checking the result page is correct to the search
		String resultPageHeading = driver.findElement(By.xpath("//div[@id='content']//h1")).getText();
		assertEquals("Search - Monitors", resultPageHeading);

		driver.close();
	}

}
