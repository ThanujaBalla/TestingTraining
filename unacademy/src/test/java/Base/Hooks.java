package Base;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import Reports.ExtentManager;
import Utilities.ConfigReader;
import Utilities.DriverManager;
import Utilities.ScreenShotUtility;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;


public class Hooks {
	private static ExtentReports extent = ExtentManager.getExtentReports();
	private static ExtentTest test;

	@Before
	public void setUp(Scenario scenario) {
		String browser = ConfigReader.getProperty("browser");
		WebDriver driver;
		if (scenario.getSourceTagNames().contains("@chrome")) {
            browser = "chrome";
        } else if (scenario.getSourceTagNames().contains("@firefox")) {
            browser = "firefox";
        } else if (scenario.getSourceTagNames().contains("@edge")) {
            browser = "edge";
        }
		if (browser.equalsIgnoreCase("chrome")) {
			System.out.println("Launching Chrome...");
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("firefox")) {
			System.out.println("Firefox is not installed.");
            System.out.println("Using Chrome as fallback for local execution.");
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("edge")) {
			System.out.println("Launching Edge...");
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		} else {
			throw new RuntimeException("Unsupported browser: " + browser);
		}
		driver.manage().window().maximize();
		DriverManager.setDriver(driver);
		driver.get(ConfigReader.getProperty("url"));
		
		test = extent.createTest(scenario.getName());
		test.info("Browser: " + browser);
		test.info("Scenario started");
		System.out.println("====================================");
		System.out.println("Scenario: " + scenario.getName());
		System.out.println("Browser: " + browser);
		System.out.println("====================================");
	}

	@After
	public void tearDown(Scenario scenario) {
		WebDriver driver = DriverManager.getDriver();
		try {
			/*
			 * Capture screenshot for EVERY scenario.
			 */
			String screenshotPath = ScreenShotUtility.captureScreenshot(driver, scenario.getName());
			test.addScreenCaptureFromPath(screenshotPath);
			/*
			 * Mark scenario PASS/FAIL
			 */
			if (scenario.isFailed()) {
				test.fail("Scenario FAILED");
				test.fail("Cucumber Status: " + scenario.getStatus());
			} else {
				test.pass("Scenario PASSED");
			}
		} catch (IOException e) {
			test.warning("Screenshot could not be captured: " + e.getMessage());
		}
		DriverManager.quitDriver();
	}
}