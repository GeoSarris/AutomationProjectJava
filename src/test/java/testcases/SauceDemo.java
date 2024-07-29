package testcases;

import base.Locators;
import base.DriverSetup;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SauceDemo extends DriverSetup {

    public SoftAssert softassert = new SoftAssert();
    private Locators locators = new Locators();

    @Test(priority = 1)
    public void checkItems() throws InterruptedException {

        driver.findElement(locators.usernameField).sendKeys(prop.getProperty("username"));
        driver.findElement(locators.passwordField).sendKeys(prop.getProperty("password"), Keys.ENTER);
        List<WebElement> elements = driver.findElements(locators.itemsTitle);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        //Iterates through all items 
        for (int i=0; i<elements.size();i++){
            elements = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locators.itemsTitle));
            WebElement element = elements.get(i);

            String itemTitle = element.getText();
            element.click();

            String actualText = driver.findElement(locators.itemsTitle).getText();
            softassert.assertEquals(actualText, itemTitle);
            driver.navigate().back();
        }
    }

    @Test(priority = 2)
    public void checkCart(){

        driver.findElement(locators.usernameField).sendKeys(prop.getProperty("username"));
        driver.findElement(locators.passwordField).sendKeys(prop.getProperty("password"), Keys.ENTER);
        driver.findElement(By.xpath("//button[@data-test='add-to-cart-sauce-labs-backpack']")).click();
        driver.findElement(By.xpath("//button[@data-test='add-to-cart-sauce-labs-fleece-jacket']")).click();
        driver.findElement(locators.shoppingCart).click();

        List<WebElement> elements = driver.findElements(By.xpath("//div[@data-test='inventory-item-name']"));
        softassert.assertEquals(elements.size(), 2);


    }

    @Test(priority = 3)
    public void checkRemoveButton(){
        driver.findElement(locators.usernameField).sendKeys(prop.getProperty("username"));
        driver.findElement(locators.passwordField).sendKeys(prop.getProperty("password"), Keys.ENTER);

        driver.findElement(By.xpath("//button[@data-test='add-to-cart-sauce-labs-backpack']")).click();
        driver.findElement(By.xpath("//button[@data-test='add-to-cart-sauce-labs-fleece-jacket']")).click();
        driver.findElement(By.xpath("//button[@data-test='remove-sauce-labs-backpack']")).click();
        driver.findElement(By.xpath("//button[@data-test='remove-sauce-labs-fleece-jacket']")).click();

        List<WebElement> elements = driver.findElements(By.xpath("//div[@data-test='inventory-item-name']"));
        softassert.assertEquals(elements.size(), 0);

    }

}
