# **Final Project Test Automation**

This repository contains both API and UI test automation scripts for the final-project-test-automation project. The tests are developed using Java, managed with Gradle, and implemented using frameworks and libraries like Cucumber, Selenium, and Rest Assured. Continuous Integration and Continuous Deployment (CI/CD) is handled using GitHub Actions.

## **Features**

**Gherkin Structure**: Test scenarios are written in Gherkin syntax using Cucumber.

**Page Object Model (POM)**: Project follows the POM principle to separate concerns and improve code maintainability.

**Reports**: Generates test reports in HTML and JSON formats.

**CI/CD**: Automates test execution via GitHub Actions.

## **Tools and Libraries**

**Programming Language**: Java

**Build Tool**: Gradle

**Frameworks and Libraries**:

Cucumber (for BDD scenarios)

Selenium (for UI testing)

Rest Assured (for API testing)

**CI/CD Platform**: GitHub Actions

## **Project Structure**

### **API Test Automation (apiAuto)**

**pages**: Contains reusable methods for interacting with the API.

**stepDef**: Defines Cucumber step definitions and calls methods from pages.

**runner**: Executes the Cucumber scenarios for API tests.

**helper**: Includes utilities for endpoints, test data, and reusable functions (e.g., random email generation).

### **UI Test Automation (uiTest)**

**pages**: Contains reusable methods for interacting with the UI.

**stepDef**: Defines Cucumber step definitions and calls methods from pages.

**runner**: Executes the Cucumber scenarios for UI tests.

**helper**: Includes utilities like random data generation.

**baseTest**: Manages WebDriver setup and configuration.

## **How to Run Tests**

### **Prerequisites**

1. Clone this repository: git clone https://github.com/fadillatika/final-project-test-automation.git

2. Ensure Java and Gradle are installed.

3. Install ChromeDriver if running UI tests locally.

4. Running Tests Locally

### **Run the following commands in the terminal:**

#### **API Tests:**

./gradlew cucumber -PtestType=api

#### **UI Tests:**

./gradlew cucumber -PtestType=web

#### **Running Tests on GitHub Actions**

GitHub Actions automatically runs tests for each push. Navigate to the Actions tab in your GitHub repository to view the test results. Test reports are available as downloadable artifacts.

## **Test Scenarios**

**API Tests**: Built using REST APIs from GoRest.

**UI Tests**: Interact with the demo website Demoblaze.

## **Reports**

Test reports are generated in HTML and JSON formats and stored in the reports directory.

Artifacts can be downloaded directly from GitHub Actions.
