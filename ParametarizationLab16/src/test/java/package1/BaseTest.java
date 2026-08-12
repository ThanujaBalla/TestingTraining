package package1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

	protected static WebDriver driver;

	@BeforeSuite
	public void setup() {
		System.out.println("@BeforeSuite");
	}

	@AfterSuite
	public void tearDown() {
		System.out.println("@AfterSuite");
	}

	@BeforeMethod
	@Parameters("browser")
	public void beforeMethod(String browser) {
		System.out.println("@BeforeMethod");
		Reporter.log("Launching Browser", true);
		if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		} else if (browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else {
			throw new IllegalArgumentException("Invalid browser: " + browser);
		}
		driver.manage().window().maximize();
		driver.get("https://tutorialsninja.com/demo/");
	}

	@AfterMethod
	public void afterMethod() {
		System.out.println("@AfterMethod");
		if (driver != null) {
			driver.quit();
		}
	}

	@BeforeClass
	public void beforeClass() {
		System.out.println("@BeforeClass");
	}

	@AfterClass
	public void afterClass() {
		System.out.println("@AfterClass");
	}

	@BeforeTest
	public void beforeTest() {
		System.out.println("@BeforeTest");

	}

	@AfterTest
	public void afterTest() {
		System.out.println("@AfterTest");

	}
}