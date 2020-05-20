import java.util.Random;

public class QuickSort {

    public static int[] getArray(int size) {
        int[] newArray = new int[size];
        Random rand = new Random();
        for (int i = 0; i < size; i++) {
            newArray[i] = rand.nextInt(31);
        }
        return newArray;
    }

    public void swap(int[] swapThis, int indexOne, int indexTwo) {
        int temp = swapThis[indexOne];
        swapThis[indexOne] = swapThis[indexTwo];
        swapThis[indexTwo] = temp;
    }

    public void print(int[] printThis) {
        for (int i : printThis) {
            System.out.print(i + " ");
        }
        System.out.println("");
    }

    public void quickSort(int[] sortThis) {
        quickSort(sortThis, 0, sortThis.length - 1);
    }

    public void quickSort(int[] sortThis, int min, int max) {
        if (min < max + 1) {
            int loc = partition(sortThis, min, max);
            quickSort(sortThis, min, loc - 1);
            quickSort(sortThis, loc + 1, max);
        }
    }

    public int getPivot(int min, int max) {
        Random rand = new Random();
        return rand.nextInt((max - min) + 1) + min;
    }

    public int partition(int[] partThis, int min, int max) {
        int pivot = getPivot(min, max);

        swap(partThis, min, pivot);
        int border = min + 1;
        for (int i = border; i <= max; i++) {
            if (partThis[i] < partThis[min]) {
                swap(partThis, i, border++);
            }
        }
        swap(partThis, min, border - 1);
        return border - 1;
    }

    public static void main(String[] args) {
        QuickSort qs = new QuickSort();
        int[] intArray = getArray(10);
        System.out.print("Unsorted Array: ");
        qs.print(intArray);
        qs.quickSort(intArray);
        qs.print(intArray);
    }
}