package Utilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenShotUtility {

    public static String captureScreenshot(
            WebDriver driver,
            String testName) throws IOException {

        String projectPath = System.getProperty("user.dir");

        String screenshotPath =
                projectPath
                + File.separator
                + "Screenshots"
                + File.separator
                + testName.replaceAll("[^a-zA-Z0-9-_]", "_")
                + ".png";

        File source =
                ((TakesScreenshot) driver)
                .getScreenshotAs(OutputType.FILE);

        File destination = new File(screenshotPath);

        FileUtils.copyFile(source, destination);

        return screenshotPath;
    }
}