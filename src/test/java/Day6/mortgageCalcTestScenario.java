package Day6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class mortgageCalcTestScenario {
    public static void main(String[] args) throws InterruptedException {

        //set the property of the chromedriver
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
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

        //navigate to mortage calc home page
        driver.navigate().to("https://www.mortgagecalculator.org");
        Thread.sleep(2000);


        //verify the the the title with your expected
        String actualTitle = driver.getTitle();
        if (actualTitle.equals("mortgage calculator")) {
            System.out.println("Title matches");
        } else {
            System.out.println("Title doesn't match. " + actualTitle);
        }//end of condition


        //We print this to prove the test works while headless
        //System.out.println("Entering home value");
        //Store home value first
        WebElement homeValue = driver.findElement(By.xpath("//*[@id='homeval']"));
        //clear the previous data
        homeValue.clear();
        //enter the new home value
        homeValue.sendKeys("498465");

        //We print this to prove the test works while headless
        //Store downpayment value first
        //System.out.println("Entering home downpayment");
        WebElement downPayment = driver.findElement(By.xpath("//*[@id='downpayment']"));
        //clear the previous data
        downPayment.clear();
        //enter the new home value
        downPayment.sendKeys("50000");


        //select april on month dropdown
        WebElement startMonth = driver.findElement(By.xpath("//*[@name='param[start_month]']"));
        //select the locator using Select command
        Select dropdown = new Select(startMonth);
        //using by visible text command select month april
        dropdown.selectByVisibleText("Apr");

        //if dropdown is not under select tag then you have to use click command twice
        //click on dropdown
        //startMonth.click();
        //clock on drop down value by text
        //driver.findElement(By.xpath("//*[text()='May']")).click();

        //click on Calculate button
        driver.findElement(By.xpath("//*[@value='Calculate']")).click();

        Thread.sleep(3000);

        //capture the monthly payment using findElements with first index
        String mntPayment = driver.findElements(By.xpath("//div[@class='left-cell']")).get(0).getText();
        System.out.println("My monthly payment is " + mntPayment);



    }//end of main
}//end of java class
