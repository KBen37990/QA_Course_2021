package Google_PageObjects;

import ReusableLibrary.Abstract_Class;

public class Base_Class extends Abstract_Class {

    //This page class is a static reference for the page object classes so i can use it on my test class
    public static Home_Page google_home(){
        Home_Page google_home = new Home_Page(driver);
        return google_home;
    }// End of googleHomePage Method

    public static Search_Result_Page search_result(){
        Search_Result_Page search_result = new Search_Result_Page(driver);
        return search_result;
    }// End of googleHomePage Method




}
