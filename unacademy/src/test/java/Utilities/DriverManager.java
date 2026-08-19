package Utilities;

import org.openqa.selenium.WebDriver;

public class DriverManager {

    private static WebDriver driver;

    public static void setDriver(WebDriver driver) {
        DriverManager.driver = driver;
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static void quitDriver() {

        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}