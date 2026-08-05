
package lab6;
import java.util.List;

import org.openqa.selenium.By;
import java.time.Duration;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Lab6 {
  public static void main(String[] args) {
    WebDriverManager.chromedriver().setup();
	
	WebDriver driver=new EdgeDriver();
	driver.manage().window().maximize();
	driver.get("https://tutorialsninja.com/demo/");
	

    driver.findElement(By.xpath("//span[text()='My Account']")).click();
    driver.findElement(By.linkText("Login")).click();
    driver.findElement(By.xpath("//input[@name='email']")).sendKeys("thanuja1234@gmail.com");
    driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Password@123");
    driver.findElement(By.xpath("//input[@type='submit']")).click();
    driver.findElement(By.xpath("//a[text()='Components']")).click();
    driver.findElement(By.xpath("//a[text()='Monitors (2)']")).click();
    
    WebElement showDropdown = driver.findElement(By.cssSelector("select[id=\"input-limit\"]"));
	Select select=new Select(showDropdown);
	select.selectByVisibleText("25");
	List<WebElement> addToCarts=driver.findElements(By.xpath("//span[text()='Add to Cart']"));
    addToCarts.get(0).click();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    wait.until(ExpectedConditions.visibilityOfElementLocated(
        By.linkText("Specification")
    ));

    driver.findElement(By.linkText("Specification")).click();
    
    driver.findElement(By.xpath("//button[@data-original-title='Add to Wish List']")).click();

    WebElement successMessage = wait.until(
        ExpectedConditions.visibilityOfElementLocated(
            By.cssSelector(".alert.alert-success")
        )
    );

    String actualMessage = successMessage.getText();
    System.out.println(actualMessage);

    String expectedMessage = "Success: You have added Apple Cinema 30\" to your wish list!";

    if (actualMessage.contains(expectedMessage)) {
        System.out.println("Message Verified");
    } else {
        System.out.println("Message Not Verified");
        System.out.println(actualMessage);
    }
    driver.findElement(By.xpath("//input[@name='search']")).sendKeys("Mobile");
    driver.findElement(By.xpath("//button[@class='btn btn-default btn-lg']")).click();
    driver.findElement(By.id("description")).click();
    driver.findElement(By.id("button-search")).click();
    driver.findElement(By.linkText("HTC Touch HD")).click();
    driver.findElement(By.id("input-quantity")).clear();
    driver.findElement(By.id("input-quantity")).sendKeys("3");
    driver.findElement(By.id("button-cart")).click();

    WebElement successMessage1 = wait.until(
        ExpectedConditions.visibilityOfElementLocated(
            By.cssSelector(".alert.alert-success")
        )
    );

    String actualMessage1 = successMessage1.getText();

    String expectedMessage1 = "Success: You have added HTC Touch HD to your shopping cart!";

    if (actualMessage1.contains(expectedMessage1)) {
        System.out.println("Message Verified");
    } else {
        System.out.println("Message Not Verified");
        System.out.println(actualMessage1);
    }
    driver.findElement(By.xpath("//div[@id='cart']//button")).click();
    String mobilename=driver.findElement(By.xpath("//td[@class='text-left']//a")).getText();
    if(mobilename.equals("HTC Touch HD")) {
    	System.out.println("Mobile name matched!");
    }else {
    	System.out.println("Mobile name missmatched!");
    }
    driver.findElement(By.linkText("Checkout")).click();
    driver.findElement(By.xpath("//a[@title='My Account']")).click();
    driver.findElement(By.xpath("//a[text()='Logout']")).click();
    String logoutMessage=driver.findElement(By.xpath("//div[@id='content']//h1")).getText();
    if(logoutMessage.equals("Account Logout")) {
    	System.out.println("Account Logout Verified!");
    }else {
    	System.out.println("Account logout verification failed!");
    }
    driver.findElement(By.linkText("Continue")).click();
    driver.close();
   
	
  }
  
}