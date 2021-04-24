package Day9;

import Reusable_Methods.Reusable_Methods;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.util.ArrayList;


public class test {
    public static void main(String[] args) throws IOException, InterruptedException {
        WebDriver driver = Reusable_Methods.defineTheDriver();

        //This is just practice to use arraylist within for loop with the reusablemethods
        ArrayList<String> searches = new ArrayList<String>();
        searches.add("Cars");
        searches.add("Engines");
        searches.add("Houses");
        searches.add("Roads");
        searches.add("Food");

        for (int i=0; i<5; i++) {
            //navigate to google
            driver.navigate().to("https://www.google.com");
            Thread.sleep(2300);
            //Enter Something on search field
            Reusable_Methods.sendKeysMethod(driver, "//*[@name='q']", searches.get(i) , "Search Field");
            //click on google search
            Reusable_Methods.submitOnElement(driver, "//*[@name='btnK']", "Google Search");
            Reusable_Methods.clickOnElement(driver, "//*[text()='Sign in']", "Sign in");
        }

        /*
        //navigate to google
        driver.navigate().to("https://www.google.com");
        Thread.sleep(2300);
        //Enter Something on search field
        Reusable_Methods.sendKeysMethod(driver, "//*[@name='q']", "Cars" , "Search Field");
        //click on google search. click button disappears so we use submit
        Reusable_Methods.submitOnElement(driver, "//*[@name='btnK']", "Google Search");
        //extra step to test it
        Reusable_Methods.clickOnElement(driver, "//*[text()='Sign in']", "Sign in");
        */



    }
}
