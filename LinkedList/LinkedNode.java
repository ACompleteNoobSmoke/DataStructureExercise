public class LinkedNode {

    private String title;
    private int year;
    private LinkedNode nextNode;

    public LinkedNode(String title, int year, LinkedNode nextNode) {
        this.title = title;
        this.year = year;
        this.nextNode = nextNode;
    }

    public void setNext(LinkedNode nextNode) {
        this.nextNode = nextNode;
    }

    public LinkedNode getNext() {
        return nextNode;
    }

    public String toString() {
        return "Title: " + title + "\n" + "Released: " + year;
    }

}