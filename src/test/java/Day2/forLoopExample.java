package Day2;

public class forLoopExample {

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


        //set your iteration to loop through all the value from cities
        for (int i = 0; i < cities.length; i++) {
            //print out all value in one print statement
            System.out.println("My city is " + cities[i] + ". My house address is " + houseAddress[i]);
        }//end of for loop

    }//end of main

}//end of java class
