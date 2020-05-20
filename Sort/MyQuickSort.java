import java.util.Random;

public class MyQuickSort {

    public static int[] getArray(int size) {
        int[] newArray = new int[size];
        Random rand = new Random();
        for (int i = 0; i < size; i++) {
            newArray[i] = rand.nextInt(40 + 1);
        }
        return newArray;
    }

    public void quickSort(int[] A) {
        int max = A.length - 1;
        quickSort(A, 0, max);
    }

    private void quickSort(int[] A, int min, int max) {
        if (min < max + 1) {
            int loc = partition(A, min, max);
            quickSort(A, min, loc - 1);
            quickSort(A, loc + 1, max);
        }
    }

    private int getPivot(int min, int max) {
        Random rand = new Random();
        return rand.nextInt((max - min) + 1) + min;
    }

    private int partition(int[] A, int min, int max) {
        int pivot = getPivot(min, max);
        swap(A, min, pivot);
        int bound = min + 1;

        for (int i = bound; i <= max; i++) {
            if (A[i] < A[min]) {
                swap(A, i, bound++);
            }
        }

        swap(A, min, bound - 1);
        return bound - 1;

    }

    public void swap(int[] A, int indexOne, int indexTwo) {
        int temp = A[indexOne];
        A[indexOne] = A[indexTwo];
        A[indexTwo] = temp;
    }

    public void print(int[] A) {
        for (int i : A) {
            System.out.print(i + " ");
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        int[] useArray = getArray(10);
        System.out.print("Unsorted Array: ");
        MyQuickSort qSort = new MyQuickSort();
        qSort.print(useArray);
        qSort.quickSort(useArray);
        System.out.print("Sorted Array: ");
        qSort.print(useArray);
    }

}