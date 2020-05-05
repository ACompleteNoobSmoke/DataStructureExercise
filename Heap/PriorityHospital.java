
public class PriorityHospital {

    static MinHeap newMinHeap;

    public PriorityHospital(int capacity) {
        newMinHeap = new MinHeap(capacity);
    }

    public int mainMenu() {
        int menuOption = 0;
        while (menuOption <= 0 || menuOption > 5) {
            System.out.println("*** EMERGENCY ROOM ***\n");
            System.out.println("1. Add To Emergency List");
            System.out.println("2. Attend To Next Patient");
            System.out.println("3. Search Patient");
            System.out.println("4. View Options");
            System.out.println("5. Close");
            System.out.print("\nAction: ");
            menuOption = InputMethods.getInt();
            System.out.println("");
        }
        return menuOption;
    }

    public void switchCases() {
        int pick = mainMenu();
        switch (pick) {
            case 1:
                addNewPatient();
                break;
            case 2:
                attendNextCase();
                break;
            case 3:
                searchPatient();
                break;
            case 4:
                viewings();
                break;
            case 5:
                closeProgram();
                break;
        }
    }

    public void addNewPatient() {
        System.out.println("*** ADD NEW PATIENT ***\n");
        System.out.print("Enter Patient Name: ");
        String patientName = InputMethods.getString();
        String patientCase = getEmergency().toString();
        int patientPriority = determinePriority(patientCase.toString());
        PatientInLine newPatientInLine = new PatientInLine(patientName, patientCase, patientPriority);
        newMinHeap.add(newPatientInLine);

    }

    public emergencyCases getEmergency() {
        int emergencyPick = 0;
        while (emergencyPick <= 0 || emergencyPick > 5) {
            System.out.println("\n                  Emergency Cases");
            System.out.println("Note: CORONVAVIRUS CASES ARE TOP PRIORITY AT THE MOMENT!!!\n");
            emergencyOptions();
            emergencyPick = InputMethods.getInt();
        }
        return emergencyCases.values()[emergencyPick - 1];
    }

    public void emergencyOptions() {
        int i = 0;
        for (emergencyCases display : emergencyCases.values()) {
            System.out.println(++i + ". " + display);
        }
        System.out.print("\nEmergency (1 - 5): ");
    }

    public int determinePriority(String patientCase) {
        int priorityNumber = 0;
        if (patientCase.equals(emergencyCases.Coronavirus.toString())) {
            System.out.println("\nYou have been moved to our top priority list!\n");
            priorityNumber = 1;
        } else if (patientCase.equals(emergencyCases.Gunshot.toString())) {
            System.out.println("\nYou will be addressed after our Coronavirus patient..please don't die!\n");
            priorityNumber = 2;
        } else if (patientCase.equals(emergencyCases.Migraine.toString())) {
            System.out.println("\nYou will be addressed after soon shortly\n");
            priorityNumber = 3;
        } else {
            System.out.println("We will attend to you momentarily, take a seat");
            priorityNumber = 4;
        }
        return priorityNumber;
    }

    public int viewOptionsMenu() {
        int viewPick = 0;
        while (viewPick <= 0 || viewPick > 7) {
            System.out.println("*** VIEWING OPTIONS ***\n");
            System.out.println("1. View EMERGENT LEVEL Patients");
            System.out.println("2. View URGENT LEVEL Patients");
            System.out.println("3. View MILD LEVEL Patients");
            System.out.println("4. View SAFE LEVEL Patients");
            System.out.println("5. View Next On Patient List");
            System.out.println("6. View All Patients");
            System.out.println("7. Back");
            System.out.print("\nAction: ");
            viewPick = InputMethods.getInt();
        }
        return viewPick;
    }

    public void viewings() {
        int viewingChoice = viewOptionsMenu();

        if (viewingChoice <= 4) {
            String emergencyLevel = emergencyCases.values()[viewingChoice - 1].toString();
            viewEmergencyLevel(viewingChoice);
        } else if (viewingChoice == 5) {
            viewNextPatient();
        } else if (viewingChoice == 6) {
            viewAllCases();
        }
        System.out.println("\nPress Anything To Continue!\n");
        InputMethods.getScan().nextLine();
    }

    public void viewEmergencyLevel(int viewingChoice) {
        String title = Lvl.values()[viewingChoice - 1].toString();
        System.out.printf("*** %s LEVEL PATIENTS ***\n", title.toUpperCase());
        if (newMinHeap.isEmpty()) {
            System.out.println("\nCurrently No Cases\n");
            return;
        }

        PatientInLine[] emergentArray = newMinHeap.getPatientArray();

        for (int i = 0; i < newMinHeap.getSize(); i++) {
            if (emergentArray[i].getEmergencyLVL().equalsIgnoreCase(title)) {
                System.out.println(emergentArray[i]);
            }
        }
        System.out.println("");
    }

    public void viewNextPatient() {
        System.out.println("*** VIEW NEXT PATIENT ***\n");
        PatientInLine viewPatient = newMinHeap.peek();
        System.out.println(viewPatient == null ? "Currently No Cases" : viewPatient);
        System.out.println("");
    }

    public void viewAllCases() {
        System.out.println("*** ALL PATIENTS ***\n");
        if (newMinHeap.isEmpty()) {
            System.out.println("Currently No Cases\n");
            return;
        }

        PatientInLine[] emergentArray = newMinHeap.getPatientArray();

        for (PatientInLine viewPatient : emergentArray) {
            if (viewPatient != null)
                System.out.println(viewPatient);
        }
        System.out.println("");
    }

    public void attendNextCase() {
        System.out.println("*** ATTENDING NEXT CASE ***\n");
        if (newMinHeap.isEmpty()) {
            System.out.println("Currently No Cases\n");
            return;
        }

        System.out.println("Now Accepting\n");
        System.out.println(newMinHeap.poll());
        System.out.println("");
    }

    public void searchPatient() {
        System.out.println("*** SEARCH PATIENT ***\n");
        System.out.print("Enter Patient's Name: ");
        String searchName = InputMethods.getString();
        PatientInLine foundPatient = newMinHeap.search(searchName);
        System.out.println(foundPatient == null ? "Patient Not Found" : foundPatient);
        System.out.println("");
    }

    public void closeProgram() {
        System.out.println("Hospital Is No Longer Accepting Any Patients At This Time");
        System.out.println("Have A Great Day And Please Be Careful!!");
        InputMethods.closeInputScanner();
        System.exit(0);
    }

    public static void main(String[] args) {
        int capacity = 0;
        while (capacity <= 0 || capacity > 15) {
            System.out.print("Please Enter Initial Capacity Of Hospital Emergency Room: ");
            capacity = InputMethods.getInt();
        }
        PriorityHospital pHospital = new PriorityHospital(capacity);
        while (true) {
            pHospital.switchCases();
        }
    }
}