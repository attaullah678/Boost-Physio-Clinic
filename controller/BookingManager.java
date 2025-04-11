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
                    booking.cancel(); // Optional: mark as cancelled before removing
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
    
    
}
