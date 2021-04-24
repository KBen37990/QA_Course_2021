package Express_PageObjects;

import ReusableLibrary.Abstract_Class;
import ReusableLibrary.Reusable_Actions_PageObjects;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Express_QuantityAndCheckout_Page extends Abstract_Class {

    ExtentTest logger;
    public Express_QuantityAndCheckout_Page(WebDriver driver){
        //Page factory command
        PageFactory.initElements(driver,this);
        this.logger = Abstract_Class.logger;
    }//End of constructor class

    @FindBy(xpath = "//*[@id='qdd-0-quantity']")
    WebElement ChangeQuantity;

    @FindBy(xpath = "//button[text()='Checkout']")
    WebElement ClickOnCheckout;

    @FindBy(xpath = "//button[text()='Checkout as Guest']")
    WebElement CheckoutAsGuest;


    //Method for changing quantity
    public void ChangeQuantity(String userValue){
        Reusable_Actions_PageObjects.dropdownByText(driver, ChangeQuantity, userValue , logger, "Change Quantity");
    }//End of change quantity method

    //Method to click on checkout
    public void ClickOnCheckout(){
        Reusable_Actions_PageObjects.clickOnElement(driver, ClickOnCheckout, logger, "Click on checkout");
    }//End of click on checkout method

    //Method to click on checkout as guest
    public void CheckoutAsGuest(){
        Reusable_Actions_PageObjects.clickOnElement(driver, CheckoutAsGuest, logger, "Click on checkout as guest");
    }//End of checkout as guest method

}//End of java class
