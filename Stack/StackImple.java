import java.util.InputMismatchException;
import java.util.Scanner;

public class StackImple {

    static Scanner scan = new Scanner(System.in);
    static Stack stackOfBooks;

    public void initializeStack() {
        System.out.println("Total Size Of Stack: ");
        int totalSize = getInt();
        stackOfBooks = new Stack(totalSize);
    }

    public int mainMenu() {
        int choice = 0;
        while (choice <= 0 || choice > 7) {
            System.out.println("*** Main Menu ***");
            System.out.println("1. New Book");
            System.out.println("2. Remove Recent Book");
            System.out.println("3. View Recent Book");
            System.out.println("4. View All Books");
            System.out.println("5. Cart Size");
            System.out.println("6. Increase Cart Size");
            System.out.println("7. Exit");
            System.out.print("\nAction: ");
            choice = getInt();
        }
        return choice;
    }

    public void addNewBook() {
        if (!stackOfBooks.isFull()) {
            System.out.println("*** New Book ***");
            System.out.print("Enter Book Title: ");
            String title = getString();
            System.out.println("Who is the author of " + title + "?");
            System.out.print("Answer: ");
            String author = getString();
            System.out.println("When was " + title + " published?");
            System.out.print("Answer: ");
            int publishDate = getPublished();
            Books newBook = getBook(title, author, publishDate);
            stackOfBooks.push(newBook);
            System.out.println("New Book Added!\n");
        } else {
            System.out.println("Cart Is Full!");
        }
    }

    public void increaseStack() {
        System.out.print("Add To Cart Limit: ");
        int newSize = getInt();
        stackOfBooks.expand(newSize);
    }

    public void switchOptions(int pick) {
        switch (pick) {
            case 1:
                addNewBook();
                break;
            case 2:
                Books removed = stackOfBooks.pop();
                System.out.println(removed != null ? "Removed Book\n\n" + removed : "Empty Cart");
                scan.nextLine();
                break;
            case 3:
                stackOfBooks.peek();
                break;
            case 4:
                stackOfBooks.printAll();
                break;
            case 5:
                System.out.println("Cart Size: " + stackOfBooks.getSize() + "\nTotal Cart Limit: "
                        + stackOfBooks.getCapicity() + "\n");
                break;
            case 6:
                increaseStack();
                break;
            case 7:
                System.out.println("Exiting Program...");
                closeScanner(scan);
                System.exit(0);
        }
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

    public String getString() {
        String newString = "";
        while (newString.isEmpty()) {
            newString = scan.nextLine();
        }
        return newString;
    }

    public int getPublished() {
        int publish = 0;
        while (publish <= 0 || publish > 9999) {
            publish = getInt();
        }
        return publish;
    }

    public Books getBook(String title, String author, int publishDate) {
        Books newBookInfo = new Books(title, author, publishDate);
        return newBookInfo;
    }

    public void closeScanner(Scanner scan) {
        scan.close();
    }

    public static void main(String[] args) {
        StackImple newImple = new StackImple();
        newImple.initializeStack();
        while (true) {

            newImple.switchOptions(newImple.mainMenu());
        }
    }
}