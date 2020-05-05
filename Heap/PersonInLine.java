public class PersonInLine {
    private String patientName;
    private String patientProblem;
    private int patientPriority;

    public PersonInLine() {
    }

    public PersonInLine(String patientName, String patientProblem) {
        this.patientName = patientName;
        this.patientProblem = patientProblem;
        this.patientPriority = 0;
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

    public String toString() {
        return "patient Name: " + patientName + "\n" + "Patient Case:   " + patientProblem + "\n";
    }
}