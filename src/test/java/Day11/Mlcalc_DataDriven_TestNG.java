package Day11;

import ReusableLibrary.Abstract_Class;
import ReusableLibrary.Reusable_Actions;
import Reusable_Methods.Reusable_Methods;
import com.relevantcodes.extentreports.LogStatus;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Mlcalc_DataDriven_TestNG extends Abstract_Class {

    //declare your global variables
    WebDriver driver = null;
    WritableWorkbook writableWorkbook = null;
    WritableSheet writableSheet = null;
    int rowCount = 0;


    //Setup your preconditions on before suite
    //These are preconditions since they are only called once and the test begins with the for loop
    @BeforeSuite
    public void preconditions() throws IOException, InterruptedException, BiffException {
        //Set the driver using reusable method
        driver = Reusable_Methods.defineTheDriver();

        //Step 1: Locate the path for readable file that we created in excel
        Workbook readableBook = Workbook.getWorkbook(new File("src/main/resources/Mlcalc_DataDriven.xls"));

        //Step 2: Create a writable workbook that will mimic the data from readable
        writableWorkbook = Workbook.createWorkbook(new File("src/main/resources/Mlcalc_DataDriven_Results.xls"),readableBook);

        //Step 3: Read everything form writeable sheet
        writableSheet = writableWorkbook.getSheet(0);

        //Step 4: Get the row count
        rowCount = writableSheet.getRows();
    }//End of preconditions


    @Test
    public void testScenario() throws WriteException, InterruptedException, BiffException, IOException {

        //Step 1: Locate the path for readable file that we created in excel
        Workbook readableBook = Workbook.getWorkbook(new File("src/main/resources/Mlcalc_DataDriven.xls"));

        //Step 2: Create a writable workbook that will mimic the data from readable
        writableWorkbook = Workbook.createWorkbook(new File("src/main/resources/Mlcalc_DataDriven_Results.xls"),readableBook);

        //Step 3: Read everything form writeable sheet
        writableSheet = writableWorkbook.getSheet(0);

        //Step 4: Get the row count
        rowCount = writableSheet.getRows();

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
            Thread.sleep(1000);

            //Click on advanced
            Reusable_Actions.clickOnElement(driver,"//*[@class='href']", logger, "Click on advanced");
            //enter the purchase price
            Reusable_Actions.sendKeysMethod(driver,"//input[@id='ma']",pPrice, logger,"Purchase Price");
            //enter the down payment
            Reusable_Actions.sendKeysMethod(driver,"//input[@id='dp']",dPayment,logger,"Down Payment");
            //enter mortgage term
            Reusable_Actions.sendKeysMethod(driver,"//input[@id='mt']",mTerm,logger,"Mortgage Term");
            //enter interest rate
            Reusable_Actions.sendKeysMethod(driver,"//input[@id='ir']",iRate,logger,"Interest Rate");
            //select start month
            Reusable_Actions.dropdownByText(driver,"//select[@name='sm']",stMonth,logger,"Start Month");
            //select start year
            Reusable_Actions.dropdownByText(driver,"//select[@name='sy']",stYear,logger,"Start Year");
            //click on Calculate
            Reusable_Actions.clickOnElement(driver,"//input[@value='Calculate']", logger, "Calculate");


            //Capture monthly payment
            String monthlyPayment = Reusable_Methods.captureText(driver,"//td[@align='center']",0,"Monthly Payment");

            //print out the monthly payment to see the result in my log
            logger.log(LogStatus.INFO, "Monthly payment is " + monthlyPayment);

            //Create a label so you can add it to a cell
            Label label = new Label(6,i,monthlyPayment);
            //add the label back to the sheet
            writableSheet.addCell(label);
        }//End of loop
    }//End of test scenario


    @AfterSuite
    public void closeWorkbook() throws IOException, WriteException {
        //Outside of the cell write back to writable workbook
        writableWorkbook.write();
        //Close it
        writableWorkbook.close();

        driver.quit();

        //open writable excel automatically
        Desktop.getDesktop().open(new File("src/main/resources/Mlcalc_DataDriven_Results.xls"));

    }//End of close workbook


}//End of java class
