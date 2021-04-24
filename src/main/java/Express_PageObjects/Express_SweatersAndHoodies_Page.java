package Express_PageObjects;

import ReusableLibrary.Abstract_Class;
import ReusableLibrary.Reusable_Actions_PageObjects;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Express_SweatersAndHoodies_Page extends Abstract_Class {

    ExtentTest logger;
    public Express_SweatersAndHoodies_Page(WebDriver driver){
        //Page factory command
        PageFactory.initElements(driver,this);
        this.logger = Abstract_Class.logger;
    }//End of constructor class


    @FindBy(xpath = "//a[text()='Men']")
    WebElement HoverOverMenTab;

    @FindBy(xpath = "//a[text()='Sweatshirts & Hoodies']")
    WebElement ClickOnSweatshirtsAndHoodies;


    //Create a method for hovering over mens tab
    public void HoverOverMenTab(){
        Reusable_Actions_PageObjects.mouseHover(driver, HoverOverMenTab, logger, "Hover over men's tab");
    }//End of method for hovering over mens tab

    //Create method for clicking on "Sweatshirts & Hoodies"
    public void ClickOnSweatshirtsAndHoodies(){
        Reusable_Actions_PageObjects.clickOnElement(driver, ClickOnSweatshirtsAndHoodies, logger, "Click on ClickOnSweatshirtsAndHoodies");
    }//End of clicking on "Sweatshirts & Hoodies" method

}//End of java class
