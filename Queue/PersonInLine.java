public class PersonInLine {
    private String guestName;
    private int guestSize;
    private int guestPriority;

    public PersonInLine() {
    }

    public PersonInLine(String guestName, int guestSize) {
        this.guestName = guestName;
        this.guestSize = guestSize;
        this.guestPriority = 0;
    }

    public void setGuestName(String guestName) {
        this.guestName = guestName;
    }

    public String getGuestName() {
        return guestName;
    }

    public void setGuestSize(int guestSize) {
        this.guestSize = guestSize;
    }

    public int getGuestSize() {
        return guestSize;
    }

    public void setPriority(int priority) {
        this.guestPriority = priority;
    }

    public int getPriority() {
        return guestPriority;
    }

    public String toString() {
        return "Guest Name: " + guestName + "\n" + "Table For  " + guestSize + "\n";
    }
}