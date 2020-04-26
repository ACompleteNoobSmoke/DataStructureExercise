import java.util.InputMismatchException;
import java.util.Scanner;

public class TreeImplementation extends MyBinaryTree {

    static Scanner scan = new Scanner(System.in);

    public int MainMenu() {
        int choice = 0;
        while (choice <= 0 || choice > 5) {
            try {
                System.out.println("Main Menu");
                System.out.println("1. Add New Student");
                System.out.println("2. Search Student");
                System.out.println("3. Remove Student");
                System.out.println("4. View All Students");
                System.out.println("5. Exit");
                System.out.print("\nAction: ");
                choice = scan.nextInt();
            } catch (InputMismatchException e) {
                scan.nextLine();
            }
        }
        scan.nextLine();
        return choice;
    }

    public void createNewStudent() {
        System.out.println("Enter New Student");
        String name = InputMethods.inputName();
        String major = InputMethods.inputMajor();
        int id = InputMethods.inputID();
        double gradePercentage = InputMethods.inputGradePerecentage();
        char gradeLetter = InputMethods.inputGradeLetter(gradePercentage);
        String gradeStatus = InputMethods.inputGradeStatus(gradeLetter);
        Students newStudent = new Students(name, major, id, gradePercentage, gradeLetter, gradeStatus);
        addNode(newStudent);
    }

    public void searchStudent() {
        System.out.println("Search Student");
        int id = InputMethods.inputID();
        Node found = findNode(id);
        System.out.println("Student Information");
        System.out.println(found == null ? "Student Not Found" : found);
    }

    public void removeStudent() {
        System.out.println("Remove Student");
        int id = InputMethods.inputID();
        boolean studentRemoved = removeNode(id);
        System.out.println((studentRemoved) ? "Student Removed" : "Student Not Found");
    }

    public void viewAllStudents() {
        System.out.println("All Students");
        reverseOrderTreeTraversal(root);
        System.out.println("Total Students: " + getTreeSize());
    }

    public void options(int choice) {
        switch (choice) {
            case 1:
                createNewStudent();
                break;
            case 2:
                searchStudent();
                break;
            case 3:
                removeStudent();
                break;
            case 4:
                viewAllStudents();
                break;
            case 5:
                System.out.println("Closing...\n");
                scan.close();
                InputMethods.closeScanner();
                System.exit(0);
        }
    }

    public static void main(String[] args) {
        TreeImplementation ti = new TreeImplementation();
        while (true) {
            ti.options(ti.MainMenu());
        }
    }
}