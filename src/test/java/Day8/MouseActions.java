package Day8;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import java.io.IOException;

public class MouseActions {
    public static void main(String[] args) throws IOException, InterruptedException {

        //put it right before setProperty
        Runtime.getRuntime().exec("taskkill /F /IM chromedriver.exe /T");
        //put like 1.5 seconds to wait
        Thread.sleep(1500);
        //set the driver path
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");
        //define the chromeoptions arguments
        ChromeOptions options = new ChromeOptions();
        //maximize my driver
        options.addArguments("start-maximized");
        //set the driver to incognito (private)
        options.addArguments("incognito");
        //define the WebDriver
        WebDriver driver = new ChromeDriver(options);

        //navigate to usps home page
        try {
            driver.navigate().to("https://www.usps.com");
        } catch (Exception e) {
            System.out.println("Unable to navigate to usps. " + e);
        }

        //define the mouse actions
        Actions actions = new Actions(driver);

        //hover to Quick tools tab
        try {
            //store your element as WebElement
            WebElement quickTools = driver.findElement(By.xpath("//*[text()='Quick Tools']"));
            //move your mouse actions to quick tools for dropdown to appear
            //you always end your mouse actions with .perform()
            actions.moveToElement(quickTools).perform();
        } catch (Exception e){
            System.out.println("Unable to hover to Quick tools. " + e);
        }//end of quick tools exception

        //click on track a package using mouse actions
        try {
            //store your element as WebElement
            WebElement trackPackage= driver.findElement(By.xpath("//*[text()='Track a Package']"));
            //move your mouse actions to quick tools for dropdown to appear
            //you always end your mouse actions with .perform()
            actions.moveToElement(trackPackage).click().perform();
        } catch (Exception e){
            System.out.println("Unable to click on track a package. " + e);
        }//end of track a package exception

        //Enter a tracking number using mouse actions
        try {
            //store your element as WebElement
            WebElement trackingField= driver.findElement(By.xpath("//*[@id='tracking-input']"));
            actions.moveToElement(trackingField).click().sendKeys("12345678").perform();
        } catch (Exception e){
            System.out.println("Unable to input value on tracking field . " + e);
        }//end of track a package exception



    }//end of main
}//end of java class
