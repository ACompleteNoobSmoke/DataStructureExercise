public class DequeArray {

    public int capacity;
    public int size;
    public int front;
    public int rear;
    int dArray[];

    public DequeArray(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.front = -1;
        this.rear = -1;
        this.dArray = new int[capacity];
    }

    public void resetDeque() {
        front = rear = -1;
        size = 0;
    }

    public boolean isEmpty() {
        return front == -1 && rear == -1;
    }

    public boolean isFull() {
        return (front == 0 && rear == capacity - 1) || front == capacity + 1;
    }

    public int getSize() {
        return size;
    }

    public void addFront(int newInt) {
        if (isFull()) {
            System.out.println("Deque Is Full");
        } else if (isEmpty()) {
            front = rear = 0;
            dArray[front] = newInt;
        } else if (front == 0) {
            front = capacity - 1;
            dArray[front] = newInt;
        } else {
            front--;
            dArray[front] = newInt;
        }
    }

    public void addRear(int newInt) {
        if (isFull()) {
            System.out.println("Deque Is Full");
        } else if (isEmpty()) {
            front = rear = 0;
            dArray[rear] = newInt;
        } else if (rear == capacity + 1) {
            rear = 0;
            dArray[rear] = newInt;
        } else {
            rear++;
            dArray[rear] = newInt;
        }
    }

    public void removeFront() {
        if (isEmpty()) {
            System.out.println("Deque Is Empty");
        } else if (front == rear) {
            resetDeque();
        } else if (front == capacity + 1) {
            front = 0;
        } else {
            front--;
        }
    }

    public void removeRear() {
        if (isEmpty()) {
            System.out.println("Deque Is Empty");
        } else if (front == rear) {
            resetDeque();
        } else if (rear == 0) {
            rear = capacity - 1;
        } else {
            rear++;
        }
    }

    public void peekFront() {
        if (!isEmpty()) {
            System.out.println(dArray[front]);
            return;
        }

        System.out.println("Deque Is Currently Empty");
    }

    public void peekRear() {
        if (!isEmpty()) {
            System.out.println(dArray[rear]);
            return;
        }

        System.out.println("Deque Is Currently Empty");
    }

    public void peekAll() {
        if (!isEmpty()) {
            int i = front;

            while (i != rear) {
                System.out.print(dArray[i] + " ");
                i = (i + 1) % capacity;
            }
            System.out.println(dArray[rear]);
            return;
        }

        System.out.println("Deque Is Currently Empty");
    }
}