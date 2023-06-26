public class Therapist {
    private int ID;
    private String name;
    private Specialty specialty;

    public Therapist(int ID, String name, Specialty specialty) {
        this.name = name;
        this.specialty = specialty;
    }

    //Getters
    public int getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public Specialty getSpecialty() {
        return specialty;
    }


}