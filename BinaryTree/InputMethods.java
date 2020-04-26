import java.util.InputMismatchException;
import java.util.Scanner;

public class InputMethods {

    static Scanner scan = new Scanner(System.in);

    public static String inputName() {
        String name = "";
        while (name.isEmpty()) {
            System.out.print("Please Enter Full Name: ");
            name = scan.nextLine();
        }
        return name;
    }

    public static int inputID() {
        int id = 0;
        while (id <= 0 || id > 9999) {
            try {
                System.out.print("Please Enter ID: ");
                id = scan.nextInt();
                scan.nextLine();
            } catch (InputMismatchException e) {
                scan.nextLine();
            }
        }
        return id;
    }

    public static String inputMajor() {
        String major = "";
        while (major.isEmpty()) {
            System.out.print("Please Enter Major: ");
            major = scan.nextLine();
        }
        return major;
    }

    public static double inputGradePerecentage() {
        double percentage = -1;
        while (percentage < 0 || percentage > 100) {
            try {
                System.out.print("Please Enter Grade Points(0 - 100): ");
                percentage = scan.nextDouble();
                scan.nextLine();
            } catch (InputMismatchException e) {
                scan.nextLine();
            }
        }

        return percentage;
    }

    public static char inputGradeLetter(double grade) {
        char gradeLetter = ' ';
        if (grade < 50) {
            gradeLetter = 'F';
        } else if (grade >= 50 && grade < 70) {
            gradeLetter = 'D';
        } else if (grade >= 70 && grade < 80) {
            gradeLetter = 'C';
        } else if (grade >= 80 && grade < 90) {
            gradeLetter = 'B';
        } else {
            gradeLetter = 'A';
        }

        return gradeLetter;
    }

    public static String inputGradeStatus(char gradeLetter) {
        String gradeStatus = " ";
        if (gradeLetter > 'C') {
            gradeStatus = "Fail";
        } else {
            gradeStatus = "Pass";
        }

        return gradeStatus;
    }

    public static void closeScanner() {
        scan.close();
    }
}