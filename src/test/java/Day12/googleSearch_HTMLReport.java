package Day12;

import ReusableLibrary.Abstract_Class;
import ReusableLibrary.Reusable_Actions;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.annotations.Test;

public class googleSearch_HTMLReport extends Abstract_Class {


    @Test
    public void SearchForACar() throws InterruptedException {
        driver.navigate().to("https://www.google.com");
        Thread.sleep(2500);
        //Search for a car
        Reusable_Actions.sendKeysMethod(driver, "//*[@name='q']","Car",logger,"Search Field");
        //Submit on google search button
        Reusable_Actions.submitOnElement(driver,"//*[@name='btnK']",logger,"Google Search");
        Thread.sleep(3000);
    }//End of Test 1

    @Test(dependsOnMethods = "SearchForACar")
    public void getSearchNumber(){
        String result = Reusable_Actions.captureText(driver,"//*[@id='result-stat']", 0, logger, "Google Search Result");
        String [] arrayResult = result.split(" ");
        logger.log(LogStatus.INFO, "My search number is " + arrayResult[1]);
    }



}//End of java class
