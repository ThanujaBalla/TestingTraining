# Lab Demo 16: Advance Selenium
## Parameterization using XML and DataProvider in TestNG

### Objective
To automate the OpenCart registration flow using:
- TestNG XML parameterization
- TestNG `@DataProvider`
- Page Object Model
- Selenium WebDriver
- TestNG Assertions and Reporter logging

### Flow
1. Launch OpenCart.
2. Verify the Home Page.
3. Navigate to **My Account → Register**.
4. Verify the Register Account page.
5. Enter registration details.
6. Enter password and confirm password.
7. Agree to the Privacy Policy.
8. Submit the registration form.
9. Verify successful registration or handle an already-existing account.

### Parameterization

**XML Parameterization**

The browser is passed through `testng.xml` using:

```java
@Parameters("browser")
````

Example:

```xml
<parameter name="browser" value="chrome"/>
```

**DataProvider**

User registration details are read from Excel using:

```java
@DataProvider(name = "UserDetails")
```

The DataProvider supplies:

* First Name
* Last Name
* Email
* Telephone
* Password
* Confirm Password

### Execution Flow

```text
testng.xml
    ↓
@Parameters("browser")
    ↓
Browser Setup
    ↓
@DataProvider("UserDetails")
    ↓
Registration Test
    ↓
TestNG Assertions
    ↓
TestNG Report
```

### Technologies Used

* Java
* Selenium WebDriver
* TestNG
* Maven
* Apache POI
* ChromeDriver
* Page Object Model

### Result

The registration test was successfully parameterized using **TestNG XML parameters and DataProvider**, allowing the same test flow to execute with multiple sets of user data.

### Test Execution Result

<img width="653" height="508" alt="image" src="https://github.com/user-attachments/assets/0d0b4dc5-d1b9-409e-8193-2a40720cf71c" />

<img width="1073" height="625" alt="image" src="https://github.com/user-attachments/assets/a7bccaae-5ed3-4f8e-8360-f0ea1d66702f" />
<img width="792" height="620" alt="image" src="https://github.com/user-attachments/assets/48b1773f-9852-4270-8056-a3f9aa318d40" />
<img width="916" height="318" alt="image" src="https://github.com/user-attachments/assets/95f80609-c40c-4554-afc1-4b3b2b6952da" />

### Project Structure

```text
Lab16
├── src/test/java
│   └── package1
│       ├── BaseTest.java
│       ├── RegisterTest.java
│       └── POMPageFactory.java
├── data.xlsx
├── testng.xml
├── Reports
└── pom.xml
```
