
public class Restuarant extends InputMethods {

    static Queue myQ;

    public void initializeQueue() {
        int lineLimit = 0;
        while (lineLimit <= 0 || lineLimit > 15) {
            System.out.print("Limit Of People In Line {Total Capacity = 15}: ");
            lineLimit = getInt();
        }
        myQ = new Queue(lineLimit);
    }

    public int mainMenu() {
        int choice = 0;
        while (choice <= 0 || choice > 6) {
            System.out.println("*** Main Menu ***");
            System.out.println("1. Enter New Guest");
            System.out.println("2. Welcome New Guest");
            System.out.println("3. See First Guest");
            System.out.println("4. See Last Guest");
            System.out.println("5. Full Guest List");
            System.out.println("6. Exit");
            System.out.print("\nAction: ");
            choice = getInt();
        }
        return choice;
    }

    public void enterNewGuest() {
        if (!myQ.isFull()) {
            System.out.println("*** New Guest ***");
            System.out.print("Enter Guest Name: ");
            String guestName = getString();
            System.out.print("Hello " + guestName + "\nSize of ");
            int guestSize = getInt();
            PersonInLine newGuest = getPerson(guestName, guestSize);
            myQ.enqueue(newGuest);
            System.out.println("Guest Added To List!");
            return;
        }
        System.out.println("Line Is Full");
    }

    public void welcomeNewQuest() {
        if (!myQ.isEmpty()) {
            System.out.println("Welcome In " + myQ.dequeue().getGuestName());
            return;
        }
        System.out.println("Line Is Empty");
    }

    public void firstInLine() {
        if (!myQ.isEmpty()) {
            System.out.println("*** First In Line ***");
            System.out.println(myQ.peekFirst());
            getScan().nextLine();
            return;
        }
        System.out.println("Line Is Empty");
    }

    public void lastInLine() {
        if (!myQ.isEmpty()) {
            System.out.println("*** Last In Line ***");
            System.out.println(myQ.peekLast());
            getScan().nextLine();
            return;
        }
        System.out.println("Line Is Empty");
    }

    public void allInLine() {
        if (!myQ.isEmpty()) {
            System.out.println("*** Full Guest List ***");
            myQ.peekAll();
            getScan().nextLine();
            return;
        }
        System.out.println("Line Is Empty");
    }

    public void exitProgram() {
        System.out.println("Exiting Program...");
        closeInputScanner();
        System.exit(0);
    }

    public void options(int selected) {
        switch (selected) {
            case 1:
                enterNewGuest();
                break;
            case 2:
                welcomeNewQuest();
                break;
            case 3:
                firstInLine();
                break;
            case 4:
                lastInLine();
                break;
            case 5:
                allInLine();
                break;
            case 6:
                exitProgram();
        }
    }

    public PersonInLine getPerson(String guestName, int guestSize) {
        PersonInLine person = new PersonInLine(guestName, guestSize);
        return person;
    }

    public static void main(String[] args) {
        Restuarant newRestuarant = new Restuarant();
        newRestuarant.initializeQueue();

        while (true) {
            newRestuarant.options(newRestuarant.mainMenu());
        }
    }

}