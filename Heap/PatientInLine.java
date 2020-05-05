
public class PatientInLine {
    private String patientName;
    private String patientProblem;
    private int patientPriority;
    private String emergencyLevel;

    public PatientInLine() {
    }

    public PatientInLine(String patientName, String patientProblem, int patientPriority) {
        this.patientName = patientName;
        this.patientProblem = patientProblem;
        this.patientPriority = patientPriority;
        this.setEmergencyLevel(patientPriority);
        this.emergencyLevel = this.getEmergencyLVL();
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientProblem(String patientProblem) {
        this.patientProblem = patientProblem;
    }

    public String getPatientProblem() {
        return patientProblem;
    }

    public void setPriority(int priority) {
        this.patientPriority = priority;
    }

    public int getPriority() {
        return patientPriority;
    }

    public void setEmergencyLevel(int priorityLevel) {
        String newLevel = "";
        switch (priorityLevel) {
            case 1:
                newLevel = Lvl.EMERGENT.toString();
                break;
            case 2:
                newLevel = Lvl.URGENT.toString();
                break;
            case 3:
                newLevel = Lvl.MILD.toString();
                break;
            case 4:
                newLevel = Lvl.SAFE.toString();
                break;
        }
        this.emergencyLevel = newLevel;
    }

    public String getEmergencyLVL() {
        return emergencyLevel;
    }

    public String toString() {
        return "Patient Name: " + patientName + "\n" + "Patient Case: " + patientProblem + "\n" + "Emergency Status: "
                + emergencyLevel + "\n";
    }
}