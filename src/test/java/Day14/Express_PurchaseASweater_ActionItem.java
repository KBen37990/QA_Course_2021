package Day14;

import Express_PageObjects.Express_Base_Class;
import ReusableLibrary.Abstract_Class;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class Express_PurchaseASweater_ActionItem extends Abstract_Class {


    @Test
    public void Express_Purchase_A_Sweater() throws InterruptedException, BiffException, IOException, WriteException {

        Workbook readableBook = Workbook.getWorkbook(new File("src/main/resources/Express_DataDriven.xls"));
        WritableWorkbook writableWorkbook = Workbook.createWorkbook(new File("src/main/resources/Express_DataDriven_Results.xls"),readableBook);
        WritableSheet writableSheet = writableWorkbook.getSheet(0);

        int rowCount = writableSheet.getRows();


        driver.navigate().to("https://www.express.com");
        Thread.sleep(1000);


        Express_Base_Class.Express_Home().ClosePopUpAd();
        Thread.sleep(1000);


        for(int i = 1; i < rowCount; i++) {
            String size = writableSheet.getCell(0, i).getContents();
            String quantity = writableSheet.getCell(1, i).getContents();
            String firstName = writableSheet.getCell(2, i).getContents();
            String lastName = writableSheet.getCell(3, i).getContents();
            String email = writableSheet.getCell(4, i).getContents();
            String phone = writableSheet.getCell(5, i).getContents();
            String streetAddress = writableSheet.getCell(6, i).getContents();
            String zipcode = writableSheet.getCell(7, i).getContents();
            String city = writableSheet.getCell(8, i).getContents();
            String state = writableSheet.getCell(9, i).getContents();
            String ccNumber = writableSheet.getCell(10, i).getContents();
            String expMonth = writableSheet.getCell(11, i).getContents();
            String expYear = writableSheet.getCell(12, i).getContents();
            String cvvCode = writableSheet.getCell(13, i).getContents();


            driver.manage().deleteAllCookies();
            driver.navigate().to("https://www.express.com");
            Thread.sleep(1000);


            Express_Base_Class.Express_SweatersAndHoodies().HoverOverMenTab();
            Thread.sleep(1000);
            Express_Base_Class.Express_SweatersAndHoodies().ClickOnSweatshirtsAndHoodies();
            Thread.sleep(1000);


            Express_Base_Class.Express_AddFirstSweaterToBag().ClickOnFirstSweater();
            Thread.sleep(1000);
            Express_Base_Class.Express_AddFirstSweaterToBag().SelectSize(size);
            Thread.sleep(1000);
            Express_Base_Class.Express_AddFirstSweaterToBag().AddItemToBag();
            Thread.sleep(1000);
            Express_Base_Class.Express_AddFirstSweaterToBag().ViewBag();
            Thread.sleep(2000);


            Express_Base_Class.Express_QuantityAndCheckout().ChangeQuantity(quantity);
            Thread.sleep(2000);
            Express_Base_Class.Express_QuantityAndCheckout().ClickOnCheckout();
            Thread.sleep(2000);
            Express_Base_Class.Express_QuantityAndCheckout().CheckoutAsGuest();


            Express_Base_Class.Express_UserInputData().EnterFirstName(firstName);
            Express_Base_Class.Express_UserInputData().EnterLastName(lastName);
            Express_Base_Class.Express_UserInputData().EnterEmail(email);
            Express_Base_Class.Express_UserInputData().ReEnterEmail(email);
            Express_Base_Class.Express_UserInputData().EnterPhoneNumber(phone);
            Express_Base_Class.Express_UserInputData().ClickOnContinueForContactInformation();
            Thread.sleep(2000);
            Express_Base_Class.Express_UserInputData().EnterStreetAddress(streetAddress);
            Express_Base_Class.Express_UserInputData().EnterAValidZipcode(zipcode);
            Express_Base_Class.Express_UserInputData().EnterACity(city);
            Express_Base_Class.Express_UserInputData().SelectAState(state);
            Express_Base_Class.Express_UserInputData().ClickOnContinueForShippingAddress();
            Thread.sleep(1500);
            Express_Base_Class.Express_UserInputData().ClickOnContinueForDeliveryOptions();
            Thread.sleep(1500);
            Express_Base_Class.Express_UserInputData().EnterCreditCardNumber(ccNumber);
            Express_Base_Class.Express_UserInputData().SelectExpirationMonth(expMonth);
            Express_Base_Class.Express_UserInputData().SelectExpirationYear(expYear);
            Express_Base_Class.Express_UserInputData().EnterCVVCode(cvvCode);
            Express_Base_Class.Express_UserInputData().ClickOnPlaceOrder();
            Thread.sleep(1500);

            //String Express_ErrorReportMessage_Page in order to write it to excel sheet
            String errorMessage = Express_Base_Class.Express_ErrorReportMessage().CaptureErrorMessage();
            Label error = new jxl.write.Label(14,i, errorMessage);
            writableSheet.addCell(error);

        }//End of for loop

        writableWorkbook.write();
        writableWorkbook.close();

    }//End of test
}//End of java class
