
public class Deque {

    DequeNode Head;
    DequeNode Tail;
    private int size;

    public Deque() {
        size = 0;
        Head = new DequeNode();
        Tail = new DequeNode();
        Head.setNext(Tail);
        Tail.setPrev(Head);
    }

    public void increaseSize() {
        size++;
    }

    public void decreaseSize() {
        size--;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return Head.getNext() == Tail && Tail.getPrev() == Head;
    }

    public void addFront(carRegister newCar) {
        DequeNode dn = new DequeNode(newCar);
        if (isEmpty()) {
            dn.setPrev(Head);
            dn.setNext(Tail);
            Head.setNext(dn);
            Tail.setPrev(dn);
        } else {
            dn.setPrev(Head);
            dn.setNext(Head.getNext());
            Head.setNext(dn);
        }
        increaseSize();
    }

    public void addRear(carRegister newCar) {
        DequeNode dn = new DequeNode(newCar);
        if (isEmpty()) {
            addFront(newCar);
        } else {
            dn.setPrev(Tail.getPrev());
            dn.setNext(Tail);
            Tail.getPrev().setNext(dn);
            Tail.setPrev(dn);
        }
        increaseSize();
    }

    public void removeFront() {
        if (isEmpty()) {
            System.out.println("Empty");
        } else if (Head.getNext().getNext() == Tail) {
            size = 0;
            Tail.setPrev(Head);
            Head.setNext(Tail);
        } else {
            Head.setNext(Head.getNext().getNext());
            Head.getNext().setPrev(Head);
            decreaseSize();
        }
    }

    public void removeRear() {
        if (isEmpty()) {
            System.out.println("Empty");
        } else if (Tail.getPrev().getPrev() == Head) {
            size = 0;
            Head.setNext(Tail);
            Tail.setPrev(Head);
            decreaseSize();
        } else {
            Tail.setPrev(Tail.getPrev().getPrev());
            Tail.getPrev().setNext(Tail);
            decreaseSize();
        }
    }

    public DequeNode peekFront() {
        DequeNode seeFirst = null;
        if (!isEmpty()) {
            seeFirst = Head.getNext();
        }
        return seeFirst;
    }

    public DequeNode peekLast() {
        DequeNode seeLast = null;
        if (!isEmpty()) {
            seeLast = Tail.getPrev();
        }
        return seeLast;
    }

    public void printAll() {
        if (!isEmpty()) {
            DequeNode current = Head.getNext();

            while (current.getNext() != Tail) {
                System.out.println(current);
                current = current.getNext();
            }
            System.out.println(current);
        }
    }

}
