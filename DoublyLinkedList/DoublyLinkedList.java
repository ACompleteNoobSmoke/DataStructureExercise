public class DoublyLinkedList {

    DoublyNode Head;
    int size = 0;

    public boolean isEmpty() {
        return Head == null || size == 0;
    }

    public int getSize() {
        return size;
    }

    public void insertHead(Music newMusic) {
        DoublyNode newNode = new DoublyNode(null, newMusic, null);
        if (isEmpty()) {
            Head = newNode;
        } else {
            Head.setPrev(newNode);
            newNode.setNext(Head);
            Head = newNode;
        }
        size++;
    }

    public void insertTail(Music newMusic) {
        DoublyNode newNode = new DoublyNode(null, newMusic, null);
        if (isEmpty()) {
            insertHead(newMusic);
        } else {
            DoublyNode current = Head;

            while (current.getNext() != null) {
                current = current.getNext();
            }
            newNode.setPrev(current);
            current.setNext(newNode);
            size++;
        }
    }

    public void insertAt(int index, Music newMusic) {
        if (isEmpty() || index == 1) {
            insertHead(newMusic);
        } else if (Head.getNext() == null) {
            insertTail(newMusic);
        } else if (index > size) {
            insertTail(newMusic);
        } else {
            DoublyNode current = Head;
            DoublyNode newNode = new DoublyNode(null, newMusic, null);

            for (int i = 1; i < index - 1; i++) {
                current = current.getNext();
            }

            newNode.setPrev(current);
            newNode.setNext(current.getNext());
            current.getNext().setPrev(newNode);
            current.setNext(newNode);
            size++;

        }
    }

    public void removeHead() {
        if (isEmpty()) {
            System.out.println("Empty");
        } else if (Head.getNext() == null) {
            Head = null;
            size = 0;
        } else {
            Head = Head.getNext();
            Head.setPrev(null);
            size--;
        }
    }

    public void removeTail() {
        if (isEmpty()) {
            System.out.println("Empty");
        } else if (Head.getNext() == null) {
            removeHead();
        } else {
            DoublyNode current = Head;

            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.getPrev().setNext(null);
            current.setPrev(null);
            size--;
        }
    }

    public boolean removeAt(int index) {
        if (isEmpty()) {
            System.out.println("Empty");
            return false;
        } else if (getSize() == 1 || index == 1) {
            removeHead();
        } else if (index == size) {
            removeTail();
        } else {
            DoublyNode current = Head;

            for (int i = 1; i < index - 1; i++) {
                current = current.getNext();
            }

            current.getNext().getNext().setPrev(current);
            current.setNext(current.getNext().getNext());
            size--;

        }

        return true;
    }

    public void peekHead() {
        if (isEmpty()) {
            System.out.println("Empty");
        } else {
            System.out.println(Head);
        }
    }

    public void peekTail() {
        if (isEmpty()) {
            System.out.println("Empty");
        } else if (Head.getNext() == null) {
            peekHead();
        } else {
            DoublyNode current = Head;

            while (current.getNext() != null) {
                current = current.getNext();
            }
            System.out.println(current);
        }
    }

    public void displayAll() {
        if (isEmpty()) {
            System.out.println("Empty");
        } else if (Head.getNext() == null) {
            peekHead();
        } else {
            DoublyNode current = Head;

            for (int i = 0; i <= size - 1; i++) {
                System.out.println(current);
                current = current.getNext();
            }

        }
    }

}