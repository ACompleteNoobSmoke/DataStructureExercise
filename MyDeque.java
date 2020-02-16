public class MyDeque {

    int front; // Front of the deque.
    int rear; // Rear of the deque.
    int cap; // Maximum capicity of the deque.
    int[] deque; // Array of integers for the deque.

    public MyDeque(int x) {
        front = -1; // Initiliaze the deque by setting the front and rear to -1
        rear = -1; // and setting the capicity of the deque to the amount entered.
        cap = x;
        deque = new int[cap];
    }

    public boolean isEmpty() {
        return front == -1 && rear == -1;
    }

    public boolean isFull() {
        return ((front == 0 && rear == cap - 1) || (front == cap + 1));
    }

    public void addFront(int x) {
        if (isFull()) {
            System.out.println("Deque Is Full");
        } else if (isEmpty()) {
            front = rear = 0; // If the deque is empty then set the index to zero before
            deque[front] = x; // adding data.
        } else if (front == 0) {
            front = cap - 1; // If the front index is at the beginning. It is set to the
            deque[front] = x; // index before adding the data.
        } else {
            front--; // If previous conditions are false then simply set the
            deque[front] = x; // index to the last then add the data.
        }
    }

    public void addRear(int x) {
        if (isFull()) {
            System.out.println("Deque Is Full");
        } else if (isEmpty()) {
            front = rear = 0;
            deque[rear] = x;
        } else if (rear == cap - 1) {
            rear = 0;
            deque[rear] = x;
        } else {
            rear++;
            deque[rear] = x;
        }
    }

    public void removeFront() {
        if (isEmpty()) {
            System.out.println("Deque Is Empty");
        } else if (front == rear) {
            front = rear = -1;
        } else if (front == cap - 1) {
            front = 0;
        } else {
            front++;
        }
    }

    public void removeRear() {
        if (isEmpty()) {
            System.out.println("Deque Is Empty");
        } else if (front == rear) {
            front = rear = -1;
        } else if (rear == 0) {
            rear = cap - 1;
        } else {
            rear--;
        }
    }

    public void showFront() {
        if (isEmpty()) {
            System.out.println("Deque Is Empty");
        } else {
            System.out.println(deque[front]);
        }
    }

    public void showRear() {
        if (isEmpty()) {
            System.out.println("Deque Is Empty");
        } else {
            System.out.println(deque[rear]);
        }
    }

    public void showAll() {
        if (isEmpty()) {
            System.out.println("Deque Is Empty");
        } else {
            int i = front;

            while (i != rear) {
                System.out.print(deque[i] + " ");
                i = (i + 1) % cap;
            }
            System.out.println(deque[rear]);
        }
    }

}
