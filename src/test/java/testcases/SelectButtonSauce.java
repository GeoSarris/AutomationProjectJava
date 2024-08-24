package testcases;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import base.DriverSetup;
import base.Locators;
import base.LoginPage;

public class SelectButtonSauce extends DriverSetup {

    SoftAssert softassert = new SoftAssert();
    private Locators locators = new Locators();
    public LoginPage login = new LoginPage();

    @Test
    public void itemSorting() throws InterruptedException {
        // Login to SauceDemo
        login.login();

        sortingSelect("lohi", locators.itemsPrice, Double.class);
        sortingSelect("hilo", locators.itemsPrice, Double.class);
        sortingSelect("az", locators.itemsTitle, String.class);
        sortingSelect("za", locators.itemsTitle, String.class);
        softassert.assertAll();
    }

    public void sortingSelect(String Value, By locator, Class<?> type) {
        // Selects price Ascending sorting and asserts sorting.
        WebElement selectElement = driver.findElement(locators.sortingButton);
        Select sortingItems = new Select(selectElement);
        sortingItems.selectByValue(Value);
        List<WebElement> elements = driver.findElements(locator);
        List<Object> actualSorting = new ArrayList<>();
        if (type == Double.class) {
            for (WebElement element : elements) {
                String priceString = element.getText().replace("$", "");
                double price = Double.parseDouble(priceString);
                actualSorting.add(price);
            }
        } else if (type == String.class) {
            for (WebElement element : elements) {
                String titleText = element.getText();
                actualSorting.add(titleText);
            }
        }
        
        List<Object> checkSorting = new ArrayList<>(actualSorting);
        if (Value == "lohi" || Value == "az") {
            Collections.sort((List) checkSorting);
        } else
            Collections.sort((List) checkSorting, Collections.reverseOrder());

        softassert.assertEquals(actualSorting, checkSorting);
        System.out.println(actualSorting);
    }
}
