public class LinkedListImplementation {

    LinkedNode Head;
    int size = 0;

    public boolean isEmpty() {
        return Head == null || size == 0;
    }

    public int getSize() {
        return size;
    }

    public void insertHead(String title, int year) {
        LinkedNode newNode = new LinkedNode(title, year, null);
        if (isEmpty()) {
            Head = newNode;
        } else {
            newNode.setNext(Head);
            Head = newNode;
        }
        size++;
    }

    public void insertTail(String title, int year) {
        LinkedNode newNode = new LinkedNode(title, year, null);
        if (isEmpty()) {
            insertHead(title, year);
        } else {
            LinkedNode current = Head;

            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(newNode);
            size++;
        }
    }

    public void insertAt(int index, String title, int year) {
        if (isEmpty() || index == 1) {
            insertHead(title, year);
        } else if (Head.getNext() == null) {
            insertTail(title, year);
        } else {
            LinkedNode current = Head;

            for (int i = 1; i < index - 1; i++) {
                current = current.getNext();
                System.out.println(current);
            }

            LinkedNode newNode = new LinkedNode(title, year, current.getNext());
            current.setNext(newNode);

        }
    }

    public LinkedNode removeHead() {
        if (isEmpty()) {
            return null;
        }

        LinkedNode removed = Head;
        Head = Head.getNext();
        size--;
        return removed;
    }

    public LinkedNode removeTail() {
        LinkedNode removed = null;
        if (isEmpty()) {
            return null;
        } else if (Head.getNext() == null) {
            removed = null;
            Head = null;
        } else {

            LinkedNode current = Head;

            while (current.getNext().getNext() != null) {
                current = current.getNext();
            }
            removed = current.getNext();
            current.setNext(null);
            size--;

        }
        return removed;
    }

    public void displayHead() {
        if (isEmpty()) {
            System.out.println("Empty");
        } else {
            System.out.println(Head);
        }
    }

    public void displayTail() {
        if (isEmpty()) {
            System.out.println("Empty");
        } else if (Head.getNext() == null) {
            displayHead();
        } else {
            LinkedNode current = Head;

            while (current.getNext() != null) {
                current = current.getNext();
            }
            System.out.println(current);
        }
    }

    public void displayAll() {
        if (isEmpty()) {
            System.out.println("Empty");
        } else {
            LinkedNode current = Head;

            while (current != null) {
                System.out.println(current);
                current = current.getNext();
            }
        }
    }
}