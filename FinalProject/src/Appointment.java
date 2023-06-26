import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Appointment {
    private static DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    private LocalDateTime dateTime;
    private Patient patient;
    private Therapist therapist;

    public Appointment(Patient patient, Therapist therapist, LocalDateTime dateTime) {
        this.patient = patient;
        this.therapist = therapist;
        this.dateTime = dateTime;
    }

    //Getters
    public LocalDateTime getDateTime() {
        return dateTime;
    }
    public Patient getPatient() {
        return patient;
    }
    public Therapist getTherapist() {
        return therapist;
    }


    // Setters
    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public void setTherapist(Therapist therapist) {
        this.therapist = therapist;
    }

    public String toString() {
        return "Appointment{" +
                "dateTime=" + dateTime.format(dateTimeFormatter) +
                ", patient=" + patient.getName() +
                ", therapist=" + therapist.getName() +
                ", Patient Need=" + patient.getSpecialty().getName() +
                '}';
    }
}

