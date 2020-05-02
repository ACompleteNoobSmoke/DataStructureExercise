public class carRegister {

    private String name;
    private String carModel;
    private int carYear;
    private String procedure;

    public carRegister(String name, String carModel, int carYear, String procedure) {
        this.name = name;
        this.carModel = carModel;
        this.carYear = carYear;
        this.procedure = procedure;
    }

    public String toString() {
        return "Name: " + name + "\n" + "Vehicle Model: " + carModel + "\n" + "Vehicle Year: " + carYear + "\n"
                + "Reason: " + procedure + "\n\n";
    }
}