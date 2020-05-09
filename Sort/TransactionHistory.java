public class TransactionHistory {

    private String locationSpent;
    private double totalAmount;
    private double cashSpent;
    private double currentAmount;

    public TransactionHistory(String location, double spent, double current, double total) {
        this.locationSpent = location;
        this.totalAmount = total;
        this.cashSpent = spent;
        this.currentAmount = current;
    }

    public TransactionHistory() {
    }

    public boolean broke() {
        return currentAmount == 0;
    }

    public boolean emptyAccount() {
        return totalAmount == 0;
    }

    public void setLocation(String location) {
        this.locationSpent = location;
    }

    public String getLocation() {
        return locationSpent;
    }

    public void setTotal(double total) {
        this.totalAmount = total;
    }

    public double getTotal() {
        return totalAmount;
    }

    public void setCashSpent(double cashSpent) {
        this.cashSpent = cashSpent;
    }

    public double getCashSpent() {
        return cashSpent;
    }

    public void setCurrentCash(double currentCash) {
        this.currentAmount = currentCash;
    }

    public double getCurrentCash() {
        return currentAmount;
    }

    public void header() {
        String n = String.format("%7s %9s %15s %15s %10s %10s %10s", "Detail", "|", "Amount Withdrawn", "|",
                "Current Balance", "|", "Balance Limit");
        String lines = "__________________________________________________________________________________________";
        System.out.println(n + "\n" + lines);
    }

    // Details Quick Student Information For The List Of Students
    public String printAll() {
        return String.format("%8s %8s %20s %10s %13s %7s %9s", locationSpent, "|", "-$", cashSpent, "|", "$",
                currentAmount, "|", "-$", totalAmount);
    }

}