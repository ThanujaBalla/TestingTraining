# Lab 11.1 – Page Object Model (POM)

## Objective

Implement the Lab 3 & Lab 4 automation flow using Selenium WebDriver, TestNG, and the Page Object Model (POM).

## Application

**URL:** https://tutorialsninja.com/demo/

## Technologies

- Java
- Selenium WebDriver
- TestNG
- Maven
- WebDriverManager

## Implementation

Created a reusable `POMLocators` class containing:

- Web element locators
- Desktop/Mac navigation
- Sorting and Add to Cart
- Search operations
- Success message handling
- Result page verification

Created TestNG test classes:

- `DesktopTest`
- `SearchTest`

TestNG **DataProvider** is used for test data, and **TestNG Assertions** are used for validations.

## Test Flow

### Desktop Test
1. Open TutorialsNinja.
2. Navigate to **Desktops → Mac**.
3. Verify Mac heading.
4. Select **Name (A - Z)**.
5. Add iMac to cart.
6. Verify success message.

### Search Test
1. Enter `Mobile` in Search.
2. Clear the search box.
3. Enter `Monitors`.
4. Search and verify **Search - Monitors**.

## Execution Results

### TestNG Report

<img width="617" height="541" alt="image" src="https://github.com/user-attachments/assets/cd88e1db-f172-43bd-8bc8-bfebc43c7b54" />
<img width="516" height="548" alt="image" src="https://github.com/user-attachments/assets/68e8673a-e80c-4133-9709-f5bc15107492" />
<img width="496" height="596" alt="image" src="https://github.com/user-attachments/assets/93cae5db-92a4-424f-b057-e8eb22bdb670" />

<img width="596" height="499" alt="image" src="https://github.com/user-attachments/assets/be39459f-55f3-4982-8066-9390408472dd" />


## Result

Successfully implemented the required flows using **Selenium WebDriver + TestNG + Page Object Model**.
