package model;

public class Booking {
    private static int bookingCounter = 0; //to generate unique booking IDs
    private int bookingId;
    private Patient patient;
    private Physiotherapist physiotherapist;
    private Treatment treatment;
    private AppointmentStatus status;

    // Constructor
    public Booking(Patient patient, Physiotherapist physiotherapist, Treatment treatment) {
        this.bookingId = ++bookingCounter;
        this.patient = patient;
        this.physiotherapist = physiotherapist;
        this.treatment = treatment;
        this.status = AppointmentStatus.BOOKED;
        this.treatment.setStatus(AppointmentStatus.BOOKED); 
    }

    // Getters and Setters
    public int getBookingId() {
        return bookingId;
    }

    public Patient getPatient() {
        return patient;
    }

    public Physiotherapist getPhysiotherapist() {
        return physiotherapist;
    }

    public Treatment getTreatment() {
        return treatment;
    }

    public AppointmentStatus getStatus() {
        return status;
    }

    public void setStatus(AppointmentStatus status) {
        this.status = status;
    }

    public void cancel() {
        this.status = AppointmentStatus.CANCELLED;
        this.treatment.setStatus(AppointmentStatus.AVAILABLE); 
    }

    public void attend() {
        this.status = AppointmentStatus.ATTENDED;
        this.treatment.setStatus(AppointmentStatus.ATTENDED); 
    }
}
