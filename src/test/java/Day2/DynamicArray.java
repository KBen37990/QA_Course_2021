package Day2;

public class DynamicArray {
    public static void main(String[] args) {

        //declare countries variable
        String[] countries;
        int[] streetNumber;
        //set the length of the array for number of data it can store
        countries = new String[4];
        countries[0] = "USA";
        countries[1] = "Spaint";
        countries[2] = "Bangladesh";
        countries[3] = "India";

        //set the length of the array for street number
        streetNumber = new int[4];
        streetNumber[0] = 19;
        streetNumber[1] = 93;
        streetNumber[2] = 46;
        streetNumber[3] = 84;

        //print usa from countries list and street number 46
        System.out.println("Country is " + countries[0] + ". My street number is " + streetNumber[2]);

    }//end of main
}//end of java class
