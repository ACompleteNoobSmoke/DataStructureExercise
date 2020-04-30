public class DoublyNode {

    private Music newMusic;
    private DoublyNode prev;
    private DoublyNode next;

    public DoublyNode(DoublyNode prev, Music newMusic, DoublyNode next) {
        this.prev = prev;
        this.newMusic = newMusic;
        this.next = next;
    }

    public void setPrev(DoublyNode prev) {
        this.prev = prev;
    }

    public DoublyNode getPrev() {
        return prev;
    }

    public void setNext(DoublyNode next) {
        this.next = next;
    }

    public DoublyNode getNext() {
        return next;
    }

    public String toString() {
        return newMusic.toString();
    }
}