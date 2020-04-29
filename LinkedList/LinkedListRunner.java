import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class LinkedListRunner extends LinkedListImplementation {

    Scanner scan = new Scanner(System.in);

    public void menu() {
        System.out.println("*** Menu ***");
        System.out.println("1. Enter Information (Front)");
        System.out.println("2. Enter Information (Rear)");
        System.out.println("3. Enter Information (Pick Index)");
        System.out.println("4. Remove (Front)");
        System.out.println("5. Remove (Rear)");
        System.out.println("6. Size");
        System.out.println("7. Display (Front)");
        System.out.println("8. Display (Rear)");
        System.out.println("9. Display (All)");
        System.out.println("10. Exit");
        System.out.print("Action: ");
    }

    public int menuChoice() {
        int menuPick = 0;
        while (menuPick <= 0 || menuPick > 10) {
            try {
                menu();
                menuPick = scan.nextInt();
                scan.nextLine();
            } catch (InputMismatchException e) {
                scan.nextLine();
            }
        }

        return menuPick;
    }

    public void choices(int pick) {
        switch (pick) {
            case 1:
                getInformation(pick);
                break;
            case 2:
                getInformation(pick);
                break;
            case 3:
                getInfoAndIndex();
                break;
            case 4:
                removeHead();
                break;
            case 5:
                removeTail();
                break;
            case 6:
                System.out.println(getSize());
                break;
            case 7:
                displayHead();
                break;
            case 8:
                displayTail();
                break;
            case 9:
                displayAll();
                break;
            case 10:
                closeScanner(scan);
                System.exit(0);
        }
    }

    public void getInformation(int choice) {
        System.out.println("*** Enter Information ***");
        String title = getFilm();
        int year = getYear();

        if (choice == 1) {
            insertHead(title, year);
        } else {
            insertTail(title, year);
        }
    }

    public void getInfoAndIndex() {
        System.out.println("*** Enter Information ***");
        String title = getFilm();
        int year = getYear();
        int index = getIndex();
        insertAt(index, title, year);
    }

    public String getFilm() {
        System.out.print("Please Enter Film: ");
        String film = scan.nextLine();
        return film;
    }

    public int getYear() {
        int year = 0;
        while (year <= 0) {
            try {
                System.out.print("Please Enter Release Year: ");
                year = scan.nextInt();
                scan.nextLine();
            } catch (InputMismatchException e) {
                scan.nextLine();
            }
        }
        return year;
    }

    public int getIndex() {
        int index = 0;
        while (index <= 0 || index > size + 1) {
            try {
                System.out.print("Pick Position: ");
                index = scan.nextInt();
                scan.nextLine();
            } catch (InputMismatchException e) {
                scan.nextLine();
            }
        }

        return index;
    }

    public void closeScanner(Scanner scan) {
        scan.close();
    }

    public static void main(String[] args) {
        LinkedListRunner LL = new LinkedListRunner();
        while (true) {
            LL.choices(LL.menuChoice());
        }
    }

}