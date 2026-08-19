
# Unacademy Web Automation Testing

A Selenium-based web automation testing project for the Unacademy website using **Java, Selenium WebDriver, Cucumber, TestNG, Page Object Model (POM), Maven, and Extent Reports**.

This project was developed as part of my software testing and automation training to practice designing and executing real-world UI automation test scenarios.

---

## 🚀 Tech Stack

- **Java**
- **Selenium WebDriver**
- **Cucumber BDD**
- **TestNG**
- **Maven**
- **Page Object Model (POM)**
- **WebDriverManager**
- **Extent Reports**
- **Apache Commons IO**
- **Eclipse IDE**
- **Git & GitHub**

---

## 📌 Application Under Test

**Application:** Unacademy

**Website:** https://unacademy.com/

The automation covers important user journeys around:

- User Sign Up
- User Login
- Mobile number validation
- Email login
- OTP validation
- Invalid OTP
- Expired OTP
- Cross-browser testing
- Logout
- Form validation

---

# 🧪 Test Scenarios

The project currently contains test scenarios covering the following areas.

| Test Case | Scenario |
|-----------|----------|
| TC001 | Sign up with valid mobile number and valid OTP |
| TC002 | Sign up with invalid mobile number |
| TC003 | Sign up with invalid OTP |
| TC004 | Sign up with expired OTP |
| TC005 | Sign up from Mobile device |
| TC006 | Sign up from Laptop |
| TC007 | Sign up using Chrome |
| TC008 | Sign up using Firefox |
| TC009 | Sign up using Edge |
| TC010 | Sign up with a new/unregistered mobile number |
| TC011 | Login using valid mobile number and OTP |
| TC012 | Login using valid email and OTP |
| TC013 | Login with invalid mobile/email |
| TC014 | Login with invalid OTP |
| TC015 | Login with expired OTP |
| TC016 | Login from Mobile device |
| TC017 | Login from Laptop |
| TC018 | Login from different network/location |
| TC019 | Successful logout |

> Some scenarios involving OTP require manual OTP entry because the application sends a real OTP to the registered mobile number.

---

# 🏗️ Framework Architecture

The project follows the **Page Object Model** combined with **Cucumber BDD**.

```text
                    Unacademy
                        |
                        v
                Feature Files
                        |
                        v
                Step Definitions
                        |
                        v
                  Page Objects
                        |
                        v
                Selenium WebDriver
                        |
                        v
                 Web Application
````

Supporting the framework:

```text
Hooks
  |
  +---- Driver Management
  |
  +---- Browser Configuration
  |
  +---- Screenshot Capture
  |
  +---- Extent Reporting

Utilities
  |
  +---- ConfigReader
  |
  +---- DriverManager
  |
  +---- ScreenshotUtil

Reports
  |
  +---- ExtentManager
```

---

# 📂 Project Structure

```text
unacademy
│
├── Reports/
│   └── ExtentTestReports.html
│
├── Screenshots/
│   └── Test execution screenshots
│
├── src/
│   └── test/
│       ├── java/
│       │   │
│       │   ├── Base/
│       │   │   └── Hooks.java
│       │   │
│       │   ├── Features/
│       │   │   ├── signup.feature
│       │   │   └── login.feature
│       │   │
│       │   ├── Pages/
│       │   │   ├── SignupPage.java
│       │   │   └── LoginPage.java
│       │   │
│       │   ├── Reports/
│       │   │   └── ExtentManager.java
│       │   │
│       │   ├── Runners/
│       │   │   └── TestRunner.java
│       │   │
│       │   ├── StepDefinitions/
│       │   │   ├── signupTest.java
│       │   │   └── logintest.java
│       │   │
│       │   └── Utilities/
│       │       ├── ConfigReader.java
│       │       ├── DriverManager.java
│       │       └── ScreenshotUtil.java
│       │
│       └── resources/
│
├── test-output/
│
├── .gitignore
├── pom.xml
└── README.md
```

---

# 🧩 Framework Components

## 1. Page Object Model

The application pages are represented using separate Page Object classes.

### SignupPage.java

Handles:

* Join for Free
* Mobile number entry
* Continue button
* OTP handling
* Signup validation
* Registration verification

### LoginPage.java

Handles:

* Login
* Mobile number login
* Email login
* OTP
* Invalid OTP
* Expired OTP
* Email validation
* Profile
* Logout

This keeps the Selenium locators and page-specific actions separate from the test steps.

---

# 2. Cucumber BDD

Test scenarios are written using Gherkin syntax.

Example:

```gherkin
@TC001

Scenario: TC001 - Verify joining Unacademy with valid mobile number and valid OTP

    Given I am on the Unacademy signup page
    When I click on Join for free
    And I enter a valid signup mobile number
    And I click on Signup Continue
    And I enter the OTP manually
    Then I should be registered successfully
```

This makes the test cases easier to understand from a business/testing perspective.

---

# 3. Step Definitions

Cucumber steps are implemented in:

```text
StepDefinitions/
```

For example:

```java
@When("I click on Join for free")
public void i_click_on_join_for_free() {

    signupPage.clickJoinForFree();
}
```

The step definitions communicate with the Page Objects rather than directly interacting with Selenium elements.

---

# 4. WebDriver Management

`DriverManager.java` maintains the WebDriver instance.

```java
DriverManager.setDriver(driver);

DriverManager.getDriver();

DriverManager.quitDriver();
```

This allows the WebDriver to be accessed consistently from different parts of the framework.

---

# 5. Cucumber Hooks

`Hooks.java` handles common test setup and cleanup.

Before each scenario:

* Browser is launched
* Browser window is maximized
* Driver is initialized
* Unacademy is opened

After each scenario:

* Screenshot is captured
* Result is added to Extent Reports
* Browser is closed

---

# 🌐 Cross-Browser Testing

The framework supports:

* Chrome
* Firefox
* Microsoft Edge

Browser selection is controlled through:

```text
config.properties
```

Example:

```properties
browser=chrome
url=https://unacademy.com
implicitWait=10
explicitWait=30
```

The same test scenarios can therefore be executed against different browsers without modifying the Page Objects.

---

# 📊 Extent Reports

Extent Reports are integrated into the framework to provide a visual test execution report.

The report contains:

* Test scenario name
* Browser information
* Test status
* PASS/FAIL information
* Execution screenshots

Report location:

```text
Reports/ExtentTestReports.html
```

The report can be opened directly in a browser after execution.

---

# 📸 Screenshots

Screenshots are captured during test execution using Selenium's:

```java
TakesScreenshot
```

The screenshots are stored under:

```text
Screenshots/
```

They are also attached to the Extent Report.

This makes it easier to investigate failures and understand the state of the application during execution.

---

# ⚙️ Configuration

Application and browser configuration is maintained separately in:

```text
src/test/resources/config.properties
```

Example:

```properties
browser=chrome
url=https://unacademy.com
implicitWait=10
explicitWait=30
```

The `ConfigReader` utility loads these values during execution.

---

# ▶️ How to Run

## Prerequisites

Install:

* Java JDK
* Maven
* Eclipse or another Java IDE
* Chrome / Firefox / Edge
* Git

---

## Clone the Repository

```bash
git clone https://github.com/ThanujaBalla/TestingTraining.git
```

Navigate to the Unacademy project:

```bash
cd TestingTraining/unacademy
```

---

## Run Tests

Tests can be executed through the Cucumber/TestNG runner:

```text
src/test/java/Runners/TestRunner.java
```

Individual scenarios can be selected using Cucumber tags.

Example:

```java
tags = "@TC013A"
```

Multiple scenarios:

```java
tags = "@TC013A or @TC013B"
```

For the complete suite, remove or modify the tag filter in the runner.

---

# 📱 Manual OTP Handling

Some Unacademy scenarios use real OTP verification.

For these scenarios, the framework waits for the OTP to be entered manually in the browser.

Example flow:

```text
Enter mobile number
        ↓
Click Continue
        ↓
OTP sent to mobile
        ↓
Enter OTP manually
        ↓
Automation detects 6-digit OTP
        ↓
Continue/verification
        ↓
Validate result
```

This approach was used because the application sends a real OTP and the OTP value should not be hard-coded into the automation.

---

# 🔍 Validation Scenarios

The project also covers negative testing such as:

### Invalid Mobile Number

Example:

```text
12345
```

The application should not proceed to OTP verification.

### Extra Mobile Digits

The application restricts the mobile number input to the expected number of digits.

### Invalid Email Format

Example:

```text
tgamil.com
```

Expected validation:

```text
Email is not valid
```

### Unregistered Email

Example:

```text
example@gmail.com
```

Expected application response:

```text
This email is not registered with us
```

### Invalid OTP

An incorrect OTP is entered and the application response is validated.

### Expired OTP

The test waits until the OTP expires and validates the resulting application behaviour.

---

# 🧠 Key Concepts Practiced

Through this project, I practiced:

* Selenium WebDriver
* Web element identification
* XPath
* Dynamic XPath
* Explicit waits
* Page Object Model
* Cucumber BDD
* Gherkin
* Cucumber Hooks
* TestNG
* Maven
* WebDriverManager
* Cross-browser testing
* Positive testing
* Negative testing
* Form validation
* OTP-based authentication testing
* Screenshot capture
* Extent Reports
* Git and GitHub
* Test framework organization

---

# 📈 Future Improvements

Possible future enhancements:

* Complete automation of all remaining scenarios
* Better separation of Home, Login and Profile Page Objects
* Parallel test execution
* CI/CD integration using GitHub Actions
* Automated test execution reports
* Improved test data management
* Environment-specific configuration
* Retry mechanism for flaky tests
* More robust dynamic locators
* API testing integration

---

# 👩‍💻 Author

**Thanuja Balla**

This project is part of my hands-on learning and practice in **Software Testing and Automation Testing**.

---

## ⭐ Project Highlights

```text
Java
  +
Selenium
  +
Cucumber
  +
TestNG
  +
Page Object Model
  +
Maven
  +
Extent Reports
  +
Cross-Browser Testing
```

A practical end-to-end UI automation project built around real-world authentication and validation scenarios.

