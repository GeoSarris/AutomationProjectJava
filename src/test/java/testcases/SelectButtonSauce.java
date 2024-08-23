package testcases;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import base.DriverSetup;
import base.Locators;

public class SelectButtonSauce extends DriverSetup  {

    SoftAssert softassert = new SoftAssert();
    private Locators locators = new Locators();

    @Test
    public void itemSorting() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        // Login to SauceDemo
        driver.findElement(locators.usernameField).sendKeys(prop.getProperty("username"));
        driver.findElement(locators.passwordField).sendKeys(prop.getProperty("password"));
        driver.findElement(locators.loginButton).click();

        // Selects price Ascending sorting and asserts sorting.
        WebElement selectElement = driver.findElement(locators.sortingButton);
        Select sortingItems = new Select(selectElement);
        sortingItems.selectByVisibleText("Price (low to high)");
        List<WebElement> ascendingElements = driver.findElements(By.xpath("//div[@data-test='inventory-item-price']"));
        List<Double> ascendingPrices = new ArrayList<>();

        for (WebElement priceElement : ascendingElements) {
            String priceString = priceElement.getText();
            double price = Double.parseDouble(priceString.replace("$", ""));
            ascendingPrices.add(price);
        }

        List<Double> sortedAscPrices = new ArrayList<>(ascendingPrices);
        Collections.sort(sortedAscPrices);
        softassert.assertEquals(ascendingPrices, sortedAscPrices, "  Prices not in ascending order");

        // Select price Descending sorting and asserts sorting.
        selectElement = wait.until(ExpectedConditions.presenceOfElementLocated(locators.sortingButton));
        sortingItems = new Select(selectElement);
        sortingItems.selectByValue("hilo");
        List<WebElement> descendingElements = driver.findElements(By.xpath("//div[@data-test='inventory-item-price']"));
        List<Double> descendingPrices = new ArrayList<>();
        for (WebElement priceElement : descendingElements) {
            String priceString = priceElement.getText();
            double price = Double.parseDouble(priceString.replace("$", ""));
            descendingPrices.add(price);
        }
        List<Double> sortedDescPrices = new ArrayList<>(descendingPrices);
        Collections.sort(sortedDescPrices, Collections.reverseOrder());
        softassert.assertEquals(descendingPrices, sortedDescPrices, "  Prices not in descending order");

        // Select Z-A item-name sorting and asserts sorting.
        selectElement = wait.until(ExpectedConditions.presenceOfElementLocated(locators.sortingButton));
        sortingItems = new Select(selectElement);
        sortingItems.selectByValue("za");
        List<WebElement> zaElements = driver.findElements(By.xpath("//div[@data-test='inventory-item-name']"));
        List<String> zaTitle = new ArrayList<>();

        for (WebElement zaElement : zaElements) {
            String titleText = zaElement.getText();
            zaTitle.add(titleText);
        }

        List<String> sortedZa = new ArrayList<>(zaTitle);
        Collections.sort(sortedZa, Collections.reverseOrder());
        softassert.assertEquals(sortedZa, zaTitle, "  Items not sorted Z-A");

        // Select A-Z item-name sorting and asserts sorting.
        selectElement = wait.until(ExpectedConditions.presenceOfElementLocated(locators.sortingButton));
        sortingItems = new Select(selectElement);
        sortingItems.selectByValue("az");
        List<WebElement> azElements = driver.findElements(By.xpath("//div[@data-test='inventory-item-name']"));
        List<String> azTitle = new ArrayList<>();

        for (WebElement azElement : azElements) {
            String titleText = azElement.getText();
            azTitle.add(titleText);
        }

        List<String> sortedAz = new ArrayList<>(azTitle);
        Collections.sort(sortedAz);
        softassert.assertEquals(sortedAz, azTitle, "  Items not sorted A-Z");

        System.out.println(sortedAscPrices);
        System.out.println(sortedDescPrices);
        System.out.println(sortedZa);
        System.out.println(sortedAz);

        // Final assertAll.
        softassert.assertAll();

    }
}
