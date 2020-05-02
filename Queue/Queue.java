public class Queue {

    private int capacity;
    private int size;
    PersonInLine[] peopleInLine;

    public Queue(int capacity) {
        this.capacity = capacity;
        size = 0;
        peopleInLine = new PersonInLine[capacity];
    }

    public void setSize(int newSize) {
        this.size = newSize;
    }

    public int getSize() {
        return size;
    }

    public int getCapicity() {
        return capacity;
    }

    public boolean isEmpty() {
        return getSize() == 0;
    }

    public boolean isFull() {
        return getSize() == getCapicity();
    }

    public void enqueue(PersonInLine newPerson) {
        if (!isFull()) {
            peopleInLine[getSize()] = newPerson;
            setSize(getSize() + 1);
        }
    }

    public PersonInLine dequeue() {
        PersonInLine serving = null;
        if (!isEmpty()) {
            serving = peopleInLine[0];
            setSize(getSize() - 1);
        }
        return serving;
    }

    public PersonInLine peekFirst() {
        PersonInLine firstInLine = null;
        if (!isEmpty()) {
            firstInLine = peopleInLine[0];
        }
        return firstInLine;
    }

    public PersonInLine peekLast() {
        PersonInLine lastInLine = null;
        if (!isEmpty()) {
            lastInLine = peopleInLine[getSize() - 1];
        }
        return lastInLine;
    }

    public void peekAll() {
        if (isEmpty()) {
            System.out.println("Empty");
            return;
        }

        for (int i = 0; i < getSize(); i++) {
            System.out.println(peopleInLine[i]);
        }
    }

}