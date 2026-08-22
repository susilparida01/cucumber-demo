# Cucumber Selenium Automation Demo

This is a Java Maven automation project that uses Cucumber, JUnit, Selenium WebDriver, and WebDriverManager to test the login flow for the OrangeHRM demo application.

## Tech Stack

- Java 21
- Maven
- Cucumber JVM 7.31.0
- JUnit runner for Cucumber
- Selenium Java 4.36.0
- WebDriverManager 6.3.3
- Google Chrome / ChromeDriver

## Project Structure

```text
cucumberdemo
|-- pom.xml
|-- src
|   |-- main
|   |   `-- java
|   |       `-- com/simplilearn/cucumberdemo/pages
|   |           `-- LoginPage.java
|   `-- test
|       |-- java
|       |   |-- runner
|       |   |   `-- TestRunner.java
|       |   `-- stepsdefinitions
|       |       |-- Hooks.java
|       |       |-- LoginSteps.java
|       |       `-- LoginSteps_old.java
|       `-- resources
|           `-- features
|               `-- login.feature
`-- target
    |-- cucumber-reports.html
    `-- cucumber-report.html
```

## What The Test Covers

The active feature file is:

```text
src/test/resources/features/login.feature
```

It validates a successful login to the OrangeHRM demo site:

1. Open the OrangeHRM login page.
2. Enter username `admin`.
3. Enter password `admin123`.
4. Click the login button.
5. Verify that the Dashboard page is displayed.

## Key Classes

- `TestRunner.java` starts the Cucumber test run with JUnit.
- `Hooks.java` creates and closes the Chrome browser before and after each scenario.
- `LoginSteps.java` maps Gherkin steps from `login.feature` to Java test code.
- `LoginPage.java` contains page-object methods for login form actions and dashboard validation.
- `LoginSteps_old.java` appears to be an older direct-Selenium implementation and is not used by the current feature because its step text does not match the active scenario.

## Prerequisites

Install the following before running the tests:

- Java JDK 21
- Apache Maven
- Google Chrome

Verify the installations:

```bash
java -version
mvn -version
```

WebDriverManager downloads and configures the matching ChromeDriver automatically during test execution.

## How To Run Tests

From the project root, run:

```bash
mvn test
```

Maven will compile the project and execute the Cucumber runner:

```text
src/test/java/runner/TestRunner.java
```

## Test Report

After execution, the HTML report is generated at:

```text
target/cucumber-reports.html
```

Open this file in a browser to review the scenario result.

## Cucumber Configuration

The runner uses the following configuration:

```java
@CucumberOptions(
    features = "src/test/resources/features",
    glue = {"stepsdefinitions"},
    plugin = {"pretty", "html:target/cucumber-reports.html"},
    monochrome = true
)
```

## Current Test Data

The credentials are defined in the feature file:

```gherkin
When user enters username "admin"
And user enters password "admin123"
```

The application URL is defined in `Hooks.java`:

```java
driver.get("https://opensource-demo.orangehrmlive.com/");
```

## Known Maintenance Notes

- `LoginPage.java` currently declares elements using `@FindBy`, but the constructor does not initialize them with Selenium `PageFactory`. The methods also cast `WebElement` fields to `By`, which can cause runtime failures. A cleaner page object should either use `By` locators directly or initialize `@FindBy` fields with `PageFactory.initElements(driver, this)`.
- `LoginSteps.java` uses `Thread.sleep(3000)` before checking the dashboard. Prefer Selenium explicit waits for more reliable tests.
- `LoginSteps_old.java` can be removed if it is no longer required.
- The suite launches a visible Chrome browser. For CI execution, consider adding headless Chrome options in `Hooks.java`.

## Common Troubleshooting

### Maven cannot find Java 21

Make sure `JAVA_HOME` points to a JDK 21 installation and that Maven is using the same JDK:

```bash
mvn -version
```

### ChromeDriver setup fails

Check that Chrome is installed and accessible. WebDriverManager should download the compatible driver automatically, but corporate proxies or blocked network access may prevent the download.

### Login test fails at element lookup

The OrangeHRM demo site can change its markup or load slowly. Verify the locators in `LoginPage.java` and replace fixed sleeps with explicit waits if the page takes longer to load.
