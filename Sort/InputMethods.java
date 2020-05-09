import java.util.InputMismatchException;
import java.util.Scanner;

public class InputMethods {

    public static Scanner getScan() {
        Scanner inputScan = new Scanner(System.in);
        return inputScan;
    }

    public static int getInt() {
        int newInt = 0;
        try {
            newInt = getScan().nextInt();
        } catch (InputMismatchException e) {
        }
        return newInt;
    }

    public static String getString() {
        String newString = "";
        while (newString.isEmpty()) {
            newString = getScan().nextLine();
        }
        return newString;
    }

    public static double getDouble() {
        double newDouble = 0;
        try {
            newDouble = getScan().nextDouble();
        } catch (InputMismatchException e) {
        }

        return newDouble;
    }

    public static void closeInputScanner() {
        getScan().close();
    }

}