package Day4;

public class ReusableMethods {

    //create a reusable method which will add two numbers and print out the statement
    public static void addTwoNumbers(int number1, int number2) {
        System.out.println("My result is " + (number1 + number2));
    }//end of method

    //create a return method which will subtract two numbers and print as well
    //return the result
    public static int subtractTwoNumbers(int number1, int number2){
        int result = number1 - number2;
        System.out.println("My result is " + result);
        return result;

    }//end of method
}//end of class
