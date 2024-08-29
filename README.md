# Saucedemo Automation Testing Project

## Packages Overview

### Base Package

The **base** package contains 4 reusable classes that are utilized across multiple tests:

1. **DriverSetup.java**:
    - Contains the code for setting up a WebDriver for declared browsers (Chrome, Firefox, Edge).
    - Includes two methods:
        - `setUp()`: Initializes the WebDriver before each test method.
        - `tearDown()`: Cleans up and closes the WebDriver after each test method.
    - This class is extended by each test class in the `testcases` package.

2. **Listeners.java**:
    - Implements TestNG listeners to report the status of test execution (pass/fail).
    - Captures screenshots on test failures using the `Screenshot` class from the `utilities` package.

3. **Locators.java**:
    - Contains reusable locators as variables, making it easier to maintain and reuse them across tests.

4. **LoginPage.java**:
    - Provides a method to log in to the application with correct credentials.

### Utilities Package

The **utilities** package includes 2 classes that assist with common functionalities:

1. **Screenshot.java**:
    - Provides a method for capturing screenshots, typically called when a test fails.

2. **ReadXLSdata.java**:
    - Contains a method to read data from an XLS file and returns the data as a `String[][]`.

### Testcases Package

The **testcases** package contains 4 classes that represent the tests created for the Saucedemo application:

1. **UserLoginTest.java**:
    - Tests the login functionality with 5 different users (including a blocked user).
    - 4 out of 5 login attempts are expected to pass.

2. **SelectButtonTest.java**:
    - Tests the sorting functionality using the selection button.
    - Asserts that items are correctly sorted according to the 4 available sorting options.

3. **SauceTestReset.java**:
    - Tests the reset button functionality.
    - The test adds 3 items, clicks the reset button, logs out, and logs in again.
    - Verifies that all items should display an "Add to Cart" button and that there should be 0 "Remove" buttons.

4. **SauceDemo.java**:
    - Contains 3 different tests executed in a specific priority:
        1. Verifies correct item redirection by checking that the same item is displayed.
        2. Tests the "Add to Cart" buttons by asserting that the number of items in the cart matches the number added.
        3. Tests the "Remove" button functionality by adding items, removing them, and verifying that the cart is empty.

In the **Resources** folder are ConfigFiles, Logs, Reports and TestData user in the tests.
