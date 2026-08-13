package StepDefinitions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class logintest {
	WebDriver driver;
@Given("Open the OrangeHRM login page")
public void open_the_orange_hrm_login_page() {
	WebDriverManager.chromedriver().setup();
	driver=new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
}

@When("Enter the username {string}")
public void enter_the_username(String string) {
	driver.findElement(By.name("username")).sendKeys("Admin");
}

@And("Enter the password {string}")
public void enter_the_password(String string) {
		driver.findElement(By.name("password")).sendKeys("admin123");
}

@And("Click on login button")
public void click_on_login_button() {
	driver.findElement(By.xpath("//button[@type='submit']")).click();
}

@Then("Dashboard page should be displayed")
public void dashboard_page_should_be_displayed() {
	WebElement Dashboard=driver.findElement(By.xpath("//h6[text()='Dashboard']"));
	if(Dashboard.isDisplayed()){	
		Assert.assertTrue(true);
	}
	else
	{Assert.fail("Login Failed: Dashboard not displayed");	
	}
}



}
