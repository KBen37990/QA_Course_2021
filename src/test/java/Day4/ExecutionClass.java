package Day4;

public class ExecutionClass {
    public static void main(String[] args) {

        ReusableMethods.addTwoNumbers(20,30);
        ReusableMethods.addTwoNumbers(90,29);
        ReusableMethods.addTwoNumbers(1983,49842);
        ReusableMethods.addTwoNumbers(10,39);

        int c = ReusableMethods.subtractTwoNumbers(20,10);
            System.out.println("New result " + (c+5));


        ReusableMethods.subtractTwoNumbers(91,38);

    }//end of main
}//end of class
