public class TreeImplementation extends MyBinaryTree {

    public int mainMenu() {
        int menuChoice = 0;
        while (menuChoice <= 0 || menuChoice > 5) {
            System.out.println("*** Main Menu ***");
            System.out.println("1. New Student");
            System.out.println("2. Search Student");
            System.out.println("3. Remove Student");
            System.out.println("4. View All Student");
            System.out.println("5. Exit");
            System.out.print("\nAction: ");
            menuChoice = InputMethodsStudent.getInt();
        }
        return menuChoice;
    }

    public void addNewStudent() {
        System.out.println("*** Register New Student ***");
        String name = InputMethodsStudent.inputName();
        int id = InputMethodsStudent.inputID();
        String major = InputMethodsStudent.inputMajor();
        double grade = InputMethodsStudent.inputGradePerecentage();
        char gradeLetter = InputMethodsStudent.inputGradeLetter(grade);
        String gradeStatus = InputMethodsStudent.inputGradeStatus(gradeLetter);
        Students newStudent = new Students(name, major, id, grade, gradeLetter, gradeStatus);
        addNode(newStudent);
    }

    public void searchorremoveStudent(int choice) {
        System.out.println("*** Search Student ***\n");
        int searchID = InputMethodsStudent.inputID();
        Node searched = findNode(searchID);
        System.out.println(searched == null ? "Student Not Found\n" : searched);

        if (choice == 3) {
            removeNode(searchID);
            System.out.println("\nStudent Removed From Database!\n");
        }
    }

    public void viewAll() {
        System.out.println("*** All Students ***\n");
        inOrderTraverseTree(root);
    }

    public void closeProgram() {
        System.out.println("Closing Program...");
        InputMethodsStudent.closeScanner();
        System.exit(0);
    }

    public void switchCases() {
        int menuPick = mainMenu();
        switch (menuPick) {
            case 1:
                addNewStudent();
                break;
            case 2:
                searchorremoveStudent(menuPick);
                break;
            case 3:
                searchorremoveStudent(menuPick);
                break;
            case 4:
                viewAll();
                break;
            case 5:
                closeProgram();
        }
    }

    public static void main(String[] args) {
        TreeImplementation ti = new TreeImplementation();
        while (true) {
            ti.switchCases();
        }
    }

}