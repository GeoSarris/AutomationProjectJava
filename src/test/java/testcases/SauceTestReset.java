package testcases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import base.DriverSetup;
import base.Locators;
import base.LoginPage;

public class SauceTestReset extends DriverSetup {

    public Locators locators = new Locators();
    public LoginPage loginPage = new LoginPage();
    public SoftAssert softassert = new SoftAssert();

    @Test
    public void resetTest(){
        loginPage.login();
        
        driver.findElement(By.xpath("//button[@data-test='add-to-cart-sauce-labs-backpack']")).click();
        driver.findElement(By.xpath("//button[@data-test='add-to-cart-sauce-labs-fleece-jacket']")).click();
        driver.findElement(By.xpath("//button[@data-test='add-to-cart-sauce-labs-bolt-t-shirt']")).click();

        List<WebElement> elements = driver.findElements(locators.removeButtons);
        softassert.assertEquals(elements.size(), 3);
        driver.findElement(locators.mainMenuButton).click();
        driver.findElement(locators.resetButton).click();
        driver.findElement(locators.logoutButton).click();

        loginPage.login();
        List<WebElement> elementsAfterReset = driver.findElements(locators.removeButtons);
        softassert.assertEquals(elementsAfterReset.size(),0);
        softassert.assertAll();
    }
    
}
