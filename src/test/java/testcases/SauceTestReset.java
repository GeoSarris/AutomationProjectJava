package testcases;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
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

        List<WebElement> elements = driver.findElements(By.xpath("//button[text()='Remove']"));
        softassert.assertEquals(elements.size(), 3);
        driver.findElement(By.id("react-burger-menu-btn")).click();
        driver.findElement(By.id("reset_sidebar_link")).click();
        driver.findElement(By.id("logout_sidebar_link")).click();

        loginPage.login();
        List<WebElement> elementsAfterReset = driver.findElements(By.xpath("//button[text()='Remove']"));
        softassert.assertEquals(elementsAfterReset.size(),0);
        softassert.assertAll();
    }
    
}
