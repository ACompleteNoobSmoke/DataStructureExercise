public class Students {

    private String name;
    private int id;
    private double gradePercentage;
    private String major;
    private char gradeLetter;
    private String gradeStatus;

    public Students(String name, String major, int id, double gradePercentage, char gradeLetter, String gradeStatus) {
        this.name = name;
        this.id = id;
        this.major = major;
        this.gradePercentage = gradePercentage;
        this.gradeLetter = gradeLetter;
        this.gradeStatus = gradeStatus;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getMajor() {
        return major;
    }

    public void setID(int id) {
        this.id = id;
    }

    public int getID() {
        return id;
    }

    public void setGradePercentage(double gradePercentage) {
        this.gradePercentage = gradePercentage;
    }

    public double getGradePercentage() {
        return gradePercentage;
    }

    public void setGradeLetter(char gradeLetter) {
        this.gradeLetter = gradeLetter;
    }

    public char getGradeLetter() {
        return gradeLetter;
    }

    public void setGradeStatus(String gradeStatus) {
        this.gradeStatus = gradeStatus;
    }

    public String getGradeStatus() {
        return gradeStatus;
    }

    public String toString() {
        return "Name: " + name + "\n" + "ID#: " + id + "\n" + "Major: " + major + "\n" + "Grade(%): " + gradePercentage
                + "%\n" + "Grade(A-F): " + gradeLetter + "\n" + "Status: " + gradeStatus + "\n\n";
    }
}