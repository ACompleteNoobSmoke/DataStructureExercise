import java.util.InputMismatchException;

public class DoublyLinkedListImplem extends DoublyLinkedList {

    Scanner scan = new Scanner(System.in);

    public void mainMenu() {
        System.out.println("*** Menu ***");
        System.out.println("1. Insert Song Information (Front)");
        System.out.println("2. Insert Song Information (Rear)");
        System.out.println("3. Insert Song Information (Your Choice)");
        System.out.println("4. Remove First Song");
        System.out.println("5. Remove Last Song");
        System.out.println("6. Remove Song(Your Choice)");
        System.out.println("7. See First Song");
        System.out.println("8. See Last Song");
        System.out.println("9. See All Songs");
        System.out.println("10. Exit");
        System.out.print("\nAction: ");
    }

    public int selectOption() {
        int pick = 0;
        while (pick <= 0 || pick > 10) {
            mainMenu();
            pick = getInt();
        }
        return pick;
    }

    public void options(int choice) {
        switch (choice) {
            case 1:
                insertHead(addNewSong());
                break;
            case 2:
                insertTail(addNewSong());
                break;
            case 3:
                insertAt(getIndex(), addNewSong());
                break;
            case 4:
                removeHead();
                break;
            case 5:
                removeTail();
                break;
            case 6:
                removeAt(getIndex());
                break;
            case 7:
                peekHead();
                break;
            case 8:
                peekTail();
                break;
            case 9:
                displayAll();
                break;
            case 10:
                scan.close();
                System.exit(0);
        }
    }

    public Music addNewSong() {
        System.out.println("*** Song Information ***");
        System.out.print("Song Title: ");
        String songTitle = getString();
        System.out.print("Song Artist: ");
        String songArtist = getString();
        int year = 0;
        while (year <= 0 || year > 9999) {
            System.out.print("Song Release Year: ");
            year = getInt();
        }

        Music newMusic = new Music(title, artist, year);
        return newMusic;

    }

    public String getString() {
        String newString = "";

        while (newString.isEmpty()) {
            newString = scan.nextLine();
        }
        return newString;
    }

    public int getInt() {
        int newInt = 0;
        try {
            newInt = scan.nextInt();
            scan.nextLine();
        } catch (InputMismatchException e) {
            scan.nextLine();
        }

        return newInt;
    }

    public int getIndex() {
        int index = 0;
        while (index <= 0 || index > getSize() + 1) {
            System.out.print("Select Position: ");
            index = getInt();
        }

        return index;
    }

    public static void main(String[] args) {
        DoublyLinkedListImplem DLL = new DoublyLinkedListImplem();
        while (true) {
            DLL.options(DLL.selectOption());
        }
    }
}