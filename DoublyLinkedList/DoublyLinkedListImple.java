import java.util.InputMismatchException;
import java.util.Scanner;

public class DoublyLinkedListImple extends DoublyLinkedList {

    static Scanner scan = new Scanner(System.in);

    public int mainMenu() {
        int pick = 0;
        while (pick <= 0 || pick > 4) {
            System.out.println("*** Menu ***");
            System.out.println("1. Insert Options");
            System.out.println("2. Remove Options");
            System.out.println("3. View Options");
            System.out.println("4. Exit");
            System.out.print("\nAction: ");
            pick = getInt();
        }
        return pick;
    }

    public int insertMenu() {
        int insertPick = 0;
        while (insertPick <= 0 || insertPick > 4) {
            System.out.println("*** Insert Menu ***");
            System.out.println("1. Insert Song Information (Front)");
            System.out.println("2. Insert Song Information (Rear)");
            System.out.println("3. Insert Song Information (Your Choice)");
            System.out.println("4. Back");
            System.out.print("\nAction: ");
            insertPick = getInt();
            System.out.println("");
        }
        return insertPick;
    }

    public int removeMenu() {
        int removePick = 0;
        while (removePick <= 0 || removePick > 4) {
            System.out.println("*** Remove Menu ***");
            System.out.println("1. Remove First Song");
            System.out.println("2. Remove Last Song");
            System.out.println("3. Remove Song(Your Choice)");
            System.out.println("4. Back");
            System.out.print("\nAction: ");
            removePick = getInt();
            System.out.println("");
        }
        return removePick;
    }

    public int viewMenu() {
        int viewPick = 0;
        while (viewPick <= 0 || viewPick > 4) {
            System.out.println("*** Remove Menu ***");
            System.out.println("1. See First Song");
            System.out.println("2. See Last Song");
            System.out.println("3. See All Songs");
            System.out.println("4. Back");
            System.out.print("\nAction: ");
            viewPick = getInt();
            System.out.println("");
        }
        return viewPick;
    }

    public void options() {
        int choice = mainMenu();
        switch (choice) {
            case 1:
                insertActions();
                break;
            case 2:
                removeActions();
                break;
            case 3:
                viewActions();
                break;
            case 4:
                scan.close();
                System.exit(0);
        }
    }

    public void insertActions() {
        int insertMenuChoice = insertMenu();

        if (insertMenuChoice != 4) {
            Music addMusic = addNewSong();
            if (insertMenuChoice == 1) {
                insertHead(addMusic);
            } else if (insertMenuChoice == 2) {
                insertTail(addMusic);
            } else {
                insertAt(getIndex(), addMusic);
            }

            System.out.println("\nNew Song Added To PlayList!\n");
        }
    }

    public void removeActions() {
        int removeMenuChoice = removeMenu();

        if (removeMenuChoice != 4) {
            if (removeMenuChoice == 1) {
                removeTopSong();
            } else if (removeMenuChoice == 2) {
                removeLastSong();
            } else {
                removeAtIndex();
            }
        }
    }

    public void removeTopSong() {
        if (isEmpty()) {
            System.out.println("\nPlaylist Is Currently Empty!\n");
            return;
        }
        peekHead();
        removeHead();
        System.out.println("\nSong Has Been Removed From Playlist!\n");
    }

    public void removeLastSong() {
        if (isEmpty()) {
            System.out.println("\nPlaylist Is Currently Empty!\n");
            return;
        }
        peekTail();
        removeTail();
        System.out.println("\nSong Has Been Removed From Playlist!\n");
    }

    public void removeAtIndex() {
        if (isEmpty()) {
            System.out.println("\nPlaylist Is Currently Empty!\n");
            return;
        }

        int removalIndex = getIndex();
        System.out.println(
                removeAt(removalIndex) ? "\nSong Has Been Removed From Playlist!\n" : "\nSong Could Not Be Found\n");
    }

    public void viewActions() {
        int viewMenuChoice = viewMenu();

        if (viewMenuChoice != 4) {
            if (viewMenuChoice == 1) {
                peekHead();
            } else if (viewMenuChoice == 2) {
                peekTail();
            } else {
                displayAll();
            }
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

        Music newMusic = new Music(songTitle, songArtist, year);
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

        DoublyLinkedListImple dll = new DoublyLinkedListImple();
        while (true) {
            dll.options();
        }
    }
}