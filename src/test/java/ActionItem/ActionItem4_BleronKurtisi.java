package ActionItem;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import java.io.IOException;
import java.util.ArrayList;

public class ActionItem4_BleronKurtisi {
    public static void main(String[] args) throws IOException, InterruptedException {

        //Terminate instance of chrome driver
        Runtime.getRuntime().exec("taskkill /F /IM chromedriver.exe /T");
        //1.5 Second wait time before launching
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



        //Find location by zip codes
        ArrayList<String> findLocationByZip = new ArrayList<String>();
        findLocationByZip.add("11372");
        findLocationByZip.add("11373");
        findLocationByZip.add("11375");

        //location type
        ArrayList<String> locationType = new ArrayList<String>();
        locationType.add("Collection Boxes");
        locationType.add("Self-Service Kiosks");
        locationType.add("Post Office");

        /*//What is the location type
        ArrayList<String> locationType = new ArrayList<String>();
        locationType.add("Post Office");
        locationType.add("Self-Service Kiosks");
        locationType.add("Contract Postal Unit");

         */

        //Location within amount of miles
        ArrayList<String> locationMile = new ArrayList<String>();
        locationMile.add("10 Miles");
        locationMile.add("20 Miles");
        locationMile.add("50 Miles");


        for (int i = 0; i < locationMile.size(); i++) {


            //Test Step 1: navigate to usps.com
            try {
                driver.navigate().to("https://usps.com");
            } catch (Exception e) {
                System.out.println("Unable to navigate to usps.com. " + e);
            }//End of Test Step 1

            //Test Step 2: Verify the title equal "Welcome | USPS"
            String actualTitle = driver.getTitle();
            try {
                if (actualTitle.equals("Welcome | USPS")) {
                    System.out.println("Title matches");
                } else {
                    System.out.println("Title doesn't match. " + actualTitle);
                }//end of condition
            } catch (Exception e) {
                System.out.println("Unable to verify the title equal 'Welcome | USPS'. " + e);
            }//End of Test Step 2


            //Test Step 3: Hover over "Send" tab using mouse actions
            Actions mouseAction = new Actions(driver);
            try {
                WebElement Send = driver.findElement(By.xpath("//*[text()='Send']"));
                mouseAction.moveToElement(Send).perform();
                Thread.sleep(2000);
            } catch (Exception e) {
                System.out.println("Unable to hover over 'Send' tab using mouse actions. " + e);
            }//End of Test Step 3


            //Test Step 4: Click on "Find USPS Locations"
            try {
                WebElement findLocations = driver.findElement(By.xpath("//*[@class='tool-find']"));
                mouseAction.moveToElement(findLocations).click().perform();
            } catch (Exception e) {
                System.out.println("Unable to click on 'Find USPS Locations'. " + e);
            }//End of Test Step 4


            //Test Step 5: Enter the desired zipcode form array list
            try{
                WebElement zipCode = driver.findElement(By.xpath("//*[@id='city-state-input']"));
                zipCode.click();
                zipCode.sendKeys(findLocationByZip.get(i));
                Thread.sleep(2000);
            } catch (Exception e){
                System.out.println("Unable to enter the desired zipcode form array list. " + e);
            }//End of Test Step 5


            //Test Step 6: Choose a location type from dropdown menu based on array list values
            try {
                WebElement LocationTypeDropdown = driver.findElement(By.xpath("//*[@id='post-offices-select']"));
                LocationTypeDropdown.click();
                WebElement LocationTypesDropdown = driver.findElement(By.xpath("//a[text()='" + locationType.get(i) + "']"));
                mouseAction.moveToElement(LocationTypesDropdown).click().perform();
                Thread.sleep(2000);
            } catch (Exception e) {
                System.out.println("Unable to choose a location type from dropdown menu based on array list values. " + e);
            }//End of Test Step 6

            //Test Step 7: Choose a desired mile from the dropdown menu
            try {
                WebElement withinMiles = driver.findElement(By.xpath("//*[@id='within-select']"));
                withinMiles.click();
                WebElement MilesTypes = driver.findElement(By.xpath("//a[text()='" + locationMile.get(i) + "']"));
                mouseAction.moveToElement(MilesTypes).click().perform();
                Thread.sleep(2000);
            } catch (Exception e) {
                System.out.println("Unable to choose a desired mile from the dropdown menu. " + e);
            }//End of Test Step 7

            //Test Step 8: Click on search button
            try {
                WebElement Search = driver.findElement(By.xpath("//*[@id='searchLocations']"));
                Search.click();
            } catch (Exception e) {
                System.out.println("Unable to click on search button. "+ e);
            }//End of Test Step 8

            //Test Step 9: Thee Iterations
            Thread.sleep(2000);
            try {
                ArrayList<WebElement> links = new ArrayList<>(driver.findElements(By.xpath("//div[@role='button']")));
                if (i == 0) {
                    links.get(0).click();
                } else if (i == 1) {
                    links.get(1).click();
                } else if (i == 2) {
                    links.get(2).click();
                }
            } catch (Exception e) {
                System.out.println("Error with running the three iterations. " + e);
            }//End of Test Step 9

            //Test Step 10: Print address
            try {
                Thread.sleep(2000);
                String address = driver.findElement(By.xpath("//*[@class=' address-wrapper']")).getText();
                System.out.println(address);
            } catch (Exception e) {
                System.out.println("Error with printing address. " + e);
            }

            //Test Step 11: Print hours and dates
            try {
                Thread.sleep(2000);
                String hour = driver.findElement(By.xpath("//*[text()='Hours']")).getText();
                System.out.println(hour);
                Thread.sleep(2000);
                String time = driver.findElement(By.xpath("//*[@class='hours-flex-section']")).getText();
                System.out.println(time);
            }catch (Exception e) {
                System.out.println("Error with printing hours and dates. " + e);
            }//End of Test Step 11

        }//End of for loop
    }//End of main
}//End of java class
