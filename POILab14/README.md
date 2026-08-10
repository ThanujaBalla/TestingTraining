# Lab 14 – Data-Driven Testing Using Excel

## Objective

Automate the OpenCart Registration flow using **Selenium WebDriver, TestNG, Page Factory, and Excel DataProvider**.

## Technologies Used

- Java
- Selenium WebDriver
- TestNG
- Page Factory
- Apache POI
- Maven
- Excel

## Test Flow

1. Launch OpenCart.
2. Verify the Home Page title.
3. Navigate to the Register page.
4. Verify the Register page.
5. Read registration data from `data.xlsx`.
6. Fill First Name, Last Name, Email and Telephone.
7. Enter Password and Confirm Password.
8. Submit the registration form.
9. Verify the registration result.

## Data-Driven Testing

Test data is maintained in:

```text
data.xlsx
TestNG `@DataProvider` reads the Excel data and executes the same test for each row.
```

```text
Excel
  ↓
@DataProvider
  ↓
RegisterTest
  ↓
Page Factory
  ↓
Selenium WebDriver
```

## Handling Existing Accounts

If the email is already registered, the warning message is treated as an expected result.

```text
Account Created Successfully → PASS

Account Already Registered → PASS

Unexpected Error → FAIL
```

## Framework Structure

```text
src/test/java/package1
│
├── BaseTest.java
├── RegisterTest.java
└── POMPageFactory.java

data.xlsx
```

## Reports

### TestNG Execution Report
<img width="893" height="556" alt="image" src="https://github.com/user-attachments/assets/b361ca3f-efa2-431e-9d77-598e35e10532" />

<img width="746" height="546" alt="image" src="https://github.com/user-attachments/assets/c37d42b9-c969-4fbb-bb10-f045d2d700e6" />
<img width="722" height="593" alt="image" src="https://github.com/user-attachments/assets/c4e98083-277b-47c1-8bd1-7780fe6c7c6f" />

### Excel Data
<img width="667" height="389" alt="image" src="https://github.com/user-attachments/assets/bd9583d1-c4ef-4dcc-82e1-65f88e241349" />

## Result

Successfully implemented **data-driven registration testing** using TestNG DataProvider and Excel, with Page Factory and Selenium WebDriver.

