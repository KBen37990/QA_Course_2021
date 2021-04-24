package Day8;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.IOException;

public class YahooWithScrolling {
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

        //naviagte to yahoo.
        driver.navigate().to("https://wwww.yahoo.com");
        Thread.sleep(2500);

        //enter a keyword on the search field
        driver.findElement(By.xpath("//*[@name='p']")).sendKeys("Cars");
        //click on search icon
        driver.findElement(By.xpath("//*[@id='ybar-search']")).click();
        Thread.sleep(2500);

        //scroll to the bottom of the page to capture the search result
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        //scroll to the bottom by pixels
        jse.executeScript("scroll(0,5000)");


        //capture text
        String result = driver.findElement(By.xpath("//*[@class='compPagination']")).getText();
        //split by keyword Next to capture the actual result
        String[] arrayResult = result.split("Next");
        //split by the keyword results to get the actual number
        String[] arrayNumber = arrayResult[1].split("results");
        System.out.println("My search number is " + arrayNumber[0]);

        //go all the way to to the top and click on sign in

        jse.executeScript("scroll(0,-5000)");
        //click on sign in
        driver.findElement(By.xpath("//*[@id='ysignin']")).click();


    }//end of main
}//end of java class
