# Selenium WebDriver Cross Browser Testing with TestNG & JUnit (Lab 9)

## Overview

This project demonstrates **Cross Browser Testing** using Selenium WebDriver by executing the same automation flow on multiple browsers. The implementation emphasizes **code reusability** by placing the common automation steps in a single reusable method, which is invoked by different browser-specific test methods.

The project also includes a **JUnit implementation** of the same flow with JUnit Assertions.

**Application Under Test**

https://tutorialsninja.com/demo/

---

# Technologies Used

- Java
- Selenium WebDriver
- TestNG
- JUnit 4
- Maven
- WebDriverManager
- Google Chrome
- Microsoft Edge
- Eclipse IDE

---

# Objectives

- Perform Cross Browser Testing.
- Execute the same automation flow on multiple browsers.
- Avoid code duplication using reusable methods.
- Validate application behavior using Assertions.
- Execute TestNG Suite using `testng.xml`.
- Execute JUnit test cases.

---

# Project Structure

```
SeleniumWebDriverLab9
│
├── src/test/java
│   └── com.test
│       ├── MultiBrowserTest.java
│       └── MultiBrowserJUnit.java
│
├── testng.xml
│
├── test-output
│
├── pom.xml
│
└── README.md
```

---

# Automation Flow

The following flow is executed on both browsers:

1. Launch TutorialsNinja Demo Website
2. Navigate to **Desktops**
3. Open **Mac**
4. Verify **Mac** Heading
5. Sort Products by **Name (A-Z)**
6. Click **Add to Cart**
7. Verify Success Message
8. Search for **Mobile**
9. Clear Search Box
10. Search for **Monitors**
11. Verify Search Results Page
12. Close Browser

---

# Code Reusability

Instead of duplicating Selenium code for every browser, a reusable method is created.

```java
public void executeFlow(WebDriver driver)
```

The browser-specific test methods simply initialize the required browser and call the reusable method.

Example:

```java
@Test
public void chromeTest() {
    WebDriver driver = new ChromeDriver();
    executeFlow(driver);
}

@Test
public void edgeTest() {
    WebDriver driver = new EdgeDriver();
    executeFlow(driver);
}
```

This approach improves readability and maintainability.

---

# TestNG Implementation

### Test Methods

- Chrome Test
- Edge Test

### TestNG Assertions Used

- Assert.assertEquals()
- Assert.assertTrue()

### Reporter Logging

Reporter logs are generated during execution.

Example:

```
Clicked on Desktops
Verified Mac Heading
Add to Cart Verified
Searching Monitors
Search Verified
```

---

# TestNG Suite

```xml
<?xml version="1.0" encoding="UTF-8"?>

<!DOCTYPE suite SYSTEM "https://testng.org/testng-1.0.dtd">

<suite name="MultiBrowserSuite">

    <test name="BrowsersTest">

        <classes>

            <class name="com.test.MultiBrowserTest"/>

        </classes>

    </test>

</suite>
```

---

# JUnit Implementation

The same automation flow is also implemented using JUnit 4.

### Assertions Used

- assertEquals()
- assertTrue()

JUnit executes the browser-specific test methods directly using the `@Test` annotation.

---

# Test Execution

## TestNG

Run:

```
Right Click
→ testng.xml
→ Run As
→ TestNG Suite
```

---

## JUnit

Run:

```
Right Click
→ MultiBrowserJUnit.java
→ Run As
→ JUnit Test
```

---

# Test Reports

After TestNG execution, reports are generated automatically.

```
test-output
│
├── index.html
├── emailable-report.html
├── testng-results.xml
```

---

# Execution Screenshots



## TestNG Report

> Insert Screenshot Here

<img width="603" height="599" alt="image" src="https://github.com/user-attachments/assets/8e95e369-aab5-469b-92c5-e05dbcb0ad60" />

<img width="591" height="473" alt="image" src="https://github.com/user-attachments/assets/457736b0-54e5-4845-9b7f-99b27aadd431" />

---

## JUnit Execution

> Insert Screenshot Here

<img width="419" height="206" alt="image" src="https://github.com/user-attachments/assets/fb064676-9d4a-4f72-b0c4-83002f75d034" />


---

# Key Features

- Cross Browser Testing
- Selenium WebDriver
- TestNG Framework
- JUnit Framework
- Code Reusability
- Assertions
- Reporter Logging
- Maven Project
- HTML Report Generation
- Browser Automation

---

# Learning Outcomes

Through this project, the following concepts were practiced:

- Cross Browser Testing using Selenium WebDriver
- Reusing automation code with common methods
- TestNG Test Suite execution
- JUnit Test execution
- Assertions in TestNG and JUnit
- Reporter Logging
- Explicit Waits
- Maven Project Structure
- Test Automation Best Practices

---

# Result

✔ Successfully executed the same automation flow on Google Chrome.

✔ Successfully executed the same automation flow on Microsoft Edge.

✔ Implemented reusable automation logic using a common method.

✔ Executed TestNG Suite successfully.

✔ Executed JUnit test cases successfully.

✔ Generated TestNG execution reports.

---

## Author

**Thanuja Balla**

GitHub:  
https://github.com/ThanujaBalla
