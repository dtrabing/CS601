public class Patient {
    private String name;
    private Specialty specialty;

    public Patient(String name, Specialty specialty) {
        this.name = name;
        this.specialty = specialty;
    }

    //Getters
    public String getName() {
        return name;
    }

    public Specialty getSpecialty() {
        return specialty;
    }

}
