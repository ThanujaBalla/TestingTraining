
# Lab Demo: Extent Reports using TestNG Listener

## Objective

To integrate **Extent Reports with Selenium and TestNG Listener** and generate a single HTML report for multiple test classes with test status and screenshots.

## Test Classes

The project contains two test classes:

- `DesktopTest`
- `SearchTest`

Both classes extend `BaseTest` and use TestNG `@DataProvider`.

## Test Flow

### DesktopTest

1. Open OpenCart.
2. Navigate to **Desktops → Mac**.
3. Verify the Mac heading.
4. Sort products using different sorting options.
5. Add iMac to the cart.
6. Verify the success message.
7. Capture the execution screenshot.

### SearchTest

1. Open OpenCart.
2. Enter search data.
3. Search for the product.
4. Verify the search result heading.
5. Capture the execution screenshot.

## DataProvider

### DesktopTest

```java
@DataProvider(name = "sortData")
public Object[][] sortData() {
    return new Object[][] {
        {"Name (A - Z)"},
        {"Name (Z - A)"}
    };
}
```

### SearchTest

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

## Extent Report

A single `ExtentReports` object is created in `BaseTest` using `@BeforeSuite`.

```java
ExtentSparkReporter reporter =
    new ExtentSparkReporter(
        projectpath + "\\Reports\\ExtentTestReports.html"
    );

extent = new ExtentReports();
extent.attachReporter(reporter);
```

The report is flushed once after the complete suite:

```java
@AfterSuite
public void tearDown() {
    extent.flush();
    driver.quit();
}
```

## TestNG Listener

`ExtentTestNgListener` implements `ITestListener`.

It automatically handles:

* Test start
* Test pass
* Test failure
* Test skipped
* Exception details
* Screenshot attachment

The listener creates unique Extent test names using the DataProvider parameters.

Example:

```text
DesktopFlow - Name (A - Z)
DesktopFlow - Name (Z - A)

searchFlowTest - Mobile Monitors
searchFlowTest - Laptop Phones
searchFlowTest - Camera Cameras
```

## Screenshot Handling

The common screenshot method is maintained in `BaseTest`.

Unique screenshot names are generated so that different DataProvider executions do not overwrite each other.

```text
Screenshots/
├── DesktopFlow-Name_A_Z.png
├── DesktopFlow-Name_Z_A.png
├── searchFlowTest-Mobile_Monitors.png
├── searchFlowTest-Laptop_Phones.png
└── searchFlowTest-Camera_Cameras.png
```

## TestNG XML

The listener is registered in `testng.xml`:

```xml
<listeners>
    <listener class-name="package1.ExtentTestNgListener"/>
</listeners>
```

Therefore, `@Listeners` is not required separately in `DesktopTest` or `SearchTest`.

## Project Structure

```text
Project
├── src/test/java
│   └── package1
│       ├── BaseTest.java
│       ├── DesktopTest.java
│       ├── SearchTest.java
│       ├── POMLocators.java
│       └── ExtentTestNgListener.java
│
├── Reports
│   └── ExtentTestReports.html
│
├── Screenshots
│   ├── Desktop screenshots
│   └── Search screenshots
│
├── testng.xml
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

The test suite successfully generates a **single Extent HTML report** containing execution results for both `DesktopTest` and `SearchTest`, including individual DataProvider executions and screenshots.

## Extent Report Result
<img width="1338" height="475" alt="image" src="https://github.com/user-attachments/assets/b1e88a5d-bb60-41cc-a80b-aabae9de62d1" />
<img width="1365" height="561" alt="image" src="https://github.com/user-attachments/assets/b61372ee-7ca3-4931-9201-e2834f089962" />

## TestNG Result
<img width="1016" height="616" alt="image" src="https://github.com/user-attachments/assets/b299b717-a8bb-4ecf-9361-b80bd9b7285f" />
<img width="746" height="647" alt="image" src="https://github.com/user-attachments/assets/eb1a4f99-c0e8-4469-892a-654d795a4cd1" />

