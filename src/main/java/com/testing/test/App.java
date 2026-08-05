package com.testing.test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class App {
  public static void main(String[] args) {
    WebDriverManager.chromedriver().setup();
	
	WebDriver driver=new EdgeDriver();
	driver.manage().window().maximize();
	driver.get("https://tutorialsninja.com/demo/");
	String actualTitle = driver.getTitle();
    String expectedTitle = "Your Store";
    System.out.println("The tile of opencart page is:"+driver.getTitle());
    
    if(actualTitle.equals(expectedTitle)) {
        System.out.println("Title Verified Successfully");
    }
    else {
        System.out.println("Title Verification Failed");
    }
    
    driver.findElement(By.xpath("//span[text()='My Account']")).click();
    driver.findElement(By.linkText("Register")).click();
    String heading = driver.findElement(By.tagName("h1")).getText();

    if (heading.equals("Register Account")) {
        System.out.println("Heading Verified");
    } else {
        System.out.println("Heading Verification Failed");
    }
    
    driver.findElement(By.id("input-firstname")).sendKeys("abcdefghijklmnopqrstuvwxyzabcdefg");
    
    driver.findElement(By.id("input-firstname")).sendKeys("Thanuja");

    driver.findElement(By.id("input-lastname")).sendKeys("Balla");

    driver.findElement(By.id("input-email")).sendKeys("thanuja1234@gmail.com");

    driver.findElement(By.id("input-telephone")).sendKeys("9876543210");

    driver.findElement(By.id("input-password")).sendKeys("Password@123");

    driver.findElement(By.id("input-confirm")).sendKeys("Password@123");
    driver.findElement(By.xpath("//input[@name='newsletter' and @value='1']")).click();
    driver.findElement(By.name("agree")).click();
    driver.findElement(By.cssSelector("input.btn.btn-primary")).click();
	
  }
  
}
