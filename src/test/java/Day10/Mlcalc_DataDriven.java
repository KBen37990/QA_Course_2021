package Day10;

import Reusable_Methods.Reusable_Methods;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class Mlcalc_DataDriven {
    public static void main(String[] args) throws IOException, InterruptedException, WriteException, BiffException {

        //Set the driver using reusable method
        WebDriver driver = Reusable_Methods.defineTheDriver();

        //Step 1: Locate the path for readable file that we created in excel
        Workbook readableBook = Workbook.getWorkbook(new File("src/main/resources/Mlcalc_DataDriven.xls"));

        //Step 2: Create a writable workbook that will mimic the data from readable
        WritableWorkbook writableWorkbook = Workbook.createWorkbook(new File("src/main/resources/Mlcalc_DataDriven_Results.xls"),readableBook);

        //Step 3: Read everything form writeable sheet
        WritableSheet writableSheet = writableWorkbook.getSheet(0);

        //Step 4: Get the row count
        int rowCount = writableSheet.getRows();

        //This is where the for loop will start to iterate through your excel data
        for(int i = 1; i < rowCount; i++){

            //Columns are hard coded and row is dynamic(i)
            String pPrice = writableSheet.getCell(0,i).getContents();
            String dPayment = writableSheet.getCell(1,i).getContents();
            String mTerm = writableSheet.getCell(2,i).getContents();
            String iRate = writableSheet.getCell(3,i).getContents();
            String stMonth = writableSheet.getCell(4,i).getContents();
            String stYear = writableSheet.getCell(5,i).getContents();

            //Navigate to mlcalc
            driver.navigate().to("https://www.mlcalc.com");
            Thread.sleep(3000);

            //Enter the purchase price
            Reusable_Methods.sendKeysMethod(driver,"//input[@id='ma']",pPrice,"Purchase Price");
            //Enter the down payment
            Reusable_Methods.sendKeysMethod(driver,"//input[@id='dp']",dPayment,"Down Payment");
            //Enter the mortgage term
            Reusable_Methods.sendKeysMethod(driver,"//input[@id='mt']",mTerm,"Mortgage Term");
            //Enter the interest rate
            Reusable_Methods.sendKeysMethod(driver,"//input[@id='ir']",iRate,"Interest Rate");
            //Select the start month
            Reusable_Methods.dropdownByText(driver,"//select[@name='sm']",stMonth,"Start Month");
            //Select start year
            Reusable_Methods.dropdownByText(driver,"//select[@name='sy']",stYear,"Start Year");
            //Click on Calculate
            Reusable_Methods.clickOnElement(driver,"//input[@value='Calculate']","Calculate");

            //Capture monthly payment
            String monthlyPayment = Reusable_Methods.captureText(driver,"//td[@class='big']",0,"Monthly Payment");


            //Create a label so you can add it to a cell
            Label label = new Label(6,i,monthlyPayment);
            //add the label back to the sheet
            writableSheet.addCell(label);
        }//End of loop

        //Outside of the cell write back to writable workbook
        writableWorkbook.write();
        //Close it
        writableWorkbook.close();



    }//End of main
}//End of java class
