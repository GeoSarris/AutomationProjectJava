package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;

public class ReadXLSdata {

    //Data provider for
    @DataProvider (name="logindata")
    public String[][] getData(Method m) throws EncryptedDocumentException, IOException{

        String excelName = m.getName();
        File f1 = new File(System.getProperty("user.dir")+"\\src\\test\\Resources\\Testdata\\testdata.xlsx");
        FileInputStream fileStream = new FileInputStream(f1); 
        Workbook wb = WorkbookFactory.create(fileStream);
        Sheet sheetName = wb.getSheet(excelName);
        
        int totalRows = sheetName.getLastRowNum();
       
        Row rowCells = sheetName.getRow(0); 

        int totalCols = rowCells.getLastCellNum();


        DataFormatter format = new DataFormatter();
        String testData[][]= new String[totalRows][totalCols];

        //Passes the excel data in the testData[][] variable by iterating all rows and cols
        for (int i=1; i<=totalRows;i++){
            for(int j=0;j<totalCols;j++){
                testData[i-1][j]=format.formatCellValue(sheetName.getRow(i).getCell(j));
            }
        }

        wb.close();
        fileStream.close();
        return testData;
    }

    
}
