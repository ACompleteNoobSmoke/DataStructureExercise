import java.util.Random;
 

public class InsertionSort {

    static int[] insertArray;

    public int[] getArray() {
        int[] randArray = new int[10];
        Random random = new Random();
        for (int i = 0; i < randArray.length; i++) {
            randArray[i] = random.nextInt(15);
        }
        return randArray;
    }

    public void printArray(int[] printThis) {
        for (int n : printThis) {
            System.out.print(n + " ");
        }
        System.out.println("\n");
    }

    public void sort() {
        int n = insertArray.length;
        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (insertArray[j] > insertArray[i]) {
                    swapped = true;
                    swap(i, j);
                }
            }
            if (!swapped) {
                break;
            }
        }
    }

    public void swap(int indexOne, int indexTwo) {
        int temp = insertArray[indexOne];
        insertArray[indexOne] = insertArray[indexTwo];
        insertArray[indexTwo] = temp;
    }

    public static void main(String[] args) {
        InsertionSort is = new InsertionSort();
        System.out.println("*******************************");
        insertArray = is.getArray();
        System.out.print("Unsorted Array: ");
        is.printArray(insertArray);
        System.out.print("Sorted Array: ");
        is.sort();
        is.printArray(insertArray);
        System.out.println("*******************************\n");

        // System.out.println("*******************************");
        // insertArray = is.getArray();
        // System.out.print("Unsorted Array: ");
        // is.printArray(insertArray);
        // System.out.print("Sorted Array: ");
        // is.sort();
        // is.printArray(insertArray);
        // System.out.println("*******************************");
    }

}