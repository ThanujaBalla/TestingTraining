# Lab Demo: Extent Reports with Selenium & TestNG

## Objective

To integrate **Extent Reports** with Selenium WebDriver and TestNG to generate detailed HTML reports containing test execution status, logs, and screenshots.

## Test Flow

The OpenCart application is automated using Selenium WebDriver.

### Desktop Test

1. Open OpenCart.
2. Navigate to **Desktops → Mac**.
3. Verify the Mac page heading.
4. Sort the products using DataProvider.
5. Add iMac to the cart.
6. Verify the success message.
7. Capture a screenshot.
8. Add the result and screenshot to the Extent Report.

### Search Test

1. Open OpenCart.
2. Enter search data.
3. Search for the required product.
4. Verify the search result heading.
5. Capture a screenshot.
6. Add the result and screenshot to the Extent Report.

---

## TestNG DataProvider

The Desktop test uses DataProvider to execute the same flow with different sorting options:

```java
@DataProvider(name = "sortData")
public Object[][] sortData() {
    return new Object[][] {
        {"Name (A - Z)"},
        {"Name (Z - A)"}
    };
}
```

The Search test uses:

```java
@DataProvider(name = "searchData")
public Object[][] searchData() {
    return new Object[][] {
        {"Mobile", "Monitors"},
        {"Laptop", "Phones"},
        {"Camera", "Cameras"}
    };
}
```

Therefore, the same test method is executed multiple times with different test data.

---

## Extent Reports

A single Extent Report is created in `BaseTest` and shared by all test classes.

```java
protected static ExtentReports extent;

@BeforeSuite
public void setup() {

    ExtentSparkReporter reporter =
        new ExtentSparkReporter(
            projectpath + "\\Reports\\TestExecutionReport.html"
        );

    reporter.config().setReportName("Test Execution Report");

    extent = new ExtentReports();
    extent.attachReporter(reporter);

    extent.setSystemInfo("Tester", "Pooja");
    extent.setSystemInfo("Browser", "Chrome");
    extent.setSystemInfo("Environment", "QA");
}
```

The `static` ExtentReports object allows both `DesktopTest` and `SearchTest` to use the same report.

The report is flushed only after the complete suite finishes:

```java
@AfterSuite
public void tearDown() {

    if (extent != null) {
        extent.flush();
    }

    if (driver != null) {
        driver.quit();
    }
}
```

---

## Creating Extent Tests

Each DataProvider execution gets a separate test entry:

```java
ExtentTest test =
    extent.createTest("AddtoCartTest - " + sortOption);
```

For example:

```text
AddtoCartTest - Name (A - Z)
AddtoCartTest - Name (Z - A)
```

Similarly, SearchTest creates separate entries for each search.

---

## Screenshot Capture

Screenshots are captured using Selenium's `TakesScreenshot`:

```java
public String capturescreenshot(String testname)
        throws IOException {

    TakesScreenshot ts =
        (TakesScreenshot) driver;

    File source =
        ts.getScreenshotAs(OutputType.FILE);

    String spath =
        projectpath + "\\Screenshots\\"
        + testname + ".png";

    File destination =
        new File(spath);

    FileUtils.copyFile(source, destination);

    return spath;
}
```

The screenshot is then attached to the Extent Report:

```java
test.pass("Added to cart Successfully!")
    .addScreenCaptureFromPath(
        capturescreenshot(screenshotName)
    );
```

Unique names are used so that screenshots from different DataProvider executions do not overwrite each other.

Example:

```text
Screenshots/
├── AddtoCart_Name_A_Z.png
├── AddtoCart_Name_Z_A.png
├── Search_Monitors.png
├── Search_Phones.png
└── Search_Cameras.png
```

---

## Project Structure

```text
Project
│
├── src/test/java
│   └── package1
│       ├── BaseTest.java
│       ├── DesktopTest.java
│       ├── SearchTest.java
│       └── POMLocators.java
│
├── Reports
│   └── TestExecutionReport.html
│
├── Screenshots
│   ├── AddtoCart_Name_A_Z.png
│   ├── AddtoCart_Name_Z_A.png
│   ├── Search_Monitors.png
│   ├── Search_Phones.png
│   └── Search_Cameras.png
│
└── pom.xml
```

## Technologies Used

* Java
* Selenium WebDriver
* TestNG
* Maven
* Extent Reports
* Apache Commons IO
* ChromeDriver
* Page Object Model
* TestNG DataProvider

## Result

The test suite was successfully executed with **Extent Reports**. A single HTML report contains the execution results of both test classes, individual DataProvider executions, status information, and screenshots.

## Extent Report Result
<img width="1359" height="557" alt="image" src="https://github.com/user-attachments/assets/f4200f1d-69d3-4b1f-b8ba-79d452b9ce51" />
<img width="1353" height="536" alt="image" src="https://github.com/user-attachments/assets/bd978cd1-0683-43db-b52e-15456dc7edda" />


## TestNG Result
<img width="870" height="616" alt="image" src="https://github.com/user-attachments/assets/ce96be4b-ce68-48ea-9c6d-443ff3378f8c" />
<img width="588" height="645" alt="image" src="https://github.com/user-attachments/assets/e2f990a6-a244-4dea-a365-fd8d60396c19" />


