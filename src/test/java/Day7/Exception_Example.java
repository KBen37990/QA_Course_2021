package Day7;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import javax.swing.*;
import java.io.IOException;

public class Exception_Example {
    public static void main(String[] args) throws InterruptedException, IOException {

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

        //navigate to bing home
        try {
            driver.navigate().to("https://www.bing.com");
        } catch (Exception e) {
            System.out.println("Unable to navigate to bing. " + e);
        }//end of navigate exception

        Thread.sleep(2500);

        //enter a keyword on search field
        try{
            driver.findElement(By.xpath("//*[@name='q']")).sendKeys("Cars");
        } catch (Exception e) {
            System.out.println("Unable to enter keyword on search field" + e);
        }//end of search exception

        //click on search icon
        try{
            driver.findElement(By.xpath("//*[@for='sb_form_go']")).click();
        } catch (Exception e) {
            System.out.println("Unable to click on search icon. " + e);
        }//end of search icon exception

    }
}
