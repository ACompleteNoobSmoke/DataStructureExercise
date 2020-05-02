public class DequeNode {

    private DequeNode next;
    private DequeNode prev;
    carRegister newCar;

    public DequeNode(carRegister newCar) {
        this.prev = null;
        this.newCar = newCar;
        this.next = null;
    }

    public DequeNode(DequeNode prev, carRegister newCar, DequeNode next) {
        this.prev = prev;
        this.newCar = newCar;
        this.next = next;
    }

    public DequeNode() {
        this.prev = null;
        this.newCar = null;
        this.next = null;
    }

    public void setPrev(DequeNode prev) {
        this.prev = prev;
    }

    public DequeNode getPrev() {
        return prev;
    }

    public void setCarRegister(carRegister newCar) {
        this.newCar = newCar;
    }

    public carRegister getCarRegister() {
        return newCar;
    }

    public void setNext(DequeNode next) {
        this.next = next;
    }

    public DequeNode getNext() {
        return next;
    }

    public String toString() {
        return newCar.toString();
    }

}