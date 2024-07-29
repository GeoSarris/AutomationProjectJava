package base;

import java.io.IOException;

import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import utilities.Screenshot;


public class Listeners extends Screenshot implements ITestListener{
    
    public void onTestStart(ITestResult result){
        System.setProperty("org.uncommons.reportng.tittle","SauceDemo Test Report");
        Reporter.log("Method name is "+ result.getName());
    }

    public void onTestSuccess(ITestResult result){
        Reporter.log("Status of execution is -> "+result.getStatus());
    }

    public void onTestFailure(ITestResult result){
        Reporter.log("Status of execution is -> "+result.getStatus());
        System.out.println("Test "+ result.getName() + " failed: screenshot captured");
        try{
            getScreenshot();
        }catch(IOException e){
            e.printStackTrace();
        }
        System.setProperty("org.uncommons.reportng.escape-output","false");
        Reporter.log("<a href=\"C:\\Users\\motzos\\Desktop\\JavaTesting\\automationtesting\\screenshot\\"+screenshotFileName+".png\">Failure screeshot</a>");
    }

    public void onTestSkipped(ITestResult result){
        System.out.println("Test " + result.getName() + " skipped.");
    }
}
