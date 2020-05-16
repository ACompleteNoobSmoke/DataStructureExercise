public class WeightWatchers {

    private String exercise;
    private double caloriesLost;
    private double currentWeight;
    private double goalWeight;

    public WeightWatchers() {
    }

    public WeightWatchers(String exercise, double caloriesLost, double currentWeight, double goalWeight) {
        this.exercise = exercise;
        this.caloriesLost = caloriesLost;
        this.currentWeight = currentWeight;
        this.goalWeight = goalWeight;
    }

    public String getExercise() {
        return exercise;
    }

    public void setExercise(String exercise) {
        this.exercise = exercise;
    }

    public double getCaloriesLost() {
        return caloriesLost;
    }

    public void setCaloriesLost(double caloriesLost) {
        this.caloriesLost = caloriesLost;
    }

    public double getCurrentWeight() {
        return currentWeight;
    }

    public void setCurrentWeight(double currentWeight) {
        this.currentWeight = currentWeight;
    }

    public double getGoalWeight() {
        return goalWeight;
    }

    public void setGoalWeight(double goalWeight) {
        this.goalWeight = goalWeight;
    }

    public void header() {
        String n = String.format("%7s %9s %15s %15s %10s %10s %10s", "Exercise", "|", "Calories Burned", "|",
                "Current Weight", "|", "Goal Weight");
        String lines = "__________________________________________________________________________________________";
        System.out.println(n + "\n" + lines);
    }

    public String toString() {
        return String.format("%8s %8s %20s %10s %13s %7s %9s", exercise, "|", caloriesLost, "|", currentWeight, "|",
                goalWeight);
    }

}