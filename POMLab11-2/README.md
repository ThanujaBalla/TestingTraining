# Lab 11.2 – Page Object Model with Page Factory

## Objective

Implement the Lab 3 & Lab 4 automation flow using **Selenium WebDriver, TestNG, Page Object Model (POM), and Page Factory**.

## Application

**URL:** [https://tutorialsninja.com/demo/](https://tutorialsninja.com/demo/)

## Technologies

* Java
* Selenium WebDriver
* TestNG
* Maven
* WebDriverManager

## Implementation

Created a `POMPageFactory` class using Selenium Page Factory.

Web elements are declared using `@FindBy`:

```java
@FindBy(name = "search")
WebElement searchBox;
```

Elements are initialized using:

```java
PageFactory.initElements(driver, this);
```

The Page Factory class contains reusable methods for:

* Navigating to Desktops → Mac
* Verifying the Mac heading
* Selecting the sorting option
* Adding iMac to the cart
* Verifying the success message
* Performing product searches
* Verifying search results

## Test Cases

### Desktop Test

* Navigate to **Desktops → Mac**
* Verify Mac heading
* Select **Name (A - Z)**
* Add iMac to cart
* Verify success message

### Search Test

* Enter `Mobile`
* Clear the search box
* Enter `Monitors`
* Click Search
* Verify **Search - Monitors**

## TestNG Features Used

* `@Test`
* `@DataProvider`
* TestNG Assertions
* `Reporter.log()`
* Explicit Wait

## Execution Results

### TestNG Report

<img width="542" height="592" alt="image" src="https://github.com/user-attachments/assets/31764a3e-2d13-445f-9bfe-9f266ec492cc" />

<img width="631" height="416" alt="image" src="https://github.com/user-attachments/assets/410c03c4-08eb-4a10-915a-a6c3f7d9f406" />
<img width="536" height="596" alt="image" src="https://github.com/user-attachments/assets/bbcb36f6-6437-47a5-94cf-308aa8b8e4cb" />
<img width="437" height="557" alt="image" src="https://github.com/user-attachments/assets/57b3f8a4-9231-47ca-bd2c-545e6f467f73" />


## Result

Successfully implemented the Lab 3 & Lab 4 flows using **Selenium WebDriver with Page Object Model and Page Factory**.
