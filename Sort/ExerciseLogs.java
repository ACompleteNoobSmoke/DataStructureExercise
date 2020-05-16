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
        System.out.print("Current Weight: ");
        double currentWeight = 0;
        while(currentWeight <= 0 || )
    }

    public int menu() {
        System.out.println("*** Main Menu ***");
        System.out.println()
    }
}