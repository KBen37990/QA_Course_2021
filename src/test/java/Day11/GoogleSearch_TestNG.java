package Day11;

import Reusable_Methods.Reusable_Methods;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.io.IOException;

public class GoogleSearch_TestNG {
    /** capture search result for google **/

    //Declare the global variable outside of annotation methods to every annotation can use it rather than it being local in each annotation.
    WebDriver driver = null;

    //use before suite when you have multiple @test methods
    @BeforeSuite
    public void setupDriver() throws IOException, InterruptedException {
        driver = Reusable_Methods.defineTheDriver();
    }//End of driver set up


    //Navigate to google, enter a keyword and hit submit
    @Test (priority = 1)
    public void googleSearch() throws InterruptedException {
        driver.navigate().to("https://www.google.com");
        Thread.sleep(3000);
        Reusable_Methods.sendKeysMethod(driver, "//*[@name='q']", "Cars", "Google Search");
        //submit on google search button
        Reusable_Methods.submitOnElement(driver, "//*[@name='btnK']", "Google Search Button");
        Thread.sleep(3000);
    } //End of google search


    //Capture the search number from search result page
    @Test (priority = 2)
    public void captureSearchResult(){
        String result = Reusable_Methods.captureText(driver, "//*[@id='result-stats']", 0 , "Google Search Result");
        String [] arrayResult = result.split(" ");
        System.out.println("Search number is " + arrayResult[1]);
    } //End of google search


    //Quit the driver
    @AfterSuite
    public void closeBrowser(){
        driver.quit();
    }//End of close browser


}//End of java class
