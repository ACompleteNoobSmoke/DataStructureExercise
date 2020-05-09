import javafx.scene.effect.Blend;

public class OnlineBanking {

    public final double balanceLimit;
    public double current;
    public int size;
    public int capacity;
    TransactionHistory[] onlineHistory;

    public OnlineBanking() {
        this.balanceLimit = 2000;
        this.current = balanceLimit;
        this.size = 0;
        this.capacity = 10;
        this.onlineHistory = new TransactionHistory[capacity];
    }

    public int menu() {
        int menuchoice = 0;
        while (menuchoice <= 0 || menuchoice > 3) {
            System.out.println("*** Weenie Hut Banking ***");
            System.out.println("1. Withdraw Amount");
            System.out.println("2. View History");
            System.out.println("3. Exit");
            System.out.print("\nAction: ");
            menuchoice = InputMethods.getInt();
            System.out.println("");
        }
        return menuchoice;
    }

    public void switchOptions() {
        int pick = menu();
        switch (pick) {
            case 1:
                useCard();
                break;
            case 2:
                viewAction();
                break;
            case 3:
                System.out.println("\nClosing Program...\n");
                InputMethods.closeInputScanner();
                System.exit(0);
        }
    }

    public boolean overdraw(double cash) {
        return cash > current;
    }

    public void transaction(double cash) {
        if (!overdraw(cash)) {
            current = current - cash;
        }
    }

    public String getDetail() {
        System.out.print("Enter Location: ");
        String detail = InputMethods.getString();
        return detail;
    }

    public double getCashAmount() {
        double cashSpending = current + 1;
        while (cashSpending > current || cashSpending <= 0) {
            System.out.print("Amount Withdrawing: $");
            cashSpending = InputMethods.getDouble();
            if (overdraw(cashSpending)) {
                System.out.println("OVERDRAW!!!");
            }
        }
        return cashSpending;
    }

    public void useCard() {
        if (current > 0) {
            System.out.println("*** Card Withdrawal ***");
            ensureCapacity();
            String detail = getDetail();
            double cashSpent = getCashAmount();
            transaction(cashSpent);
            TransactionHistory newHistory = new TransactionHistory(detail, cashSpent, current, balanceLimit);
            onlineHistory[size] = newHistory;
            size++;
            return;
        }
        System.out.println("\nNo Currently Out Of Sufficient Funds\n");
    }

    public void ensureCapacity() {
        if (size == capacity) {
            TransactionHistory[] newArray = new TransactionHistory[capacity + 2];
            for (int i = 0; i < size; i++) {
                newArray[i] = onlineHistory[i];
            }
            onlineHistory = newArray;
        }
    }

    public int viewMenu() {
        int viewMenuPick = 0;
        while (viewMenuPick <= 0 || viewMenuPick > 4) {
            System.out.println("*** View History ***");
            System.out.println("1. View Recent Transaction");
            System.out.println("2. View History");
            System.out.println("3. View History (Sorted)");
            System.out.println("4. Back");
            System.out.print("\nAction: ");
            viewMenuPick = InputMethods.getInt();
        }
        return viewMenuPick;
    }

    public void viewAction() {
        int viewMenuPick = viewMenu();
        if (viewMenuPick == 1) {
            viewRecent();
        } else if (viewMenuPick == 2) {
            viewHistoryUnsorted();
        } else if (viewMenuPick == 3) {
            viewHistorySorted();
        }
        System.out.println("\nPress Anything To Continue!\n");
        InputMethods.getScan().nextLine();
    }

    public void viewRecent() {
        if (size > 0) {
            System.out.println("*** Recent Transaction ***\n");
            onlineHistory[size - 1].header();
            System.out.println(onlineHistory[size - 1].printAll());
            return;
        }
        System.out.println("No Transaction Has Recently Taken Place!\n");
    }

    public void viewHistoryUnsorted() {
        if (size > 0) {
            System.out.println("*** All Transaction ***\n");
            onlineHistory[0].header();
            for (int i = 0; i < size; i++) {
                System.out.println(onlineHistory[i].printAll());
            }
            System.out.println("");
            return;
        }
        System.out.println("No Transaction Has Recently Taken Place!\n");
    }

    public void viewHistorySorted() {
        if (size > 0) {
            BubbleSort bSort = new BubbleSort(size, onlineHistory);
            TransactionHistory[] sortThis = bSort.sort();
            System.out.println("*** All Transaction ***\n");
            onlineHistory[0].header();
            for (int i = 0; i < size; i++) {
                System.out.println(sortThis[i].printAll());
            }
            System.out.println("");
            return;
        }
        System.out.println("No Transaction Has Recently Taken Place!\n");
    }

    public static void main(String[] args) {
        OnlineBanking ob = new OnlineBanking();
        while (true) {
            ob.switchOptions();
        }
    }

}