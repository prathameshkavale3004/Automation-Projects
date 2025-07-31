UI & API Automation Testing – ExpandTesting Practice Project

This project demonstrates automated testing of the [ExpandTesting Practice Website](https://practice.expandtesting.com) including both **UI** and **REST API** layers. The project includes:


- Automated UI tests using **Selenium + TestNG + Java**
- Automated API tests using **Rest Assured + Java**


##  Technologies Used

- **Java**
- **Selenium WebDriver**
- **TestNG**
- **Rest Assured**
- **Postman (for manual API testing)**

- ## How to Run This Project

### UI Automation

1. Open the `/ui-automation` folder in your IDE.
2. Ensure dependencies are managed using Maven/Gradle.
3. Run 'LoginTest.java' and 'FileUploadTest' classes.

## DriverFactory.java
Provides a factory method to initialize and return a WebDriver instance, currently configured to launch Microsoft Edge for UI automation tests.

## LoginPage.java
Encapsulates login page interactions using the Page Object Model, including entering credentials, clicking login/logout buttons, and retrieving flash messages.

## FileUploadPage.java
Represents the File Upload page in the UI automation framework; handles file selection, upload actions, and retrieving confirmation or flash messages using Selenium Page Object Model (POM).

## LoginTests
This test class verifies the login functionality of the web application using valid and invalid credentials. It ensures correct flash messages are displayed for login, logout, and failure scenarios.

## FileUploadTests.java
Contains TestNG-based test cases to verify file upload functionality, including valid and invalid file size scenarios, using the Selenium WebDriver and the FileUploadPage objec

### API Automation

1. Open the `/api-automation` folder.
2. Run test classes as TestNG tests.
3. Make sure `baseURI` and any required tokens are correctly set.
4. Run 'UserTest.java' file.

## UserTest.java
Automates end-to-end testing of user-related APIs such as registration, login, note creation, and retrieval using Rest Assured and TestNG.

---

##  Author

**Prathamesh Kavale**  
Email: *[ptkavale@gmail.com]*
