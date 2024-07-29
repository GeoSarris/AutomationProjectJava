// package testcases;

// import base.Locators;
// import base.DriverSetup;

// import java.time.Duration;
// import java.util.List;

// import org.openqa.selenium.By;
// import org.openqa.selenium.WebElement;
// import org.openqa.selenium.support.FindBy;
// import org.openqa.selenium.support.PageFactory;
// import org.openqa.selenium.support.ui.ExpectedConditions;
// import org.openqa.selenium.support.ui.WebDriverWait;
// import org.testng.annotations.Test;
// import org.testng.asserts.SoftAssert;

// public class MyFirstTestFactory extends DriverSetup {
    
//     @FindBy (id="user-name") private WebElement username;
//     @FindBy (id="password") private WebElement password;
//     @FindBy (id="login-button") private WebElement loginButton;
//     @FindBy (xpath = "//div[@data-test='inventory-item-name']")
//     private WebElement itemsTitle;
//     @FindBy (xpath = "//a[@data-test='shopping-cart-link']")
//     private WebElement shoppingCart;
    
//     public SoftAssert softassert = new SoftAssert();
//     public Locators locators = new Locators();
//      public void SauceLogin(){
//          PageFactory.initElements(driver, this);
//      }
//     @Test(priority = 1)
//     public void checkItems() throws InterruptedException {
//         sendKeysOnElement(username, prop.getProperty("username"));
//         sendKeysOnElement(password, prop.getProperty("password"));  
//         clickElement(loginButton, 5);
//         List<WebElement> elements = driver.findElements(locators.itemsTitle);
//         WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

//         //Iterates through all items 
//         for (int i=0; i<elements.size();i++){
//             elements = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locators.itemsTitle));
//             WebElement element = elements.get(i);

//             String itemTitle = element.getText();
//             element.click();

//             String actualText = driver.findElement(locators.itemsTitle).getText();
//             softassert.assertEquals(actualText, itemTitle);
//             driver.navigate().back();
//         }
//     }

//     @Test(priority = 2)
//     public void checkCart(){

//         sendKeysOnElement(username, prop.getProperty("username"));
//         sendKeysOnElement(password, prop.getProperty("password"));  
//         clickElement(loginButton, 5);
//         driver.findElement(By.xpath("//button[@data-test='add-to-cart-sauce-labs-backpack']")).click();
//         driver.findElement(By.xpath("//button[@data-test='add-to-cart-sauce-labs-fleece-jacket']")).click();
//         driver.findElement(locators.shoppingCart).click();

//         List<WebElement> elements = driver.findElements(By.xpath("//div[@data-test='inventory-item-name']"));
//         softassert.assertEquals(elements.size(), 2);


//     }

// }
