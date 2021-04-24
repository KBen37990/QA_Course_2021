package Express_PageObjects;

import ReusableLibrary.Abstract_Class;
import ReusableLibrary.Reusable_Actions;
import ReusableLibrary.Reusable_Actions_PageObjects;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Express_Home_Page extends Abstract_Class {

    ExtentTest logger;
    public Express_Home_Page(WebDriver driver){
        //Page factory command
        PageFactory.initElements(driver,this);
        this.logger = Abstract_Class.logger;
    }//End of constructor class

    @FindBy(xpath = "//*[@id='closeModal']")
    WebElement ClosePopUpAd;


    //Create a method for closing the pop up ad
    public void ClosePopUpAd(){
        Reusable_Actions_PageObjects.clickOnElement(driver, ClosePopUpAd, logger, "Close pop up ad");
    }//End of method for closing the pop up ad

}//End of java class
