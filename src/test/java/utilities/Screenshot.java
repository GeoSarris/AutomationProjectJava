package utilities;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import base.DriverSetup;

public class Screenshot extends DriverSetup{
    
    public static String screenshotFileName;

    //Takes a screenshot and creates a file with current date as name.
    public void getScreenshot() throws IOException{
        Date currentDate = new Date();
        screenshotFileName = currentDate.toString().replace(" ", ".").replace(":","-");
        File screenshotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshotFile, new File(".//screenshot/"+screenshotFileName+".png"));
    }
}
