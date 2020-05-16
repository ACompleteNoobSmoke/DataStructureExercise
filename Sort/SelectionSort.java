public class SelectionSort {

    WeightWatchers[] updates;
    int size;

    public SelectionSort(int plan) {
        this.updates = new WeightWatchers[plan];
        this.size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == updates.length;
    }

    public void ensureCapacity() {
        if (isFull()) {
            WeightWatchers[] newUpdates = new WeightWatchers[size + 1];

            for (int i = 0; i < size; i++) {
                newUpdates[i] = updates[i];
            }
            updates = newUpdates;
        }
    }

    public void add(WeightWatchers newLog) {
        ensureCapacity();
        updates[size] = newLog;
        size++;
    }

    public void swap(int indexOne, int indexTwo) {
        WeightWatchers temp = updates[indexOne];
        updates[indexOne] = updates[indexTwo];
        updates[indexTwo] = temp;
    }

    public void sort() {
        int n = size;
        for (int i = 0; i < n - 1; i++) {
            int m = i;
            for (int j = i + 1; j < n; j++) {
                if (updates[j].getCaloriesLost() > updates[m].getCaloriesLost()) {
                    m = j;
                }
            }
            if (m != i) {
                swap(i, m);
            }
        }
    }

    public void printRecent() {
        if (!isEmpty()) {
            updates[0].header();
            System.out.println(updates[size]);
            System.out.println("");
            return;
        }
        System.out.println("No Exercise Logged\n");
    }

    public void printAll() {
        if (!isEmpty()) {
            updates[0].header();
            for (WeightWatchers print : updates) {
                System.out.println(print + "\n");
            }
            return;
        }
        System.out.println("No Exercise Logged");
    }
}