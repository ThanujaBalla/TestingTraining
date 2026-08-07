package com.test;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.Assert;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;
public class MultiBrowserTest {
	public void executeFlow(WebDriver driver) throws InterruptedException {
		driver.get("https://tutorialsninja.com/demo/");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[text()='Desktops']")).click();
		Reporter.log("Clicked on Desktops", true);
		driver.findElement(By.xpath("//a[text()='Mac (1)']")).click();
		String macHeading = driver.findElement(By.cssSelector("h2")).getText();
		Assert.assertEquals("Mac", macHeading);
		Reporter.log("Verified Mac Heading", true);

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
		Assert.assertTrue(actualMessage.contains("Success: You have added iMac to your shopping cart!"));
		Reporter.log("Add to Cart Verified", true);
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
	
	@Test
	public void chromeTest() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		executeFlow(driver);
	}
	
	@Test
	public void edgeTest() throws InterruptedException {
		WebDriverManager.edgedriver().setup();
		WebDriver driver = new EdgeDriver();
		executeFlow(driver);
	}

}
