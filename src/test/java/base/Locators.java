package base;

import org.openqa.selenium.By;

public class Locators {
    // Login locators
    public By usernameField = By.id("user-name");
    public By passwordField = By.id("password");
    public By loginButton = By.id("login-button");
    // Main page locators.
    public By itemsTitle = By.xpath("//div[@data-test='inventory-item-name']");
    public By shoppingCart = By.xpath("//a[@data-test='shopping-cart-link']");
    public By sortingButton = By.xpath("//select[@data-test='product-sort-container']");
    public By itemsPrice = By.xpath("//div[@data-test='inventory-item-price']");
    // All remove buttons (6) locator
    public By removeButtons = By.xpath("//button[text()='Remove']");
    // Sidebar locators
    public By mainMenuButton = By.id("react-burger-menu-btn");
    public By resetButton = By.id("reset_sidebar_link");
    public By logoutButton = By.id("logout_sidebar_link");
}
