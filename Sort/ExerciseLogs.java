public class ExerciseLogs {

    public Profile newProfile() {
        System.out.println("*** New Profile ***");
        System.out.print("Enter Name: ");
        String name = InputMethods.getString();
        int age = 0;
        while (age <= 0 || age > 99) {
            System.out.print("Enter Age: ");
            age = InputMethods.getInt();
        }
        System.out.print("Enter Gender(M/F): ");
        String gender = InputMethods.getString();
        Profile newProfile = new Profile(name, age, gender);
        return newProfile;
    }

    public void createPlan(Profile profile) {
        System.out.println("*** Create Plan ***");
        double currentWeight = 0;
        while (currentWeight <= 0 || currentWeight >= 1000) {
            System.out.print("Current Weight: ");
            currentWeight = InputMethods.getDouble();
        }
        double goalWeight = 0;
        while (goalWeight <= 0 || goalWeight >= currentWeight) {
            System.out.print("Goal Weight: ");
            goalWeight = InputMethods.getDouble();
        }

        int weeks = getWeeks();
        int plannedExercises = weeks * 3;
        profile.setExercises(plannedExercises);
        WeightWatchers newPlan = new WeightWatchers();
        newPlan.setCurrentWeight(currentWeight);
        newPlan.setGoalWeight(goalWeight);
        profile.saveExerciseLog(0, newPlan);
        System.out.println("Planned Saved!!\n");
    }

    public int getWeeks() {
        int weeks = 0;
        while (weeks <= 0 || weeks > 4) {
            System.out.println("Duration Of Plan");
            System.out.println("1. 3 Weeks");
            System.out.println("2. 6 Weeks");
            System.out.println("3. 9 Weeks");
            System.out.println("4. 12 Weeks");
            weeks = InputMethods.getInt();
        }
        return weeks;
    }

    public int menu(Profile profile) {
        int pick = 0;
        while (pick <= 0 || pick > 4) {
            System.out.println("*** Main Menu ***");
            profile.profileMenu();
            System.out.println("1. View Plan");
            System.out.println("2. New Log");
            System.out.println("3. View Logs");
            System.out.println("4. Exit");
            pick = InputMethods.getInt();
        }
        return pick;
    }

}