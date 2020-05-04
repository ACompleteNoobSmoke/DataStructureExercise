public class MinHeap {

    private int capacity;
    public int size;
    int[] item;

    public MinHeap(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.item = new int[capacity];
    }

    public int getLeftChildIndex(int parentIndex) {
        return 2 * parentIndex + 1;
    }

    public int getRightChildIndex(int parentIndex) {
        return 2 * parentIndex + 2;
    }

    public int getParentIndex(int childIndex) {
        return (childIndex - 1) / 2;
    }

    public boolean hasLeftChild(int index) {
        return getLeftChildIndex(index) < size;
    }

    public boolean hasRightChild(int index) {
        return getRightChildIndex(index) < size;
    }

    public boolean hasParent(int index) {
        return getParentIndex(index) >= 0;
    }

    public int leftChild(int index) {
        return item[getLeftChildIndex(index)];
    }

    public int rightChild(int index) {
        return item[getRightChildIndex(index)];
    }

    public int parent(int index) {
        return item[getParentIndex(index)];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
    }

    public void swap(int indexOne, int indexTwo) {
        int temp = item[indexOne];
        item[indexOne] = item[indexTwo];
        item[indexTwo] = temp;
    }

    public void ensureCapacity() {
        if (isFull()) {
            int newArray[] = new int[capacity * 2];
            for (int i = 0; i < size; i++) {
                newArray[i] = item[i];
            }
            item = newArray;
        }
    }

    public void heapifyUp() {
        int index = size - 1;
        while (hasParent(index) && parent(index) > item[index]) {
            swap(getParentIndex(index), index);
            index = getParentIndex(index);
        }
    }

    public void heapifyDown() {
        int index = 0;

        while (hasLeftChild(index)) {
            int smallChildIndex = getLeftChildIndex(index);

            if (hasRightChild(index) && rightChild(index) < leftChild(index)) {
                smallChildIndex = getRightChildIndex(index);
            }

            if (item[index] < item[smallChildIndex]) {
                break;
            } else {
                swap(index, smallChildIndex);
            }

            index = smallChildIndex;
        }
    }

    public void add(int newItem) {
        ensureCapacity();
        item[size] = newItem;
        size++;
        heapifyUp();
    }

    public int poll() {
        if (isEmpty()) {
            System.out.println("Empty");
        }

        int removedItem = item[0];
        item[0] = item[size - 1];
        size--;
        heapifyDown();
        return removedItem;
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("Empty");
        }

        return item[0];
    }

    public void printAll() {
        if (isEmpty()) {
            System.out.println("Empty");
            return;
        }

        for (int i = 0; i < size; i++) {
            System.out.print(item[i] + " ");
        }

    }

}