package base;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverSetup {

    public static WebDriver driver; // If not extend to testcase remove static and before/after notation!!!
    public static Properties prop = new Properties();
    public static FileReader freader;

    //Create driver for selected browser from config.properties
    @BeforeMethod
    protected void setUp() throws IOException {
        FileReader fReader = new FileReader(
                System.getProperty("user.dir") + "\\src\\test\\Resources\\ConfigFiles\\config.properties");
        prop.load(fReader);
        // Chrome browser
        if (prop.getProperty("browser").equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--disable-search-engine-choice-screen");
            driver = new ChromeDriver(options);
        }
        // Firefox browser
        else if (prop.getProperty("browser").equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }
        // Edge browser
        else if (prop.getProperty("browser").equalsIgnoreCase("edge")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        }
        driver.get(prop.getProperty("URL"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    };

    //Tear down driver.
    @AfterMethod
    protected void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    };

}
