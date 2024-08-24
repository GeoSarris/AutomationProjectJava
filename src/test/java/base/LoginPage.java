package base;

import org.openqa.selenium.Keys;

public class LoginPage extends DriverSetup {

    public Locators locators = new Locators();

    public void login() {
        driver.findElement(locators.usernameField).sendKeys(prop.getProperty("username"));
        driver.findElement(locators.passwordField).sendKeys(prop.getProperty("password"), Keys.ENTER);
    }
}
