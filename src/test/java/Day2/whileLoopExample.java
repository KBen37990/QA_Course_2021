package Day2;

import java.awt.*;

public class whileLoopExample {

    public static void main(String[] args) {
        String[] cities, houseAddress;

        cities = new String[5];
        cities[0] = "Brooklyn";
        cities[1] = "Queens";
        cities[2] = "Manhattan";
        cities[3] = "Bronx";
        cities[4] = "Staten Island";

        houseAddress = new String[5];
        houseAddress[0] = "222";
        houseAddress[1] = "345";
        houseAddress[2] = "633";
        houseAddress[3] = "535";
        houseAddress[4] = "895";


        //set your initializer i
        int i = 0;

        //set the gate keeper/end point for while
        while (i < cities.length) {

            System.out.println("My city is " + cities[i] + ". My house address is "+ houseAddress[i]);

            //set the count
            i = i + 1;
        }


    }//end of main
}//end of java class
