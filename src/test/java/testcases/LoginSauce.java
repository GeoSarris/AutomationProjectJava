package testcases;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import base.DriverSetup;
import base.Locators;
import utilities.ReadXLSdata;

public class LoginSauce extends DriverSetup{

    public SoftAssert softassert = new SoftAssert();
    private Locators locators = new Locators();

    @Test(dataProviderClass = ReadXLSdata.class,dataProvider = "logindata")
    public void loginTest(String username, String password) throws EncryptedDocumentException, InterruptedException {

        driver.findElement(locators.usernameField).sendKeys(username);
        driver.findElement(locators.passwordField).sendKeys(password);
        driver.findElement(locators.loginButton).click();
        String newPageUrl = driver.getCurrentUrl();
        System.out.println(newPageUrl);


        // boolean successfulLogin = newPageUrl.equals("https://www.saucedemo.com/inventory.html");

        // softassert.assertEquals(successfulLogin,true);
        // if(!successfulLogin){
        //     driver.navigate().to(prop.getProperty("URL"));
        // }
        // softassert.assertAll();

        try {
            Assert.assertEquals(newPageUrl, "https://www.saucedemo.com/inventory.html", "Login attempt with username: " + username + " and password: " + password + " failed.");
        } catch (AssertionError e) {
            // If login failed, navigate back to the login page
            driver.navigate().to("https://www.saucedemo.com/");
            // Throw the assertion error again to mark this particular test case as failed
            throw e;
        }

    }
}
