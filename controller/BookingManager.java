package controller;

import model.*;
import java.util.*;

public class BookingManager {
    private List<Patient> patients;
    private List<Physiotherapist> physiotherapists;
    private List<Booking> bookings;

    public BookingManager() {
        this.patients = new ArrayList<>();
        this.physiotherapists = new ArrayList<>();
        this.bookings = new ArrayList<>();
    }

    public List<Patient> getPatients() {
        return patients;
    }
    
    public List<Physiotherapist> getPhysiotherapists(){
        return physiotherapists;
    }

    public List<Booking> getBookings() {
        return bookings;
    }

    public void addPhysiotherapist(Physiotherapist physiotherapist) {
        physiotherapists.add(physiotherapist);
    }
    
    public void addPatient(Patient patient) {
        patients.add(patient);
    }

    public boolean removePatient(int patientId) {
        Patient patientToRemove = null;

        for (Patient p : patients) {
            if (p.getId() == patientId) {
                patientToRemove = p;
                break;
            }
        }

        if (patientToRemove != null) {
            bookings.removeIf(booking -> {
                if (booking.getPatient().getId() == patientId) {
                    booking.cancel(); 
                    return true;
                }
                return false;
            });

            patients.remove(patientToRemove);
            System.out.println("Patient with ID " + patientId + " has been removed.");
            return true;
        } else {
            System.out.println("Patient with ID " + patientId + " not found.");
            return false;
        }
    }

    

    public Booking bookAppointment(Patient patient, Physiotherapist physiotherapist, Treatment treatment) {
        if (treatment.getStatus() != AppointmentStatus.AVAILABLE) {
            System.out.println("Treatment already booked.");
            return null;
        }

        for (Booking booking : bookings) {
            if (booking.getPatient().equals(patient) &&
                booking.getTreatment().getDateTime().equals(treatment.getDateTime()) &&
                booking.getStatus() != AppointmentStatus.CANCELLED) {
                System.out.println("Patient has a time conflict with another appointment!");
                return null;
            }
        }

        Booking booking = new Booking(patient, physiotherapist, treatment);
        bookings.add(booking);
        System.out.println("Appointment booked successfully with booking ID: " + booking.getBookingId());
        return booking;
    }

    
    
}
