public class MinHeap {

    private int capacity;
    private int size;
    PatientInLine[] newPatient;

    public MinHeap(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        newPatient = new PatientInLine[capacity];
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
        return newPatient[getLeftChildIndex(index)].getPriority();
    }

    public int rightChild(int index) {
        return newPatient[getRightChildIndex(index)].getPriority();
    }

    public int parent(int index) {
        return newPatient[getParentIndex(index)].getPriority();
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
    }

    public void ensureCapacity() {
        if (isFull()) {
            PatientInLine[] newArray = new PatientInLine[capacity * 2];
            for (int i = 0; i < size; i++) {
                newArray[i] = newPatient[i];
            }
            newPatient = newArray;
            capacity *= 2;
        }
    }

    public void swap(int indexOne, int indexTwo) {
        if (!isEmpty()) {
            PatientInLine temp = newPatient[indexOne];
            newPatient[indexOne] = newPatient[indexTwo];
            newPatient[indexTwo] = temp;
            return;
        }
    }

    public void heapifyUP() {
        int index = size - 1;
        while (hasParent(index) && parent(index) > newPatient[index].getPriority()) {
            swap(getParentIndex(index), index);
            index = getParentIndex(index);
        }
    }

    public void heapifyDOWN() {
        int index = 0;
        while (hasLeftChild(index)) {
            int smallerChildIndex = getLeftChildIndex(index);

            if (hasRightChild(index) && rightChild(index) < leftChild(index)) {
                smallerChildIndex = getRightChildIndex(index);
            }

            if (newPatient[index].getPriority() < newPatient[smallerChildIndex].getPriority()) {
                break;
            } else {
                swap(index, smallerChildIndex);
            }

            index = smallerChildIndex;

        }
    }

    public void add(PatientInLine newPeep) {
        ensureCapacity();
        newPatient[size] = newPeep;
        size++;
        heapifyUP();
    }

    public PatientInLine poll() {
        if (isEmpty()) {
            return null;
        }

        PatientInLine polled = newPatient[0];
        newPatient[0] = newPatient[size - 1];
        size--;
        heapifyDOWN();
        return polled;
    }

    public PatientInLine peek() {
        if (isEmpty()) {
            return null;
        }

        return newPatient[0];
    }

    public PatientInLine search(String name) {
        if (isEmpty()) {
            return null;
        }

        PatientInLine foundPatient = null;
        for (int i = 0; i < size; i++) {
            if (newPatient[i].getPatientName().equalsIgnoreCase(name)) {
                foundPatient = newPatient[i];
                break;
            }
        }

        return foundPatient;
    }

    public void printAll() {
        if (isEmpty()) {
            System.out.println("Empty");
            return;
        }

        for (PatientInLine printPatient : newPatient) {
            System.out.println(printPatient);
        }
    }

    public PatientInLine[] getPatientArray() {
        return newPatient;
    }

    public int getSize() {
        return size;
    }

}