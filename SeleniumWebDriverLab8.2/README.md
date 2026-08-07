# Selenium WebDriver with TestNG Automation

## Overview

This project demonstrates Selenium WebDriver automation using the **TestNG** framework. The test cases automate user interactions on the TutorialsNinja demo website and validate the application behavior using **TestNG Assertions** and **Reporter Logging**.

**Application Under Test:**  
https://tutorialsninja.com/demo/

---

## Technologies Used

- Java
- Selenium WebDriver
- TestNG
- WebDriverManager
- Chrome Browser
- Eclipse IDE

---

## Project Structure

```
SeleniumWebDriverLab8_2
│
├── DesktopTest.java
├── SearchTest.java
├── testng.xml
└── test-output/
```

---

## Test Case 1 - Desktop Flow

### Test Steps

- Launch Chrome Browser
- Navigate to TutorialsNinja Demo
- Click **Desktops**
- Open **Mac**
- Verify page heading
- Sort products by **Name (A-Z)**
- Click **Add to Cart**
- Verify success message
- Close Browser

### Assertions Used

- Verify **Mac** heading
- Verify successful product addition to cart

### Reporter Logs

- Launching Browser
- Clicked on Desktops
- Verified Mac Heading
- Add to Cart Verified

---

### Desktop Test Execution

<img width="551" height="370" alt="image" src="https://github.com/user-attachments/assets/73489851-cacc-4bbe-a605-c0e07e5f4d79" />


---

## Test Case 2 - Search Flow

### Test Steps

- Launch Chrome Browser
- Navigate to TutorialsNinja Demo
- Search for **Mobile**
- Clear Search Box
- Search for **Monitors**
- Click Search
- Verify Search Results Page
- Close Browser

### Assertions Used

- Verify Search Result Heading

### Reporter Logs

- Launching Browser
- Searching Monitors
- Search Verified

---

### Search Test Execution
<img width="638" height="372" alt="image" src="https://github.com/user-attachments/assets/27bcd0de-7abc-4de6-97ba-68d4dc7c6bcf" />


---

# TestNG Suite

The project executes both test cases using a single TestNG Suite.

### testng.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>

<!DOCTYPE suite SYSTEM "https://testng.org/testng-1.0.dtd">

<suite name="RegressionSuite">

    <test name="Test">

        <classes>

            <class name="SearchTest"/>

            <class name="DesktopTest"/>

        </classes>

    </test>

</suite>
```

---

# Test Execution

Run the suite using:

```
Right Click → testng.xml
Run As → TestNG Suite
```

---

# TestNG Report

Both test cases executed successfully.

### Test Summary

| Suite | Tests | Passed | Failed | Skipped |
|-------|------:|-------:|-------:|---------:|
| RegressionSuite | 2 | 2 | 0 | 0 |

---

## TestNG HTML Report

### Regression Suite Report

<img width="1025" height="294" alt="image" src="https://github.com/user-attachments/assets/1f74ad3d-943d-4052-9b28-4551933b0fd4" />




---

## Reporter Output
<img width="808" height="599" alt="image" src="https://github.com/user-attachments/assets/d84018b0-44d4-4fb4-a6a5-a575017e1539" />


<img width="691" height="556" alt="image" src="https://github.com/user-attachments/assets/68708b22-ef0b-49e1-af2a-e0c43583d56e" />
### Desktop Test
```
Launching Browser
Clicked on Desktops
Verified Mac Heading
Add to Cart Verified
```

### Search Test

```
Launching Browser
Searching Monitors
Search Verified
```

---

## Features Demonstrated

- Selenium WebDriver Automation
- TestNG Framework
- TestNG Assertions
- Reporter Logging
- Explicit Waits
- Dropdown Handling
- Search Functionality
- Browser Automation
- Test Suite Execution
- HTML Report Generation

---

## Result

✔ Desktop Flow executed successfully.

✔ Search Flow executed successfully.

✔ TestNG Assertions passed.

✔ Reporter Logs generated.

✔ TestNG HTML Report generated.

✔ Regression Suite executed successfully.

---

## Author

**Thanuja Balla**

GitHub: https://github.com/ThanujaBalla
