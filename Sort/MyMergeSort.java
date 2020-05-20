import java.util.Random;

public class MyMergeSort {

    public static int[] getArray(int size) {
        int[] newArray = new int[size];
        Random rand = new Random();
        for (int i = 0; i < size; i++) {
            newArray[i] = rand.nextInt(31);
        }
        return newArray;
    }

    public static int[] mergeSortAsc(int[] arr) {
        int length = arr.length;
        if (length <= 1) {
            return arr;
        }

        int midpoint = length / 2;
        int otherpoint = length - midpoint;
        int[] left = new int[midpoint];
        int[] right = new int[otherpoint];
        int[] result = new int[length];

        for (int i = 0; i < midpoint; i++) {
            left[i] = arr[i];
        }

        for (int j = 0; j < otherpoint; j++) {
            right[j] = arr[midpoint + j];
        }

        left = mergeSortAsc(left);
        right = mergeSortAsc(right);
        result = mergeAsc(left, right);
        return result;
    }

    public static int[] mergeAsc(int[] leftArray, int[] rightArray) {
        int lSize = leftArray.length;
        int rSize = rightArray.length;
        int[] resultArray = new int[lSize + rSize];
        int leftPointer, rightPointer, resultPointer;
        leftPointer = rightPointer = resultPointer = 0;

        while (leftPointer < lSize || rightPointer < rSize) {
            if (leftPointer < lSize && rightPointer < rSize) {
                if (leftArray[leftPointer] < rightArray[rightPointer]) {
                    resultArray[resultPointer++] = leftArray[leftPointer++];
                } else {
                    resultArray[resultPointer++] = rightArray[rightPointer++];
                }
            } else if (leftPointer < lSize) {
                resultArray[resultPointer++] = leftArray[leftPointer++];
            } else if (rightPointer < rSize) {
                resultArray[resultPointer++] = rightArray[rightPointer++];
            }
        }
        return resultArray;
    }

    // public static int[] mergeSortDesc(int[] arr) {
    // int length = arr.length;
    // if (length <= 1) {
    // return arr;
    // }

    // int midpoint = length / 2;
    // int otherpoint = length - midpoint;
    // int[] left = new int[midpoint];
    // int[] right = new int[otherpoint];
    // int[] result = new int[length];

    // for (int i = 0; i < midpoint; i++) {
    // left[i] = arr[i];
    // }

    // for (int j = 0; j < otherpoint; j++) {
    // right[j] = arr[midpoint + j];
    // }

    // left = mergeSortDesc(left);
    // right = mergeSortDesc(right);
    // result = mergeDesc(left, right);
    // return result;
    // }

    // public static int[] mergeDesc(int[] leftArray, int[] rightArray) {
    // int lSize = leftArray.length;
    // int rSize = rightArray.length;
    // int[] resultArray = new int[lSize + rSize];
    // int leftPointer, rightPointer, resultPointer;
    // leftPointer = rightPointer = resultPointer = 0;

    // while (leftPointer < lSize || rightPointer < rSize) {
    // if (leftPointer < lSize && rightPointer < rSize) {
    // if (leftArray[leftPointer] > rightArray[rightPointer]) {
    // resultArray[resultPointer++] = leftArray[leftPointer++];
    // } else {
    // resultArray[resultPointer++] = rightArray[rightPointer++];
    // }
    // } else if (leftPointer < lSize) {
    // resultArray[resultPointer++] = leftArray[leftPointer++];
    // } else if (rightPointer < rSize) {
    // resultArray[resultPointer++] = rightArray[rightPointer++];
    // }
    // }

    // return resultArray;
    // }

    public static void print(int[] printThis) {
        for (int i : printThis) {
            System.out.print(i + " ");
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        int[] sortArray = getArray(10);
        // int[] sortArray2 = sortArray;
        System.out.print("Unsorted Array(Ascending): ");
        print(sortArray);
        sortArray = mergeSortAsc(sortArray);
        System.out.print("Sorted Array(Ascending): ");
        print(sortArray);
        // System.out.print("Unsorted Array(Descending): ");
        // print(sortArray2);
        // sortArray2 = mergeSortDesc(sortArray2);
        // System.out.print("Sorted Array(Descending): ");
        // print(sortArray2);

    }
}