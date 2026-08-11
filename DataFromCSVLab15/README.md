# Lab 15 – Parameterization Using CSV File

## Objective

Automate the OpenCart Registration flow using **Selenium WebDriver, TestNG, Page Factory, and CSV-based parameterization**.

## Technologies Used

- Java
- Selenium WebDriver
- TestNG
- Page Factory
- OpenCSV
- Maven

## Test Flow

1. Launch OpenCart.
2. Verify the Home Page title.
3. Navigate to the Register page.
4. Verify the Register page.
5. Read registration data from the CSV file.
6. Fill First Name, Last Name, Email and Telephone.
7. Enter Password and Confirm Password.
8. Submit the registration form.
9. Verify the registration result.

## CSV Data

Test data is stored in:

```text
data(sheet1).csv
```
The TestNG `@DataProvider` uses **OpenCSV** to read the CSV file and supplies each row to the test.

```text
CSV File
   ↓
CSVReader
   ↓
@DataProvider
   ↓
RegisterTest
   ↓
POMPageFactory
   ↓
Selenium WebDriver
```

## Parameterization

The registration test receives the following parameters:

```text
First Name
Last Name
Email
Phone
Password
Confirm Password
```

The test is executed once for each data row in the CSV file.

## Existing Account Handling

If the account already exists, the warning message is treated as an expected result.

```text
Account Created Successfully → PASS

Account Already Registered → PASS

Unexpected Error → FAIL
```

## Project Structure

```text
src/test/java/package1
│
├── BaseTest.java
├── RegisterTest.java
└── POMPageFactory.java

data(sheet1).csv
```

## Reports

### TestNG Execution Report
<img width="976" height="616" alt="image" src="https://github.com/user-attachments/assets/7bb38feb-8542-41a7-bb6b-2f281fa937e2" />

<img width="785" height="650" alt="image" src="https://github.com/user-attachments/assets/819e8c89-c7e4-498a-8237-35134c1dee3c" />
<img width="819" height="642" alt="image" src="https://github.com/user-attachments/assets/c13bbc8c-535a-4745-8790-c6a358ea7d6b" />

### CSV Test Data

<img width="549" height="255" alt="image" src="https://github.com/user-attachments/assets/d384445c-5e44-4439-b73f-39a6068a0314" />

## Result

Successfully implemented **CSV-based parameterization** using TestNG `@DataProvider` and OpenCSV for the OpenCart Registration flow.

```
```
