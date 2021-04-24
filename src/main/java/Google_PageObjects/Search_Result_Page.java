package Google_PageObjects;

import ReusableLibrary.Abstract_Class;
import ReusableLibrary.Reusable_Actions_PageObjects;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Search_Result_Page extends Abstract_Class {

    //Create a constructor method which will define the WebDriver
    //Constructor is a method which uses the same name as java class to store information that you want to use locally to this class especially dealing with page object

    //Declare a local logger so you can use it in your page class
    ExtentTest logger;
    public Search_Result_Page(WebDriver driver){
        //Page factory command
        PageFactory.initElements(driver,this);
        this.logger = Abstract_Class.logger;
    }//End of constructor class


    //Define all the WebElement you need using @FindBy concept
    @FindBy(xpath = "//*[@id='result-stats']")
    WebElement searchResult;


    //Create a method for google search result
    public void CaptureSearchResultNumber(){
        String result = Reusable_Actions_PageObjects.captureText(driver, searchResult, 0 , logger, "Google Search Field");
        String[] arrayResult = result.split(" ");
        logger.log(LogStatus.INFO, "Search number is " + arrayResult[1]);
    }//End of google search result







}
