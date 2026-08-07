
import org.junit.Test;
import static org.junit.Assert.*;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DesktopTest {

	@Test
	public void DesktopFlowTest() throws InterruptedException {
		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		driver.get("https://tutorialsninja.com/demo/");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[text()='Desktops']")).click();
		driver.findElement(By.xpath("//a[text()='Mac (1)']")).click();
		String macHeading = driver.findElement(By.cssSelector("h2")).getText();
		assertEquals("Mac", macHeading);

		// sorting by A-z
		WebElement sortDropdown = driver.findElement(By.xpath("//select[@id='input-sort']"));
		sortDropdown.click();
		Select select = new Select(sortDropdown);
		select.selectByVisibleText("Name (A - Z)");

		// add to cart
		driver.findElement(By.xpath("//span[text()='Add to Cart']")).click();

		// verify add to cart
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
		WebElement successMessage1 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".alert.alert-success")));

		String actualMessage = successMessage1.getText();
		System.out.println(actualMessage);
		assertTrue(actualMessage.contains("Success: You have added iMac to your shopping cart!"));
		driver.close();
	}

}
