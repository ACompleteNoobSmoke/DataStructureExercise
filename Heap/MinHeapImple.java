public class MinHeapImple extends InputMethods {

    int capacity;
    static MinHeap newHeap;

    public MinHeapImple(int capacity) {
        this.capacity = capacity;
        newHeap = new MinHeap(capacity);
    }

    public int mainMenu() {
        int mainChoice = 0;
        while (mainChoice <= 0 || mainChoice > 5) {
            System.out.println("*** Main Menu ***");
            System.out.println("1. Add Number");
            System.out.println("2. Remove Number");
            System.out.println("3. View Top Number");
            System.out.println("4. View All Numbers");
            System.out.println("5. Exit");
            System.out.print("\nAction: ");
            mainChoice = getInt();
            System.out.println("");
        }
        return mainChoice;
    }

    public void switchCases() {
        int pick = mainMenu();
        switch (pick) {
            case 1:
                addNumber();
                break;
            case 2:
                remove();
                break;
            case 3:
                viewTop();
                break;
            case 4:
                viewAll();
                break;
            case 5:
                closeProgram();
                break;
        }
    }

    public void addNumber() {
        System.out.println("*** Add Number ***");
        System.out.print("Enter Number: ");
        int number = getInt();
        newHeap.add(number);
        System.out.println("");
    }

    public void viewTop() {
        System.out.println("*** View (First Number) ***\n");
        if (!newHeap.isEmpty()) {
            System.out.println(newHeap.peek());
            return;
        }
        System.out.println("Empty\n");
    }

    public void remove() {
        viewTop();
        if (!newHeap.isEmpty()) {
            System.out.println("\n" + newHeap.poll() + " Was Removed!\n");
        }
    }

    public void viewAll() {
        System.out.println("*** View All ***\n");
        newHeap.printAll();
        System.out.println("");
    }

    public void closeProgram() {
        System.out.println("Closing Program....");
        closeInputScanner();
        System.exit(0);
    }

    public static void main(String[] args) {
        System.out.print("Enter Capacity Of Heap: ");
        int initCap = getInt();
        MinHeapImple newHeap = new MinHeapImple(initCap);

        while (true) {
            newHeap.switchCases();
        }
    }

}