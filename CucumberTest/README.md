# Cucumber BDD – OrangeHRM Login Automation

## Objective

To automate the OrangeHRM login flow using **Cucumber BDD, Selenium WebDriver, and TestNG**.

## Test Scenario

The login scenario verifies that a valid user can successfully log in to OrangeHRM.

### Login Flow

1. Open the OrangeHRM login page.
2. Enter the username.
3. Enter the password.
4. Click the Login button.
5. Verify that the Dashboard page is displayed.

## Step Definitions

The step definitions are implemented in:

```text
src/test/java/StepDefinitions/logintest.java
```

The class contains Cucumber annotations:

```java
@Given
@When
@And
@Then
```

Selenium WebDriver is used to interact with the OrangeHRM application.

## Cucumber Feature

The feature file contains the business-readable scenario using Given, When, And, and Then steps.

Example:

```gherkin
Given Open the OrangeHRM login page
When Enter the username "Admin"
And Enter the password "admin123"
And Click on login button
Then Dashboard page should be displayed
```

## Test Runner

The Cucumber tests are executed using TestNG through:

```text
src/test/java/Runners/TestRunner.java
```

The runner extends:

```java
AbstractTestNGCucumberTests
```

and uses:

```java
@CucumberOptions
```

Configuration:

```java
@CucumberOptions(
    features = "src/test/java/Features",
    glue = "StepDefinitions",
    plugin = {"pretty", "html:target/cucumber-report.html"},
    monochrome = true
)
```

### Configuration

* **features** – Location of the Cucumber feature files.
* **glue** – Package containing the step definitions.
* **pretty** – Displays readable execution output.
* **html** – Generates an HTML Cucumber report.
* **monochrome** – Provides cleaner console output.

## Project Structure

```text
Project
├── src/test/java
│   ├── Features
│   │   └── Login.feature
│   │
│   ├── StepDefinitions
│   │   └── logintest.java
│   │
│   └── Runners
│       └── TestRunner.java
│
├── target
│   └── cucumber-report.html
│
└── pom.xml
```

## Technologies Used

* Java
* Selenium WebDriver
* Cucumber BDD
* TestNG
* Maven
* WebDriverManager
* ChromeDriver

## Execution

Run the `TestRunner.java` as a **TestNG Test**.

Cucumber executes the feature scenario and maps each step to its corresponding Java step definition.

## Result

The OrangeHRM login scenario is automated successfully using **Cucumber BDD with Selenium and TestNG**, and an HTML execution report is generated.

## Cucumber Report
<img width="1363" height="551" alt="image" src="https://github.com/user-attachments/assets/fda17685-4318-4496-9efd-fd1104fa3108" />
<img width="843" height="445" alt="image" src="https://github.com/user-attachments/assets/b8df3199-ee13-46c5-a09d-b44a19aec55b" />

## Test Execution Result
<img width="970" height="471" alt="image" src="https://github.com/user-attachments/assets/e5cc0281-71b7-453d-b7a8-049ee0dee342" />

