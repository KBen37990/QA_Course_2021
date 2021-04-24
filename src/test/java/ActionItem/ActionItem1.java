package ActionItem;

public class ActionItem1 {
    public static void main(String[] args) {
        //declare variables

        String[] zipCodes;
        int[] StreetNumber;

        //set the length of array for string zipCodes
        zipCodes = new String[4];
        zipCodes[0] = "11372";
        zipCodes[1] = "11103";
        zipCodes[2] = "11377";
        zipCodes[3] = "11101";

        //set the length of array for int StreetNumber
        StreetNumber = new int[4];
        StreetNumber[0] = 77;
        StreetNumber[1] = 74;
        StreetNumber[2] = 83;
        StreetNumber[3] = 96;

        for (int i = 0; i < zipCodes.length; i++) {
            System.out.println("My zipcode is " + zipCodes[i] + " and my street number is " + StreetNumber[i] + ".");

        }//end of for loop
    }//end of main
}//end of java class
