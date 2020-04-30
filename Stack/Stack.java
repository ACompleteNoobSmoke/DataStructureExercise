public class Stack {

    private int capicity;
    private int size;
    Books[] bookStack;

    public Stack(int capicity) {
        this.capicity = capicity;
        bookStack = new Books[capicity];
        this.size = 0;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getSize() {
        return size;
    }

    public void setCapicity(int newCap) {
        this.capicity = newCap;
    }

    public int getCapicity() {
        return capicity;
    }

    public boolean isEmpty() {
        return getSize() == 0;
    }

    public boolean isFull() {
        return getSize() == getCapicity();
    }

    public void push(Books newBook) {
        if (!isFull()) {
            bookStack[getSize()] = newBook;
            setSize(getSize() + 1);
        }
    }

    public Books pop() {
        Books removedBook = null;
        if (!isEmpty()) {
            removedBook = bookStack[getSize() - 1];
            setSize(getSize() - 1);
        }
        return removedBook;
    }

    public void peek() {
        if (!isEmpty()) {
            Books show = bookStack[getSize() - 1];
            System.out.println(show);
        } else {
            System.out.println("Empty");
        }
    }

    public void printAll() {
        if (!isEmpty()) {
            for (int i = getSize() - 1; i >= 0; i--) {
                System.out.println(bookStack[i]);
            }
        } else {
            System.out.println("Empty");
        }
    }

    public void expand(int newSize) {
        Books[] newBookStack = new Books[getCapicity() + newSize];
        for (int i = 0; i < getSize(); i++) {
            newBookStack[i] = bookStack[i];
        }
        bookStack = newBookStack;
        setCapicity(getCapicity() + newSize);
    }
}