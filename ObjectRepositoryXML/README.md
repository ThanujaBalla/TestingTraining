# Lab 13 – Properties File Object Repository

## Objective

Implement the Lab 4 automation flow using an **Object Repository** to store and retrieve Selenium locators externally.

## Application

**URL:** https://tutorialsninja.com/demo/

## Technologies Used

- Java
- Selenium WebDriver
- Maven
- TestNG
- XML
- dom4j
- Jaxen

## Implementation

The Selenium locators are stored separately in an `objectrepository.xml` file instead of directly writing them inside the test/page class.

Example:

```xml
<searchbox>name:search</searchbox>
<searchbutton>css:button.btn.btn-default.btn-lg</searchbutton>
<resultpageheading>id:content</resultpageheading>
```

The `XmlObjectRepository` class reads the XML file and returns the locator value.

The `POMLocators` class converts the locator string into a Selenium `By` object using the locator type.

Supported locator types:

* `id`
* `name`
* `xpath`
* `css`

## Flow Automated

1. Open TutorialsNinja.
2. Enter `Mobile` in the Search box.
3. Clear the Search box.
4. Enter `Monitors`.
5. Click the Search button.
6. Verify the search result page.

## Classes

### `objectrepository.xml`

Stores the Selenium locators externally.

### `XmlObjectRepository.java`

Reads locator values from the XML file using **dom4j**.

### `POMLocators.java`

Retrieves the locators from the XML repository and performs the required Selenium actions.

## Locator Handling

A locator is stored in the format:

```text
locatorType:locatorValue
```

Example:

```text
name:search
```

The `getBy()` method separates the locator type and value and creates the corresponding Selenium `By` object.

## Execution Result

### Test Execution
<img width="999" height="271" alt="image" src="https://github.com/user-attachments/assets/51fb3a8b-4214-4d93-a8a4-af96fe413135" />

<img width="522" height="466" alt="image" src="https://github.com/user-attachments/assets/a3649bff-9086-4467-9c6f-5290d42bd416" />

### TestNG Report
<img width="876" height="566" alt="image" src="https://github.com/user-attachments/assets/6b02ca93-e6ee-4c3e-8d11-a86e94312e4a" />
<img width="765" height="408" alt="image" src="https://github.com/user-attachments/assets/eccf2ab3-9af2-4236-8b8e-82acb16779b2" />
<img width="556" height="591" alt="image" src="https://github.com/user-attachments/assets/861f05e8-93b2-4a5c-aafa-c6301d7163eb" />

## Result

Successfully implemented the Lab 4 Search flow using an external **XML Object Repository** for storing Selenium locators.

This approach keeps locators separate from the automation code and makes them easier to maintain and update.


