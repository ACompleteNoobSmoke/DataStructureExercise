
public class JiffyLube {

    static Deque myD;

    public JiffyLube() {
        myD = new Deque();

    }

    public void switchCases(int pick) {
        switch (pick) {
            case 1:
                enterToDeque();
                break;
            case 2:
                removeFromDeque();
                break;
            case 3:
                viewDeque();
                break;
            case 4:
                closeProgram();
                break;
        }
    }

    public void enterToDeque() {
        int enterOption = registerMenu();
        carRegister newCar = null;

        if (enterOption != 3) {
            newCar = newRegister();
            if (enterOption == 1) {
                myD.addFront(newCar);
            } else {
                myD.addRear(newCar);
            }
        }
        return;
    }

    public void removeFromDeque() {
        int removeDequeOption = removeMenu();
        if (removeDequeOption == 1) {
            removeTop();
        } else if (removeDequeOption == 2) {
            removeBottom();
        }
        return;
    }

    public void viewDeque() {
        int viewingOption = viewMenu();

        switch (viewingOption) {
            case 1:
                seeTop();
                break;
            case 2:
                seeBottom();
                break;
            case 3:
                seeAll();
                break;
        }
        return;
    }

    public void mainMenu() {
        System.out.println("*** Main Menu ***");
        System.out.println("1. Register New Vehicle");
        System.out.println("2. Remove Vehicle");
        System.out.println("3. View List");
        System.out.println("4. Exit");
        System.out.print("\nAction: ");
    }

    public int mainMenuChoice() {
        int choice = 0;
        while (choice <= 0 || choice > 4) {
            mainMenu();
            choice = InputMethods.getInt();
        }
        System.out.println("");
        return choice;
    }

    public int registerMenu() {
        int registerChoice = 0;
        while (registerChoice <= 0 || registerChoice > 3) {
            System.out.println("*** Register New Vehicle ***");
            System.out.println("1. Add Top Of The List");
            System.out.println("2. Add Bottom Of The List");
            System.out.println("3. Back");
            System.out.print("\nAction: ");
            registerChoice = InputMethods.getInt();
            System.out.println("");
        }
        return registerChoice;
    }

    public int removeMenu() {
        int removeChoice = 0;
        while (removeChoice <= 0 || removeChoice > 3) {
            System.out.println("*** Remove Vehicle ***");
            System.out.println("1. Remove Top Of The List");
            System.out.println("2. Remove Bottom Of The List");
            System.out.println("3. Back");
            System.out.print("\nAction: ");
            removeChoice = InputMethods.getInt();
            System.out.println("");
        }

        return removeChoice;
    }

    public int viewMenu() {
        int viewChoice = 0;
        while (viewChoice <= 0 || viewChoice > 4) {
            System.out.println("*** View Option ***");
            System.out.println("1. View Top Of The List");
            System.out.println("2. View Bottom Of The List");
            System.out.println("3. View Entire List");
            System.out.println("4. Back");
            System.out.print("\nAction: ");
            viewChoice = InputMethods.getInt();
            System.out.println("");
        }

        return viewChoice;
    }

    public carRegister newRegister() {
        System.out.println("*** New Vehicle ***");
        System.out.print("Enter Customer Name: ");
        String name = InputMethods.getString();
        System.out.print("Enter Vehicle Model: ");
        String vehicleModel = InputMethods.getString();
        int vehicleYear = 0;
        while (vehicleYear < 1990 || vehicleYear > 2020) {
            System.out.print("Enter Vehicle Year: ");
            vehicleYear = InputMethods.getInt();
        }
        System.out.print("What seems to be the problem?: ");
        String reason = InputMethods.getString();
        System.out.println("");
        return returnCarRegister(name, vehicleModel, vehicleYear, reason);
    }

    public carRegister returnCarRegister(String name, String vehicleModel, int vehicleYear, String reason) {
        carRegister cr = new carRegister(name, vehicleModel, vehicleYear, reason);
        return cr;
    }

    public void seeTop() {
        System.out.println("*** Top Of The List ***\n");
        DequeNode showTop = myD.peekFront();
        System.out.println(showTop == null ? "List Is Currently Empty\n" : showTop);

    }

    public void seeBottom() {
        System.out.println("*** Bottom Of The List ***\n");
        DequeNode showBottom = myD.peekLast();
        System.out.println(showBottom == null ? "List Is Currently Empty\n" : showBottom);
    }

    public void seeAll() {
        System.out.println("*** Full List ***\n");
        if (!myD.isEmpty()) {
            myD.printAll();
            return;
        }
        System.out.println("List Is Currently Empty\n");
    }

    public void removeTop() {
        if (!myD.isEmpty()) {
            seeTop();
            System.out.println("Removed From Top Of The List\n");
            return;
        }
        System.out.println("*** Top Of The List***\n");
        System.out.println("List Is Currently Empty\n");
    }

    public void removeBottom() {
        if (!myD.isEmpty()) {
            seeBottom();
            System.out.println("Removed From Bottom Of The List\n");
            return;
        }
        System.out.println("*** Bottom Of The List***\n");
        System.out.println("List Is Currently Empty\n");
    }

    public void closeProgram() {
        System.out.println("Closing Program...");
        InputMethods.closeInputScanner();
        System.exit(0);
    }

    public static void main(String[] args) {
        JiffyLube jl = new JiffyLube();
        while (true) {
            int i = jl.mainMenuChoice();
            jl.switchCases(i);
        }
    }

}