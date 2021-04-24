package ActionItem;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import java.io.IOException;
import java.util.Arrays;

public class ActionItem3_BleronKurtisi {
    public static void main(String[] args) throws IOException, InterruptedException {

        String[] purchasePrice = {"100000", "150000", "200000"};
        String[] downPayment = {"10", "15", "20"};
        String[] mortgageTerm = {"10", "15", "20"};
        String[] interestRate = {"5", "10", "15"};
        String[] pmi = {"5", "10", "15"};
        String[] startMonth = {"Jun", "Jul", "Aug"};
        String[] startYear = {"2018", "2019", "2020"};


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


        //navigate to mortage calc home page
        driver.navigate().to("https://www.mlcalc.com/");
        Thread.sleep(2000);

        String actualTitle = driver.getTitle();
        if (actualTitle.equals("Auto Loan Calculator")) {
            System.out.println("Title matches");
        } else {
            System.out.println("Title doesn't match. " + actualTitle);
        }//end of condition


        for(int i = 0; i < 3; i++){
            //Inspect site to find Id's and use WebElement to store the locator
            WebElement pPrice = driver.findElement(By.xpath("//*[@name='ma']"));
            WebElement dPayment = driver.findElement(By.xpath("//*[@name='dp']"));
            WebElement mTerm = driver.findElement(By.xpath("//*[@name='mt']"));
            WebElement iRate = driver.findElement(By.xpath("//*[@name='ir']"));
            WebElement PMI = driver.findElement(By.xpath("//*[@name='mi']"));
            WebElement startMonthDropDown = driver.findElement(By.xpath("//*[@id='fpdd']"));
            Select dropdown = new Select(startMonthDropDown);
            WebElement startYearDropdown = driver.findElement(By.xpath("//*[@id='fpdy']"));

            //Clear the input fields
            pPrice.clear();
            dPayment.clear();
            mTerm.clear();
            iRate.clear();
            PMI.clear();

            //Input value from list of arrays
            pPrice.sendKeys(purchasePrice[i]);
            dPayment.sendKeys(downPayment[i]);
            mTerm.sendKeys(mortgageTerm[i]);
            iRate.sendKeys(interestRate[i]);
            PMI.sendKeys(pmi[i]);
            dropdown.selectByVisibleText(startMonth[i]);
            startYearDropdown.click();
            driver.findElement(By.xpath("//*[text()='" + startYear[i] + "']")).click();

            //Inspect page to find the the calculate button and click on it
            driver.findElement(By.xpath("//*[@value='Calculate']")).click();
            Thread.sleep(3000);

            String monthlyPayment = driver.findElements(By.xpath("//*[@class='big']")).get(0).getText();

            //Print the result for each iteration
            System.out.println("My monthly payment is " + monthlyPayment);
        }




    }//end of main
}//end of java class
