public class BubbleSort {

    public int size;
    public TransactionHistory[] transactionArray;

    public BubbleSort(int size, TransactionHistory[] transactionHistories) {
        this.size = size;
        this.transactionArray = transactionHistories;
    }

    public TransactionHistory[] sort() {
        boolean swapped = false;
        for (int i = 0; i < size + 1; i++) {
            System.out.println("Outer: " + i);
            swapped = false;
            for (int j = 1; j <= size - 1; j++) {
                if (transactionArray[j - 1].getCashSpent() > transactionArray[j].getCashSpent()) {
                    swap(j - 1, j);
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }

        return transactionArray;
    }

    public void swap(int indexOne, int indexTwo) {
        TransactionHistory temp = transactionArray[indexOne];
        transactionArray[indexOne] = transactionArray[indexTwo];
        transactionArray[indexTwo] = temp;
    }
}