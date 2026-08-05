package com.testing.test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class personalDetailsFeildsVerify {
  public static void main(String[] args) {
    WebDriverManager.chromedriver().setup();
	
	WebDriver driver=new EdgeDriver();
	driver.manage().window().maximize();
	driver.get("https://tutorialsninja.com/demo/");
    System.out.println("The tile of opencart page is:"+driver.getTitle());
    
    driver.findElement(By.xpath("//span[text()='My Account']")).click();
    driver.findElement(By.linkText("Register")).click();
    
    driver.findElement(By.id("input-firstname")).sendKeys("abcdefghijklmnopqrstuvwxyzabcdefg");
    
    driver.findElement(By.xpath("//input[@name='newsletter' and @value='1']")).click();
    driver.findElement(By.name("agree")).click();
    driver.findElement(By.cssSelector("input.btn.btn-primary")).click();
    String expectedwarning = "First Name must be between 1 and 32 characters!";
    String actualwarning=driver.findElement(By.xpath("//div[text()='First Name must be between 1 and 32 characters!']")).getText();
    if(expectedwarning.equals(actualwarning)) {
    	System.out.println("FirstName warning verification successfull!");
    }else {
    	System.out.println("FirstName warning didn't match the requirement.");
    }
    driver.findElement(By.id("input-firstname")).clear();
    driver.findElement(By.id("input-firstname")).sendKeys("Thanuja");

    
    //lastname warnings verification
    driver.findElement(By.id("input-lastname")).sendKeys("abcdefghijklmnopqrstuvwxyzabcdefg");
    driver.findElement(By.cssSelector("input.btn.btn-primary")).click();
    String expectedwarning1 = "Last Name must be between 1 and 32 characters!";
    String actualwarning1=driver.findElement(By.xpath("//div[text()='Last Name must be between 1 and 32 characters!']")).getText();
    if(expectedwarning1.equals(actualwarning1)) {
    	System.out.println("LastName warning verification successfull!");
    }else {
    	System.out.println("LastName warning didn't match the requirement.");
    }
    driver.findElement(By.id("input-lastname")).clear();
    driver.findElement(By.id("input-lastname")).sendKeys("Balla");
    
    //giving Valid email and phone number 
    driver.findElement(By.id("input-email")).sendKeys("thanuja12345@gmail.com");

    driver.findElement(By.id("input-telephone")).sendKeys("9876543210");
    driver.findElement(By.id("input-password")).sendKeys("Password@123");

    driver.findElement(By.id("input-confirm")).sendKeys("Password@123");
    driver.findElement(By.xpath("//input[@name='newsletter' and @value='0']")).click();
    driver.findElement(By.cssSelector("input.btn.btn-primary")).click();
    String successMessage=driver.findElement(By.xpath("//div[@id='content']//h1")).getText();
	if(successMessage.equals("Your Account Has Been Created!")) {
		System.out.println("Account created successfully!");
	}else {
		System.out.println("Account creation Failed!");
	}
	driver.findElement(By.cssSelector("a.btn.btn-primary")).click();
	driver.findElement(By.xpath("//a[text()='View your order history']")).click();
	driver.close();
  }
  
}
