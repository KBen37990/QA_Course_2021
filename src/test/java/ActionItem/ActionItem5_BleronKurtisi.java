package ActionItem;

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

public class ActionItem5_BleronKurtisi {
    public static void main(String[] args) throws IOException, InterruptedException, BiffException, WriteException {
        //Set the driver using reusable method
        WebDriver driver = Reusable_Methods.defineTheDriver();

        //Step 1: Locate the path for readable file that we created in excel
        Workbook readableBook = Workbook.getWorkbook(new File("src/main/resources/Express_DataDriven.xls"));

        //Step 2: Create a writable workbook that will mimic the data from readable
        WritableWorkbook writableWorkbook = Workbook.createWorkbook(new File("src/main/resources/Express_DataDriven_Results.xls"),readableBook);

        //Step 3: Read everything form writeable sheet
        WritableSheet writableSheet = writableWorkbook.getSheet(0);

        //Step 4: Get the row count
        int rowCount = writableSheet.getRows();

        //This is where the for loop will start to iterate through your excel data
        for(int i = 1; i < rowCount; i++) {

            String size = writableSheet.getCell(0,i).getContents();
            String quantity = writableSheet.getCell(1,i).getContents();
            String firstName = writableSheet.getCell(2,i).getContents();
            String lastName = writableSheet.getCell(3,i).getContents();
            String email = writableSheet.getCell(4,i).getContents();
            String phone = writableSheet.getCell(5,i).getContents();
            String streetAddress = writableSheet.getCell(6,i).getContents();
            String zipcode = writableSheet.getCell(7,i).getContents();
            String city = writableSheet.getCell(8,i).getContents();
            String state = writableSheet.getCell(9,i).getContents();
            String ccNumber = writableSheet.getCell(10,i).getContents();
            String expMonth = writableSheet.getCell(11,i).getContents();
            String expYear = writableSheet.getCell(12,i).getContents();
            String cvvCode = writableSheet.getCell(13,i).getContents();

            //Test Step 1: Navigate to Express website
            driver.manage().deleteAllCookies();
            driver.navigate().to("https://www.express.com");
            Thread.sleep(1000);

            //Close the pop up advertisement
            Reusable_Methods.clickOnElement(driver, "//*[@id='closeModal']", "Close Ad");
            Thread.sleep(1000);

            //Test Step 2: Hover over to Men tab (this is where you will be using mouse hover method)
            Reusable_Methods.mouseHover(driver, "//a[text()='Men']", "Men Tab");
            Thread.sleep(1000);

            //Test Step 3: On clothing section click on sweaters
            Reusable_Methods.clickOnElement(driver, "//a[text()='Sweatshirts & Hoodies']", "sweaters");
            Thread.sleep(1000);

            //Test Step 4: On the next page click on first sweater you see
            Reusable_Methods.clickOnElement(driver, "//*[@class='_2EWqA']", "First sweater");
            Thread.sleep(1500);

            //Test Step 5: Click on a size
            Reusable_Methods.clickOnElement(driver, "//button[@value='" + size + "']","Click on a Size");
            Thread.sleep(1000);

            //Test Step 6: Click on Add to Bag
            Reusable_Methods.clickOnElement(driver, "//button[text()='Add to Bag']", "Add to Bag");
            Thread.sleep(2000);

            //Test Step 7: You will see pop up appears and click on View Bag
            Reusable_Methods.clickOnElement(driver,"//*[text()='View Bag']","View Bag");
            Thread.sleep(1000);

            //Test Step 8: Change the quantity
            Reusable_Methods.dropdownByText(driver,"//*[@id='qdd-0-quantity']", quantity , "Change quantity");
            Thread.sleep(1000);

            //Test Step 9: Click on Checkout to the right section of the page
            Reusable_Methods.clickOnElement(driver,"//button[text()='Checkout']","Checkout");
            Thread.sleep(1000);

            //Test Step 10: On pop up click on Continue as Guest
            Reusable_Methods.clickOnElement(driver,"//button[text()='Checkout as Guest']","Checkout as Guest");
            Thread.sleep(1000);

            //Test Step 11: Enter first name
            Reusable_Methods.sendKeysMethod(driver,"//input[@name='firstname']", firstName, "First Name");

            //Test Step 12: Enter last name
            Reusable_Methods.sendKeysMethod(driver,"//input[@name='lastname']", lastName, "Last Name");

            //Test Step 13: Enter email (valid format but can be fake email)
            Reusable_Methods.sendKeysMethod(driver,"//input[@name='email']", email, "Enter Email");

            //Test Step 14: Re enter email to confirm (valid format but can be fake email)
            Reusable_Methods.sendKeysMethod(driver,"//input[@name='confirmEmail']", email, "Re enter Email");

            //Test Step 15: Phone number (valid US format but can be fake number)
            Reusable_Methods.sendKeysMethod(driver,"//input[@name='phone']", phone, "Enter Phone Number");
            Thread.sleep(1500);

            //Test Step 16: Click on continue
            Reusable_Methods.clickOnElement(driver,"//span[text()='Continue']","Click on Continue");
            Thread.sleep(1500);

            //Test Step 17: Enter street address
            Reusable_Methods.sendKeysMethod(driver,"//input[@name='shipping.line1']", streetAddress, "Street Address");

            //Test Step 18: Enter a valid zipcode
            Reusable_Methods.sendKeysMethod(driver,"//input[@name='shipping.postalCode']",zipcode, "Zipcode");

            //Test Step 19: Enter a city(let’s just choose new York boroughs)
            Reusable_Methods.sendKeysMethod(driver,"//input[@name='shipping.city']",city, "City");

            //Test Step 20: Select a state(just choose NY for this assignment)
            Reusable_Methods.dropdownByText(driver,"//select[@name='shipping.state']",state,"State");
            Thread.sleep(1000);

            //Test Step 21: Click on continue button
            Reusable_Methods.clickOnElement(driver,"//span[text()='Continue']","Click on Continue");
            Thread.sleep(3000);

            //Test Step 21.1:Click on continue button
            Reusable_Methods.clickOnElement(driver,"//span[text()='Continue']", "Click on Continue");
            Thread.sleep(3000);

            //Test Step 22: Enter fake credit card number
            Reusable_Methods.sendKeysMethod(driver,"//input[@id='creditCardNumberInput']",ccNumber, "Fake Credit Card Number");

            //Test Step 23: Select an expiration date
            Reusable_Methods.dropdownByText(driver,"//select[@name='expMonth']", expMonth, "Expiration Date");
            Thread.sleep(1500);

            //Test Step 24: Select expiration year
            Reusable_Methods.dropdownByText(driver,"//select[@name='expYear']", expYear, "Expiration Year");
            Thread.sleep(1500);

            //Test Step 25: Enter cvv code
            Reusable_Methods.sendKeysMethod(driver,"//input[@name='cvv']", cvvCode, "CVV Code");

            //Test Step 26: Click on place order
            Reusable_Methods.clickOnElement(driver,"//span[text()='Place Order']", "Place Order");

            //Test Step 27: Capture the error message and write it back to excel
            String errorMessage = Reusable_Methods.captureText(driver,"//div[@class='_13uVj jwBXt']",0, "Error Message");
            Label error = new jxl.write.Label(14,i,errorMessage);
            writableSheet.addCell(error);

        }//End of for loop

        //Outside of the cell write back to writable workbook
        writableWorkbook.write();
        //Close it writable workbook
        writableWorkbook.close();

    }//End of main
}//End of java class