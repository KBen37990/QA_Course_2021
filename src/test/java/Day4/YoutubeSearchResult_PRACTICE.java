package Day4;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class YoutubeSearchResult_PRACTICE {
    public static void main(String[] args) {

        //set the System property of where the driver is located so you can use it
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");

        //define the WebDriver with a variable to use
        WebDriver driver = new ChromeDriver();

        // navigate/get to Google homepage
        driver.navigate().to("https://www.youtube.com/");




    }//end of main
}//end of java class
