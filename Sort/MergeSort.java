import java.util.Random;

public class MergeSort {

    public static int[] getArray(int size) {
        int[] newArray = new int[size];
        Random rand = new Random();
        for (int i = 0; i < size; i++) {
            newArray[i] = rand.nextInt(31);
        }
        return newArray;
    }

    public void print(int[] array) {
        for (int i : array) {
            System.out.print(i + " ");
        }
        System.out.println("");
    }

    public int[] mergeSortMethod(int[] array) {
        if (array.length <= 1) {
            return array;
        }

        int midpoint = array.length / 2;
        int[] left = new int[midpoint];
        int[] right = new int[array.length - midpoint];

        for (int i = 0; i < midpoint; i++) {
            left[i] = array[i];
        }

        for (int j = 0; j < right.length; j++) {
            right[j] = array[midpoint + j];
        }

        int[] result = new int[array.length];

        left = mergeSortMethod(left);
        right = mergeSortMethod(right);
        result = merge(left, right);
        return result;
    }

    public int[] merge(int[] left, int right[]) {
        int[] result = new int[left.length + right.length];
        int leftPointer, rightPointer, resultPointer;
        leftPointer = rightPointer = resultPointer = 0;

        while (leftPointer < left.length || rightPointer < right.length) {
            if (leftPointer < left.length && rightPointer < right.length) {
                if (left[leftPointer] < right[rightPointer]) {
                    result[resultPointer++] = left[leftPointer++];
                } else {
                    result[resultPointer++] = right[rightPointer++];
                }
            } else if (leftPointer < left.length) {
                result[resultPointer++] = left[leftPointer++];
            } else if (rightPointer < right.length) {
                result[resultPointer++] = right[rightPointer++];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        MergeSort ms = new MergeSort();
        int[] arr = getArray(10);
        System.out.print("Unsorted Array: ");
        ms.print(arr);
        arr = ms.mergeSortMethod(arr);
        System.out.print("Sorted Array: ");
        ms.print(arr);
    }
}