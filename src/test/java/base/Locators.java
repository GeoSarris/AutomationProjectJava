package base;

import org.openqa.selenium.By;

public class Locators {
    
    public By usernameField = By.id("user-name");
    public By passwordField = By.id("password");
    public By loginButton = By.id("login-button");
    public By itemsTitle = By.xpath("//div[@data-test='inventory-item-name']");
    public By shoppingCart = By.xpath("//a[@data-test='shopping-cart-link']");
    public By sortingButton = By.xpath("//select[@data-test='product-sort-container']");
}
