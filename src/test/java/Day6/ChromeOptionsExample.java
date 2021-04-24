package Day6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeOptionsExample extends org.openqa.selenium.chrome.ChromeOptions {
    public static void main(String[] args) {

        //set the property of the chromedriver
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");
        //define the chromeoptions arguments
        ChromeOptions options = new ChromeOptions();
        //maximize my driver
        options.addArguments("start-maximized");
        //set the driver to incognito (private)
        options.addArguments("incognito");
        //set it to headless
        //options.addArguments("headless");
        
        //define the WebDriver
        WebDriver driver = new ChromeDriver(options);
        
        //navigate to yahoo page
        driver.navigate().to("https:/www.yahoo.com");





    }//end of main
}//end of java class
