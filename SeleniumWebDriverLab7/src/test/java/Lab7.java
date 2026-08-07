import java.util.List;

import org.openqa.selenium.By;
import java.time.Duration;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.Alert;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.JavascriptExecutor;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Lab7 {

	public static void main(String[] args) {
		// TODO Auto-generated alerts 
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver=new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://letcode.in/alert/");
		
		//Simple alert Handling
		driver.findElement(By.xpath("//button[text()='Simple Alert']")).click();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Alert alert = driver.switchTo().alert();
		System.out.println(alert.getText());
		alert.accept();
		
		//Confirm alert Handling
		driver.findElement(By.xpath("//button[text()='Confirm Alert']")).click();
		alert = driver.switchTo().alert();
		System.out.println(alert.getText());
		alert.dismiss();
		
		//prompt alert handling
		driver.findElement(By.xpath("//button[text()='Prompt Alert']")).click();
		alert = driver.switchTo().alert();
		System.out.println(alert.getText());
		alert.sendKeys("Thanuja");
		alert.accept();
		System.out.println(driver.findElement(By.xpath("//p[@id='myName']")).getText());
		
		//modern alert handling
		WebElement modernAlert = driver.findElement(By.xpath("//button[text()='Modern Alert']"));
		System.out.println(modernAlert.getText());
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", modernAlert);
		//modernAlert.click();
		js.executeScript("arguments[0].click();", modernAlert);
		System.out.println(driver.findElement(By.xpath("//div[@class='card-content']//p")).getText());
		driver.findElement(By.xpath("//button[@aria-label='close']")).click();
		
		driver.close();

	}

}
