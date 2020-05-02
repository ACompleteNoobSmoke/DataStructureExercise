public class DeqUser {

    int size;
    static DequeArray myD;

    public DeqUser(int size) {
        this.size = size;
        myD = new DequeArray(size);

    }

    public int mainMenu() {
        int menuChoice = 0;
        while (menuChoice <= 0 || menuChoice > 4) {
            System.out.println("*** Main Menu ***");
            System.out.println("1. Enter Number");
            System.out.println("2. Remove Number");
            System.out.println("3. View Numbers");
            System.out.println("4. Exit");
            System.out.print("\nAction: ");
            menuChoice = InputMethods.getInt();
        }
        return menuChoice;
    }

    public void switchCases() {
        int pick = mainMenu();
        switch (pick) {
            case 1:
                enterOption();
                break;
            case 2:
                removeOption();
                break;
            case 3:
                viewOption();
                break;
            case 4:
                closeProgram();
        }
    }

    public int enterMenu() {
        int enterChoice = 0;
        while (enterChoice <= 0 || enterChoice > 3) {
            System.out.println("*** Enter Menu ***");
            System.out.println("1. Add Front");
            System.out.println("2. Add Rear");
            System.out.println("3. Back");
            System.out.print("\nAction: ");
            enterChoice = InputMethods.getInt();
        }
        return enterChoice;
    }

    public int removeMenu() {
        int removeChoice = 0;
        while (removeChoice <= 0 || removeChoice > 3) {
            System.out.println("*** Remove Menu ***");
            System.out.println("1. Remove Front");
            System.out.println("2. Remove Rear");
            System.out.println("3. Back");
            System.out.print("\nAction: ");
            removeChoice = InputMethods.getInt();
        }
        return removeChoice;
    }

    public int viewMenu() {
        int viewChoice = 0;
        while (viewChoice <= 0 || viewChoice > 4) {
            System.out.println("*** View Menu ***");
            System.out.println("1. View Front");
            System.out.println("2. View Rear");
            System.out.println("3. View All");
            System.out.println("4. Back");
            System.out.print("\nAction: ");
            viewChoice = InputMethods.getInt();
        }
        return viewChoice;
    }

    public void enterOption() {
        int enterPick = enterMenu();
        if (enterPick != 3) {
            int newN = getNewNumber();
            if (enterPick == 1) {
                myD.addFront(newN);
            } else {
                myD.addRear(newN);
            }
        }
    }

    public void removeOption() {
        int removePick = removeMenu();

        if (removePick == 1) {
            myD.removeFront();
        } else if (removePick == 2) {
            myD.removeRear();
        }
    }

    public void closeProgram() {
        System.out.println("Closing Program...");
        InputMethods.closeInputScanner();
        System.exit(0);
    }

    public void viewOption() {
        int viewPick = viewMenu();

        if (viewPick == 1) {
            myD.peekFront();
        } else if (viewPick == 2) {
            myD.peekRear();
        } else if (viewPick == 3) {
            myD.peekAll();
        }
    }

    public int getNewNumber() {
        int newInt = InputMethods.getInt();
        return newInt;
    }

    public static void main(String[] args) {
        int size = 0;
        while (size <= 0) {
            System.out.print("Please Enter Size of Array: ");
            size = InputMethods.getInt();
        }

        DeqUser newD = new DeqUser(size);

        while (true) {
            newD.switchCases();
        }
    }

}