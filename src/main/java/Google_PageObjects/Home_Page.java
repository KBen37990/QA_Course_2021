package Google_PageObjects;

import ReusableLibrary.Abstract_Class;
import ReusableLibrary.Reusable_Actions_PageObjects;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class Home_Page extends Abstract_Class {

    //Create a constructor method which will define the WebDriver
    //Constructor is a method which uses the same name as java class to store information that you want to use locally to this class especially dealing with page object

    //Declare a local logger so you can use it in your page class
    ExtentTest logger;
    public Home_Page(WebDriver driver){
        //Page factory command
        PageFactory.initElements(driver,this);
        this.logger = Abstract_Class.logger;
    }//End of constructor class

    //Define all the WebElement you need using @FindBy concept
    @FindBy(xpath = "//*[@name='q']")
    WebElement googleSearchField;
    //Below fine by is useful when you need to click on an element which doesn't have unique property so you create WebElement as a list
    //then later you pass .get(index number) on your reusable actions
    @FindBy(xpath = "//*[@name='btnK']")
    WebElement googleSearchButton;
    List<WebElement> list;


    //Create a method for google search
    public void EnterKeywordOnGoogleSearch(String userValue){
        Reusable_Actions_PageObjects.sendKeysMethod(driver, googleSearchField, userValue, logger, "Google Search Field");
    }//End of google search

    //Create a method for google search button
    public void SubmitOnGoogleSearchButton(){
        Reusable_Actions_PageObjects.submitOnElement(driver, googleSearchButton, logger, "Google Search Button");
    }//End of google search button


}//End of java class
