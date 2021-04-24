package Day12;

import Reusable_Methods.Reusable_Methods;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;

public class TestNG_Assertions {

    @Test
    public void assertions() throws IOException, InterruptedException {

        WebDriver driver = Reusable_Methods.defineTheDriver();

        driver.navigate().to("https://www.google.com");

        //Using hard assert verify the google title
        //Assert.assertEquals("Google",driver.getTitle());

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals("google",driver.getTitle());

        //Enter something on the search bar
        Reusable_Methods.sendKeysMethod(driver,"//*[@name='q']","Cars","Search field");

        driver.close();

        //assertAll should be the last step on your test
        softAssert.assertAll();

    }//End of test all



}//End of java class
