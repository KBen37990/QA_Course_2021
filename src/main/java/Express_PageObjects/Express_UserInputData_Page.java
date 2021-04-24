package Express_PageObjects;

import ReusableLibrary.Abstract_Class;
import ReusableLibrary.Reusable_Actions_PageObjects;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Express_UserInputData_Page extends Abstract_Class {

    ExtentTest logger;
    public Express_UserInputData_Page(WebDriver driver){
        //Page factory command
        PageFactory.initElements(driver,this);
        this.logger = Abstract_Class.logger;
    }//End of constructor class



    @FindBy(xpath = "//input[@name='firstname']")
    WebElement EnterFirstName;

    @FindBy(xpath = "//input[@name='lastname']")
    WebElement EnterLastName;

    @FindBy(xpath = "//input[@name='email']")
    WebElement EnterEmail;

    @FindBy(xpath = "//input[@name='confirmEmail']")
    WebElement ReEnterEmail;

    @FindBy(xpath = "//input[@name='phone']")
    WebElement EnterPhoneNumber;

    @FindBy(xpath = "//span[text()='Continue']")
    WebElement ClickOnContinueForContactInformation;

    @FindBy(xpath = "//input[@name='shipping.line1']")
    WebElement EnterStreetAddress;

    @FindBy(xpath = "//input[@name='shipping.postalCode']")
    WebElement EnterAValidZipcode;

    @FindBy(xpath = "//input[@name='shipping.city']")
    WebElement EnterACity;

    @FindBy(xpath = "//select[@name='shipping.state']")  //dropdown
    WebElement SelectAState;

    @FindBy(xpath = "//span[text()='Continue']")
    WebElement ClickOnContinueForShippingAddress;

    @FindBy(xpath = "//span[text()='Continue']")
    WebElement ClickOnContinueForDeliveryOptions;

    @FindBy(xpath = "//input[@id='creditCardNumberInput']")
    WebElement EnterCreditCardNumber;

    @FindBy(xpath = "//select[@name='expMonth']") //dropdown
    WebElement SelectExpirationMonth;

    @FindBy(xpath = "//select[@name='expYear']") //dropdown
    WebElement SelectExpirationYear;

    @FindBy(xpath = "//input[@name='cvv']")
    WebElement EnterCVVCode;

    @FindBy(xpath = "//span[text()='Place Order']")
    WebElement ClickOnPlaceOrder;






    //Method for entering first name
    public void EnterFirstName(String userValue){
        Reusable_Actions_PageObjects.sendKeysMethod(driver,EnterFirstName,userValue, logger, "Enter the first name");
    }//End of entering first name method

    //Method for entering last name
    public void EnterLastName(String userValue){
        Reusable_Actions_PageObjects.sendKeysMethod(driver,EnterLastName,userValue, logger, "Enter the last name");
    }//End of entering last name method

    //Method for entering email
    public void EnterEmail(String userValue){
        Reusable_Actions_PageObjects.sendKeysMethod(driver,EnterEmail,userValue, logger, "Enter the email");
    }//End of entering email method

    //Method for re-entering email
    public void ReEnterEmail(String userValue){
        Reusable_Actions_PageObjects.sendKeysMethod(driver,ReEnterEmail,userValue, logger, "Enter the email");
    }//End of re-entering email method

    //Method for EnterPhoneNumber
    public void EnterPhoneNumber(String userValue){
        Reusable_Actions_PageObjects.sendKeysMethod(driver,EnterPhoneNumber,userValue, logger, "Enter the email");
    }//End of EnterPhoneNumber method

    //Method for ClickOnContinueForContactInformation
    public void ClickOnContinueForContactInformation(){
        Reusable_Actions_PageObjects.clickOnElement(driver, ClickOnContinueForContactInformation, logger, "Click on continue contact information");
    }//End of ClickOnContinueForContactInformation method

    //Method for EnterStreetAddress
    public void EnterStreetAddress(String userValue){
        Reusable_Actions_PageObjects.sendKeysMethod(driver,EnterStreetAddress,userValue, logger, "Enter the street address");
    }//End of EnterStreetAddress method

    //Method for EnterAValidZipcode
    public void EnterAValidZipcode(String userValue){
        Reusable_Actions_PageObjects.sendKeysMethod(driver,EnterAValidZipcode,userValue, logger, "Enter the zipcode");
    }//End of EnterAValidZipcode method

    //Method for EnterACity
    public void EnterACity(String userValue){
        Reusable_Actions_PageObjects.sendKeysMethod(driver,EnterACity,userValue, logger, "Enter the city");
    }//End of EnterACity method

    //Method for SelectAState
    public void SelectAState(String userValue){
        Reusable_Actions_PageObjects.dropdownByText(driver, SelectAState, userValue, logger, " Select a state");
    }//End of SelectAState method

    //Method for ClickOnContinueForShippingAddress
    public void ClickOnContinueForShippingAddress(){
        Reusable_Actions_PageObjects.clickOnElement(driver, ClickOnContinueForShippingAddress, logger, "ClickOnContinueForShippingAddress");
    }//End of ClickOnContinueForShippingAddress method

    //Method for ClickOnContinueForDeliveryOptions
    public void ClickOnContinueForDeliveryOptions(){
        Reusable_Actions_PageObjects.clickOnElement(driver, ClickOnContinueForDeliveryOptions, logger, "ClickOnContinueForDeliveryOptions");
    }//End of ClickOnContinueForDeliveryOptions method

    //Method for entering credit card number
    public void EnterCreditCardNumber(String userValue){
        Reusable_Actions_PageObjects.sendKeysMethod(driver, EnterCreditCardNumber, userValue, logger, "Enter credit card number");
    }//End of enter credit card number method

    //Method for selecting expiration month
    public void SelectExpirationMonth(String userValue){
        Reusable_Actions_PageObjects.dropdownByText(driver, SelectExpirationMonth, userValue, logger, "Select expiration month");
    }//End of select expiration month method

    //Method for selecting expiration month
    public void SelectExpirationYear(String userValue){
        Reusable_Actions_PageObjects.dropdownByText(driver, SelectExpirationYear, userValue, logger, "Select expiration year");
    }//End of select expiration year method

    //Method for entering CVV code
    public void EnterCVVCode(String userValue){
        Reusable_Actions_PageObjects.sendKeysMethod(driver, EnterCVVCode, userValue, logger, "Enter cvv code");
    }//End of enter cvv code method

    //Method for click on place order
    public void ClickOnPlaceOrder(){
        Reusable_Actions_PageObjects.clickOnElement(driver, ClickOnPlaceOrder, logger, "Click on place order");
    }//End of click on place order method

}//End of java class
