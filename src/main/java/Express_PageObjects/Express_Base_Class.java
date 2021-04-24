package Express_PageObjects;

import ReusableLibrary.Abstract_Class;

public class Express_Base_Class extends Abstract_Class {

    public static Express_Home_Page Express_Home(){
        Express_Home_Page Express_Home = new Express_Home_Page(driver);
        return Express_Home;
    }// End of Express_Home method

    public static Express_SweatersAndHoodies_Page Express_SweatersAndHoodies(){
        Express_SweatersAndHoodies_Page Express_SweatersAndHoodies = new Express_SweatersAndHoodies_Page(driver);
        return Express_SweatersAndHoodies;
    }// End of Express_SweatersAndHoodies method

    public static Express_AddFirstSweaterToBag_Page Express_AddFirstSweaterToBag(){
        Express_AddFirstSweaterToBag_Page Express_AddFirstSweaterToBag = new Express_AddFirstSweaterToBag_Page(driver);
        return Express_AddFirstSweaterToBag;
    }//End of AddFirstSweaterToBag method

    public static Express_QuantityAndCheckout_Page Express_QuantityAndCheckout(){
        Express_QuantityAndCheckout_Page Express_QuantityAndCheckout = new Express_QuantityAndCheckout_Page(driver);
        return Express_QuantityAndCheckout;
    }//End of QuantityAndCheckout method

    public static Express_UserInputData_Page Express_UserInputData(){
        Express_UserInputData_Page Express_UserInputData = new Express_UserInputData_Page(driver);
        return Express_UserInputData;
    }//End of UserInputData method

    public static Express_ErrorReportMessage_Page Express_ErrorReportMessage(){
        Express_ErrorReportMessage_Page Express_ErrorReportMessage = new Express_ErrorReportMessage_Page(driver);
        return Express_ErrorReportMessage;
    }//End of Error Report Message method

}//End of java class
