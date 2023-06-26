public class Specialty {
    private String name;
    private int appointmentDuration;

    public Specialty(String name, int appointmentDuration) {
        this.name = name;
        this.appointmentDuration = appointmentDuration;
    }

    public String getName() {
        return name;
    }
    public int appointmentDuration() {
        return appointmentDuration;
    }
}