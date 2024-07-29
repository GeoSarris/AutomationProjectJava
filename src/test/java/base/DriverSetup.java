package base;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
// import org.openqa.selenium.interactions.Actions;
// import org.openqa.selenium.support.ui.ExpectedConditions;
// import org.openqa.selenium.support.ui.Select;
// import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverSetup {

    public static WebDriver driver; // If not extend to testcase remove static and before/after notation!!!
    public static Properties prop = new Properties();
    public static FileReader freader;

    @BeforeMethod
    public void setUp() throws IOException {
        FileReader fReader = new FileReader(
                System.getProperty("user.dir") + "\\src\\test\\Resources\\ConfigFiles\\config.properties");
        prop.load(fReader);
        // Chrome browser
        if (prop.getProperty("browser").equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--disable-search-engine-choice-screen");
            driver = new ChromeDriver(options);
            driver.get(prop.getProperty("URL"));
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        }
        // Firefox browser
        else if (prop.getProperty("browser").equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
            driver.get(prop.getProperty("URL"));
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        }
        // Edge browser
        else if (prop.getProperty("browser").equalsIgnoreCase("edge")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
            driver.get(prop.getProperty("URL"));
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        }
    };

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    };


    //Reusable methods

    // public void clickElement (WebElement element, long waitTimeInSeconds){
    //     WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitTimeInSeconds));
    //     wait.until(ExpectedConditions.elementToBeClickable(element)).click();

    // }

    // public void sendKeysOnElement(WebElement element, String text){
    //     element.click();
    //     element.clear();
    //     element.sendKeys(text);
    // }

    // public void selectByVisibleText(WebElement element, String text){
    //     Select select = new Select(element);
    //     select.selectByVisibleText(text);

    // }

    // public void acceptAlert(WebDriver driver){
    //     driver.switchTo().alert().accept();
    // }

    // public void mouseHoverAndClick(WebElement element){
    //     Actions action = new Actions(driver);
    //     action.moveToElement(element).click().build().perform();
    // }

    
}
