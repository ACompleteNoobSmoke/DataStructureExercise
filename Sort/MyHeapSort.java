import java.util.Random;

public class MyHeapSort {
    int sortArray[];

    public int[] getArray() {
        int newArray[] = new int[6];
        Random rand = new Random();
        for (int i = 0; i < 6; i++) {
            newArray[i] = rand.nextInt(30);
        }
        return newArray;
    }

    public MyHeapSort() {
        sortArray = getArray();
    }

    public void swap(int indexOne, int indexTwo) {
        int temp = sortArray[indexOne];
        sortArray[indexOne] = sortArray[indexTwo];
        sortArray[indexTwo] = temp;
    }

    public void sort(int arr[]) {
        int length = arr.length;

        for (int i = length / 2 - 1; i >= 0; i--) {
            heapify(arr, length, i);
        }

        for (int i = length - 1; i > 0; i--) {
            swap(0, i);
            heapify(arr, i, 0);
        }
    }

    public void heapify(int arr[], int length, int index) {
        int largest = index;
        int left = (2 * index) + 1;
        int right = (2 * index) + 2;

        if (left < length && arr[left] > arr[largest]) {
            largest = left;
        }

        if (right < length && arr[right] > arr[largest]) {
            largest = right;
        }

        if (largest != index) {
            swap(index, largest);
            heapify(arr, length, largest);
        }
    }

    public void print() {
        for (int i : sortArray) {
            System.out.print(i + " ");
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        MyHeapSort mhs = new MyHeapSort();
        System.out.print("Unsorted Array: ");
        mhs.print();
        System.out.print("\nSorted Array: ");
        mhs.sort(mhs.sortArray);
        mhs.print();
    }

}