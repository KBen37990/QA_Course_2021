package Express_PageObjects;

import ReusableLibrary.Abstract_Class;
import ReusableLibrary.Reusable_Actions_PageObjects;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Express_AddFirstSweaterToBag_Page extends Abstract_Class {

    ExtentTest logger;
    public Express_AddFirstSweaterToBag_Page(WebDriver driver){
        //Page factory command
        PageFactory.initElements(driver,this);
        this.logger = Abstract_Class.logger;
    }//End of constructor class

    @FindBy(xpath = "//*[@class='_2EWqA']")
    WebElement ClickOnFirstSweater;

    @FindBy(xpath = "//button[text()='Add to Bag']")
    WebElement AddItemToBag;

    @FindBy(xpath = "//*[text()='View Bag']")
    WebElement ViewBag;


    //Method for clicking on the first sweater
    public void ClickOnFirstSweater(){
        Reusable_Actions_PageObjects.clickOnElement(driver, ClickOnFirstSweater, logger, "Click on first sweater");
    }//End of method for hovering over mens tab


    //Method for selecting size
    public void SelectSize(String size){
        WebDriverWait wait = new WebDriverWait (driver, 8);
        try{
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@value='" + size + "']"))).click();
            logger.log(LogStatus.PASS, "Successfully clicked on size " + size);
        } catch (Exception e) {
            logger.log(LogStatus.FAIL, "Unable to click on size " + size + e);
            Reusable_Actions_PageObjects.getScreenShot(driver, "Size", logger);
        }
    }//End of select size method


    //Method for adding sweater to bag
    public void AddItemToBag(){
        Reusable_Actions_PageObjects.clickOnElement(driver, AddItemToBag, logger, "Click on add to bag");
    }//End of method for hovering over mens tab

    //Method for clicking on View Bag
    public void ViewBag(){
        Reusable_Actions_PageObjects.clickOnElement(driver, ViewBag, logger, "Click on view bag");
    }//End of method for clicking on view bag

}//End of java class
