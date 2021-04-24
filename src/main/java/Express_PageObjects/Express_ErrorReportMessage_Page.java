package Express_PageObjects;

import ReusableLibrary.Abstract_Class;
import ReusableLibrary.Reusable_Actions_PageObjects;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Express_ErrorReportMessage_Page extends Abstract_Class {

    ExtentTest logger;
    public Express_ErrorReportMessage_Page(WebDriver driver){
        //Page factory command
        PageFactory.initElements(driver,this);
        this.logger = Abstract_Class.logger;
    }//End of constructor class

    @FindBy(xpath = "//div[@class='_13uVj jwBXt']")
    WebElement CaptureErrorMessage;

    //Method for capturing the error message
    public String CaptureErrorMessage(){
        String result = Reusable_Actions_PageObjects.captureText(driver, CaptureErrorMessage, 0, logger, "Capture the error message");
        logger.log(LogStatus.INFO, "Error message: " + result);
        return result;
    }//End of capture error message method

}//End of java class
