package Day8;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.IOException;
import java.time.chrono.JapaneseChronology;

public class MortgageCalc_ScrollByElement {
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

        //navigate to mortgage site
        driver.navigate().to("https://mortgagecalculator.org");
        Thread.sleep(3000);

        JavascriptExecutor jse = (JavascriptExecutor)driver;
        //store the locator as a element that I want to scroll by for a view
        WebElement viewLoan = driver.findElement(By.xpath("//*[text()='View Loan Breakdown']"));
        jse.executeScript("arguments[0].scrollIntoView(true);",viewLoan);





    }//end of main
}//end of java class
