package Day14;

import Google_PageObjects.Base_Class;
import ReusableLibrary.Abstract_Class;
import org.testng.annotations.Test;

public class Google_Search_PageObject  extends Abstract_Class {

    @Test
    public void googleSearch() throws InterruptedException {
        driver.navigate().to("https://www.google.com");
        Thread.sleep(2000);
        Base_Class.google_home().EnterKeywordOnGoogleSearch("Cars");
        Base_Class.google_home().SubmitOnGoogleSearchButton();
        Thread.sleep(2000);
        Base_Class.search_result().CaptureSearchResultNumber();
    }//End of test
}//End of java class
