import java.util.Random;

public class SortingMethods {

    int[] sortArray;

    public int[] getArray() {
        int[] newArray = new int[6];
        int n = newArray.length;
        Random rand = new Random();
        for (int i = 0; i < n; i++) {
            newArray[i] = rand.nextInt(11);
        }
        return newArray;
    }

    public SortingMethods() {
        sortArray = getArray();
    }

    public void printArray() {
        for (int i : sortArray) {
            System.out.print(i + " ");
        }
        System.out.println("");
    }

    public void swap(int indexOne, int indexTwo) {
        int temp = sortArray[indexOne];
        sortArray[indexOne] = sortArray[indexTwo];
        sortArray[indexTwo] = temp;
    }

    public void bubbleSort() {
        int n = sortArray.length;
        for (int i = 0; i < n; i++) {
            boolean swapped = false;
            for (int j = 0; j < n; j++) {
                if (sortArray[i] < sortArray[j]) {
                    swap(i, j);
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }
    }

    public void insertionSort() {
        int n = sortArray.length;
        for (int i = 1; i < n; i++) {
            int temp = sortArray[i];
            int j = i - 1;
            while (j >= 0 && sortArray[j] > temp) {
                sortArray[j + 1] = sortArray[j];
                j--;
            }
            sortArray[j + 1] = temp;
        }
    }

    public void selectionSort() {
        int n = sortArray.length;
        for (int i = 0; i < n - 1; i++) {
            int m = i;
            for (int j = i + 1; j < n; j++) {
                if (sortArray[j] < sortArray[m]) {
                    m = j;
                }
            }
            if (m != i) {
                swap(i, m);
            }
        }
    }

    public static void main(String[] args) {
        SortingMethods SoM = new SortingMethods();
        System.out.println("*********************************************");
        System.out.println(" BUBBLE SORT \n");
        System.out.print("Unsorted Array: ");
        SoM.printArray();
        SoM.bubbleSort();
        System.out.print("Sorted Array: ");
        SoM.printArray();
        System.out.println("*********************************************\n\n");

        SortingMethods SoM2 = new SortingMethods();
        System.out.println("*********************************************");
        System.out.println(" SELECTION SORT \n");
        System.out.print("Unsorted Array: ");
        SoM2.printArray();
        SoM2.selectionSort();
        System.out.print("Sorted Array: ");
        SoM2.printArray();
        System.out.println("*********************************************\n\n");

        SortingMethods SoM3 = new SortingMethods();
        System.out.println("*********************************************");
        System.out.println("              INSERTION SORT\n ");
        System.out.print("Unsorted Array: ");
        SoM3.printArray();
        SoM3.insertionSort();
        System.out.print("Sorted Array: ");
        SoM3.printArray();
        System.out.println("*********************************************\n\n");
    }
}