package ActionItem;

public class ActionItem2_1_BleronKurtisi {
    public static void main(String[] args) {

        //declare the integer variables
        int grade = 86;
        String myGrade = null;

        if (grade >= 90 && grade <= 100) {
            myGrade = "A";
        } else if (grade >= 80 && grade < 90) {
            myGrade = "B";
        } else if (grade >= 70 && grade < 80) {
            myGrade = "C";
        } else if (grade >= 60 && grade < 70) {
            myGrade = "D";
        } else if (grade < 60) {
            myGrade = "F";
        }

        System.out.println("Grade is " + myGrade);


    }//end of main
}//end of java class
