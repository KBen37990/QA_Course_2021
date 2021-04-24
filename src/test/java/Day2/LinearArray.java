package Day2;

public class LinearArray {

    public static void main(String[] args) {

        //declare the variables
        String[] cities, countries, locations;
        int[] streetNumber, HouseNumber;


        cities = new String[]{"Brooklyn", "Queens", "Manhattan", "Bronx", "Staten Island"};
        countries = new String[]{"USA"};
        locations = new String[]{"NA"};
        streetNumber = new int[]{83, 345, 567, 888, 1000};
        HouseNumber = new int[]{3354, 3755};

        //I want to print Queens and street number as 222;
        System.out.println("My location is " + locations[0] + ". My country is " + countries[0] + ". My city is " + cities[1] + ". My street number is " + streetNumber[0] + ". My house number is " + HouseNumber[0]);

    }//end of main method


}//end of java class
