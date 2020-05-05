public enum ermegencyCases {
    Coronavirus, Gunshot, Migraine, Coughing, Other
}

public class PriorityResturaunt {

    public int initCapacity() {
        int capacity = 0;
        while (capacity <= 0 || capacity > 15) {
            System.out.print("Please Enter Capacity Of Hospital Ermegency: ");
            capacity = InputMethods.getInt();
        }
        return capacity;
    }

    public int mainMenu() {
        int menuOption = 0;
        while (menuOption <= 0 || menuOption > 4) {
            System.out.println("*** Emergency Room ***\n");
            System.out.println("1. Add To Emergency List");
            System.out.println("2. Attend To Next Patient");
            System.out.println("3. View Options");
            System.out.println("4. Close");
            System.out.print("\nAction: ");
            menuOption = InputMethods.getInt();
            System.out.println("");
        }
        return menuOption;
    }

    public void addNewPatient() {
        System.out.println("*** Add New Patient ***\n");
        System.out.print("Enter Patient Name: ");
        String patientName = InputMethods.getString();
        String patientCase = getErmegency().toString();
        int patientPriority = determinePriority(patientCase);
    }

    public ermegencyCases getErmegency() {
        int ermegencyPick = 0;
        while (ermegencyPick <= 0 || ermegencyPick > 5) {
            System.out.println("\n                  Emergency Cases");
            System.out.println("Note: CORONVAVIRUS CASES ARE TOP PRIORITY AT THE MOMENT!!!");
            ermegencyOptions();
            ermegencyPick = InputMethods.getInt();
        }
        return ermegencyCases.values()[ermegencyPick - 1];
    }

    public void ermegencyOptions() {
        for (ermegencyCases display : ermegencyCases.values()) {
            System.out.println(i + ". " + display);
        }
        System.out.print("ermegency(1 - 5): ");
    }

    public int determinePriority(String patientCase) {
        int priorityNumber = 0;
        if (patientCase.equals(ermegencyCases.Coronavirus.toString())) {
            System.out.println("\nYou have been moved to our top priority list!\n");
            priorityNumber = 1;
        } else if (patientCase.equals(ermegencyCases.Gunshot.toString())) {
            System.out.println("\nYou will be addressed after our Coronavirus patient..please don't die!\n");
            priorityNumber = 2;
        } else if (patientCase.equals(ermegencyCases.Migraine.toString())) {
            System.out.println("\nYou will be addressed after soon shortly\n");
            priorityNumber = 3;
        } else if (patientCase.equals(ermegencyCases.Other.toString())) {
            System.out.println("\nYou will be addressed after out Coronavirus patient..please don't die!\n");
            priorityNumber = 5;
        } else {
            System.out.println("We will attend to you momentarily, take a seat");
            priorityNumber = 4;
        }

        return priorityNumber;

    }
}