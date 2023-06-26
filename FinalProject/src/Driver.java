import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Driver {
    private List<Therapist> therapistList;
    private List<Patient> patientList;
    private List<Specialty> specialtyList;
    private List<Appointment> appointmentList;
    private List<LocalDateTime> dateTimeList;

    public Driver() {
        specialtyList = new ArrayList<>();
        patientList = new ArrayList<>();
        therapistList = new ArrayList<>();
        appointmentList = new ArrayList<>();
        dateTimeList = new ArrayList<>();
        initializeDateTimes();
        initializeSpecialties();
        initializeTherapists();
        initializePatients();
        initializeAppointments();
    }

    private void initializeDateTimes() {
        LocalDateTime dateTime1 = LocalDateTime.of(2022, 07, 10, 9, 0);


        dateTimeList.add(dateTime1);

    }

    public void initializeSpecialties() {
        // Create specialties
        Specialty specialty1 = new Specialty("Speech Therapy", 30);
        Specialty specialty2 = new Specialty("Occupational Therapy", 60);

        specialtyList.add(specialty1);
        specialtyList.add(specialty2);
    }

    // Create therapists
    private void initializeTherapists() {
        Specialty specialty1 = specialtyList.get(0);
        Specialty specialty2 = specialtyList.get(1);

        Therapist therapist1 = new Therapist(1, "Joanna Trabing", specialty1);
        Therapist therapist2 = new Therapist(2, "Maddy Schmidt", specialty2);
        Therapist therapist3 = new Therapist(3, "Maddy Clays", specialty1);
        Therapist therapist4 = new Therapist(4, "Ryan Karoo", specialty2);
        Therapist therapist5 = new Therapist(5, "Jimmy John", specialty1);
        Therapist therapist6 = new Therapist(6, "Michael Bryant", specialty2);

        therapistList.add(therapist1);
        therapistList.add(therapist2);
        therapistList.add(therapist3);
        therapistList.add(therapist4);
        therapistList.add(therapist5);
        therapistList.add(therapist6);
    }

    // Create Patients
    private void initializePatients() {
        Specialty specialty1 = specialtyList.get(0);
        Specialty specialty2 = specialtyList.get(1);

        Patient patient1 = new Patient("Bill Nye", specialty1);
        Patient patient2 = new Patient("Kevin Garnett", specialty2);
        Patient patient3 = new Patient("Taylor Swift", specialty1);
        Patient patient4 = new Patient("Mario Mario", specialty2);

        patientList.add(patient1);
        patientList.add(patient2);
        patientList.add(patient3);
        patientList.add(patient4);
    }

    private void initializeAppointments() {
        Therapist therapist = therapistList.get(0);
        Patient patient = patientList.get(0);
        LocalDateTime dateTime = dateTimeList.get(0);

        Appointment appointment1 = new Appointment(patient, therapist, dateTime);

        appointmentList.add(appointment1);
    }

    //Getters

    public List<Therapist> getTherapistList(){
        return therapistList;
    }
    public List<Patient> getPatientList(){
        return patientList;
    }

    public List<Specialty> getSpecialtyList(){
        return specialtyList;
    }
    public List<LocalDateTime> getDateTimeList(){
        return dateTimeList;
    }
    public List<Appointment> getAppointmentList(){
        return appointmentList;
    }
}