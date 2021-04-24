package Day3;

public class multiplecondition {
    public static void main(String[] args) {

        //using multiple conditional statements
        int a, b, c;
        a = 2;
        b = 3;
        c = 4;

        //verify either a+b>c, a+b<c, a+b=c
        if (a + b > c) {
            System.out.println("a & b is greater than c");
        } else if (a + b < c) {
            System.out.println("a & b is less than c");
        } else {
            System.out.println("a & b is equal to c");
        }//end of multiple condition


        //if something is not greater than or equal to then you just need to type in else.
        //based on requirement you can determine if you need to write another else if or just else.


    }//end of main method
}//end of java class
