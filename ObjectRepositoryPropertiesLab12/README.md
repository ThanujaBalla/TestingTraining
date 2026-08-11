# Lab Demo 12 – Object Repository Using Properties File

## Objective

Implement Selenium automation using an **Object Repository with a Properties file** to store and manage web element locators separately from the test code.

## Technologies Used

- Java
- Selenium WebDriver
- TestNG
- Maven
- Properties File
- Page Object Model

## Test Flow

1. Launch OpenCart.
2. Navigate to **Desktops**.
3. Select **Mac**.
4. Verify the Mac heading.
5. Select the required sorting option.
6. Add the product to the cart.
7. Verify the success message.
8. Search for products.
9. Verify the search result heading.

## Object Repository

All locators are maintained in:

```text
objectRepository.properties
```
Example:

```properties
Desktops=xpath://a[text()='Desktops']
Mac1=xpath://a[text()='Mac (1)']
macHeading=css:h2
sortDown=xpath://select[@id='input-sort']
Addtocart=xpath://span[text()='Add to Cart']
```

The repository class reads the locator values from the Properties file and converts them into Selenium `By` objects.

## Framework Flow

```text
objectRepository.properties
          ↓
Repository_readfromproperties
          ↓
POM_properties
          ↓
Selenium WebDriver
          ↓
TestNG Test Cases
```

## Advantages

* Locators are maintained separately from Java code.
* Updating a locator is easier.
* Reduces duplication in test scripts.
* Improves maintainability of the automation framework.

## Project Structure

```text
src/test/java/package1
│
├── Repository_readfromproperties.java
├── POM_properties.java
├── DesktopTest.java
└── SearchTest.java

objectRepository.properties
```

## TestNG Results

<img width="742" height="542" alt="image" src="https://github.com/user-attachments/assets/c740f548-6056-4161-b939-a79b8a092143" />

<img width="720" height="501" alt="image" src="https://github.com/user-attachments/assets/0592dd05-ff4b-4c33-9ad1-53f5eebf3c32" />
<img width="738" height="478" alt="image" src="https://github.com/user-attachments/assets/27bbec76-995c-4001-ab88-3308c566081e" />

## Result

Successfully implemented an **Object Repository using a Properties file** and executed the OpenCart automation flow using Selenium WebDriver and TestNG.

```
```
