package Day7;

import java.util.ArrayList;

public class ArrayListExample {
    public static void main(String[] args) {

        ArrayList<String> cities = new ArrayList<>();
        cities.add("Brooklyn");
        cities.add("Queens");
        cities.add("Manhattan");
        cities.add("Staten Island");
        cities.add("Bronx");

        for (String city : cities) {
            System.out.println("My city is " + city);
        }



    }//end of main
}//end of java class
