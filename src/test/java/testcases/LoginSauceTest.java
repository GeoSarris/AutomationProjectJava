package testcases;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import base.DriverSetup;
import base.Locators;
import utilities.ReadXLSdata;

public class LoginSauceTest extends DriverSetup{

    public SoftAssert softassert = new SoftAssert();
    private Locators locators = new Locators();

    @Test(dataProviderClass = ReadXLSdata.class,dataProvider = "logindata")
    public void loginTest(String username, String password) throws EncryptedDocumentException, InterruptedException {

        driver.findElement(locators.usernameField).sendKeys(username);
        driver.findElement(locators.passwordField).sendKeys(password);
        driver.findElement(locators.loginButton).click();
        String newPageUrl = driver.getCurrentUrl();
        System.out.println(newPageUrl);

        try {
            Assert.assertEquals(newPageUrl, "https://www.saucedemo.com/inventory.html", "Login attempt with username: " + username + " and password: " + password + " failed.");
        } catch (AssertionError e) {
            driver.navigate().to("https://www.saucedemo.com/");
            throw e;
        }

    }
}
