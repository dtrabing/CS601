import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AppointmentScheduler {
    private static Scanner scanner = new Scanner(System.in);
    private static DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
    private List<Patient> patientList = new ArrayList<>();
    private List<Therapist> therapistList = new ArrayList<>();
    private List<Appointment> appointmentList = new ArrayList<>();
    private List<Specialty> specialtyList;


    //Start of actual Scanner Jobs
    public static void main(String[] args) {
        AppointmentScheduler scheduler = new AppointmentScheduler();
        scheduler.run();
    }
    public void run() {
        System.out.println("Welcome to the Appointment Scheduler");

        // Instantiate Driver and get specialtyList, therapyList and patientList
        Driver driver = new Driver();
        specialtyList = driver.getSpecialtyList();
        therapistList = driver.getTherapistList();
        patientList = driver.getPatientList();
        appointmentList = driver.getAppointmentList();

        while (true) {
            System.out.println("\nSelect an option:");
            System.out.println("1. Create new patient");
            System.out.println("2. Create new appointment");
            System.out.println("3. Get list of Therapists");
            System.out.println("4. Get list of Patients");
            System.out.println("5. Get list of all Appointments");
            System.out.println("0. Exit");

            int choice = readIntInput();

            switch (choice) {
                case 1:
                    createPatient();
                    break;
                case 2:
                    createAppointment();
                    break;
                case 3:
                    displayTherapistList();
                    break;
                case 4:
                    displayPatientList();
                    break;
                case 5:
                    displayAppointmentList();
                    break;
                case 0:
                    System.out.println("Exiting the program. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }
    //Create Patient and Appointment Methods
    private void createPatient() {
        System.out.println("Creating a new patient");
        System.out.print("Enter patient name: ");
        String name = scanner.nextLine();

        System.out.println("Available specialties:");
        displaySpecialtyList();

        System.out.print("Select the patient's specialty (1 or 2): ");
        int specialtyChoice = readIntInput();

        if (specialtyChoice < 1 || specialtyChoice > specialtyList.size()) {
            System.out.println("Invalid specialty choice. Please try again.");
            return;
        }

        Specialty selectedSpecialty = specialtyList.get(specialtyChoice - 1);

        Patient patient = new Patient(name, selectedSpecialty);
        patientList.add(patient);
        System.out.println("Patient created successfully!");
    }
    private void createAppointment() {
        System.out.println("Creating a new appointment");

        System.out.println("Available patients:");
        displayPatientList();

        System.out.print("Enter the index of the patient: ");
        int patientIndex = readIntInput();

        if (patientIndex < 0 || patientIndex >= patientList.size()) {
            System.out.println("Invalid patient index.");
            return;
        }

        System.out.println("Available therapists:");
        displayTherapistList();

        System.out.print("Enter the index of the therapist: ");
        int therapistIndex = readIntInput();

        if (therapistIndex < 0 || therapistIndex >= therapistList.size()) {
            System.out.println("Invalid therapist index.");
            return;
        }

        Patient patient = patientList.get(patientIndex);
        Therapist therapist = therapistList.get(therapistIndex);

        // Check if specialties match
        if (!patient.getSpecialty().equals(therapist.getSpecialty())) {
            System.out.println("Error: The patient's specialty does not match the therapist's specialty.");
            return;
        }


        System.out.print("Enter the date and time (yyyy-MM-dd HH:mm): ");
        String dateTimeStr = scanner.nextLine();

        LocalDateTime dateTime;
        try {
            dateTime = LocalDateTime.parse(dateTimeStr, dateTimeFormatter);
        } catch (Exception e) {
            System.out.println("Invalid date and time format.");
            return;
        }

        Appointment appointment = new Appointment(patient, therapist, dateTime);
        appointmentList.add(appointment);
        System.out.println("Appointment created successfully!");
    }
    //Display different lists
    private void displaySpecialtyList() {
        for (int i = 0; i < specialtyList.size(); i++) {
            System.out.println((i + 1) + ". " + specialtyList.get(i).getName());
        }
    }
    private void displayPatientList() {
        if (patientList.isEmpty()) {
            System.out.println("No patients registered.");
            return;
        }
        for (int i = 0; i < patientList.size(); i++) {
            Patient patient = patientList.get(i);
            System.out.println(i + ". " + patient.getName() + " (" + patient.getSpecialty().getName() + ")");
        }
    }
    private void displayTherapistList() {
        for (int i = 0; i < therapistList.size(); i++) {
            Therapist therapist = therapistList.get(i);
            System.out.println(i + ". " + therapist.getName()+ " (" + therapist.getSpecialty().getName() + ")");
        }
    }
    private void displayAppointmentList() {
        if (appointmentList.isEmpty()) {
            System.out.println("No appointments scheduled.");
            return;
        }
        for (int i = 0; i < appointmentList.size(); i++) {
            Appointment appointment = appointmentList.get(i);
            System.out.println("Patient: " + appointment.getPatient().getName() + " " + "\n" +
                   "Therapist: " + appointment.getTherapist().getName() + "\n" +
                   "Start Time: " +  appointment.getDateTime().getHour() + "\n" +
                    "End Time: " + (appointment.getDateTime().getHour() + .30)+ "\n");
        }
    }

    //Allows for user to select an integer instead of typing in strings when selecting certain fields in the application
    private int readIntInput() {
        int input = -1;
        try {
            input = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a valid integer.");
        }
        return input;
    }
}
