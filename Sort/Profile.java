public class Profile {
    private String name;
    private int age;
    private String gender;
    private WeightWatchers[] exercises;

    public Profile(String name, int age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public WeightWatchers[] getExercises() {
        return exercises;
    }

    public void setExercises(int plannedExercise) {
        exercises = new WeightWatchers[plannedExercise];
    }

    public void saveExerciseLog(int newAmount, WeightWatchers newLog) {
        exercises[newAmount] = newLog;
    }

    public String profileMenu() {
        return "Name: " + name + " || Current Weight: " + exercises[0].getCurrentWeight() + "lbs || Goal Weight: "
                + exercises[0].getCurrentWeight() + "lbs\n";

    }

}