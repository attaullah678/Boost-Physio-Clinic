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

    public boolean changeBooking(int bookingId, Treatment newTreatment) {
        Booking existingBooking = findBookingById(bookingId);
        if (existingBooking != null) {
            existingBooking.getTreatment().setStatus(AppointmentStatus.AVAILABLE);
            existingBooking.setTreatment(newTreatment);
            newTreatment.setStatus(AppointmentStatus.BOOKED); 
    
            return true;
        }
        return false;
    }
    

    public boolean cancelBooking(int bookingId) {
        Booking booking = findBookingById(bookingId);
        if (booking != null) {
            booking.cancel();
            System.out.println("Appointment " + bookingId + " has been cancelled.");
            return true;
        } else {
            System.out.println("Booking ID not found for cancellation.");
            return false;
        }
    }

    public Booking findBookingById(int bookingId) {
        for (Booking booking : bookings) {
            if (booking.getBookingId() == bookingId) {
                return booking;
            }
        }
        return null;
    }
public void attendAppointment(int bookingId) {
        Booking booking = findBookingById(bookingId);
        if (booking != null) {
            booking.attend();
            System.out.println("Appointment " + bookingId + " marked as attended.");
        } else {
            System.out.println("Booking ID not found for attendance.");
        }
    }

    public void printReport() {
        System.out.println("----- Clinic Report -----\n");
    
        for (Physiotherapist physio : physiotherapists) {
            System.out.println("Physiotherapist: " + physio.getName());
            Map<String, List<Treatment>> timetable = physio.getTimetable();
    
            for (String week : timetable.keySet()) {
                System.out.println("  " + week + ":");
                List<Treatment> treatments = timetable.get(week);
    
                for (Treatment treatment : treatments) {
                    String patientName = "None";
                    for (Booking booking : bookings) {
                        if (booking.getTreatment().equals(treatment)) {
                            patientName = booking.getPatient().getName();
                            break;
                        }
                    }
                    System.out.println("    Treatment: " + treatment.getName()
                            + " | Patient: " + patientName
                            + " | Time: " + treatment.getDateTime()
                            + " | Status: " + treatment.getStatus());
                }
            }
            System.out.println();
        }
    
        Map<String, Integer> attendanceCount = new HashMap<>();
        for (Booking booking : bookings) {
            String physioName = booking.getPhysiotherapist().getName();
            if (booking.getStatus() == AppointmentStatus.ATTENDED) {
                attendanceCount.put(physioName, attendanceCount.getOrDefault(physioName, 0) + 1);
            }
        }
    
        System.out.println("----- Physiotherapist Rankings by Attended Appointments -----");
        physiotherapists.sort((p1, p2) -> {
            int count1 = attendanceCount.getOrDefault(p1.getName(), 0);
            int count2 = attendanceCount.getOrDefault(p2.getName(), 0);
            return Integer.compare(count2, count1);
        });
    
        int rank = 1;
        for (Physiotherapist physio : physiotherapists) {
            int count = attendanceCount.getOrDefault(physio.getName(), 0);
            System.out.println(rank + ". " + physio.getName() + " - " + count + " attended");
            rank++;
        }
    }
    

    public Patient getPatientById(int patientId) {
        for (Patient patient : patients) {
            if (patient.getId() == patientId) {
                return patient;
            }
        }
        return null;
    }

    public Physiotherapist getPhysiotherapistById(int physioId) {
        for (Physiotherapist physiotherapist : physiotherapists) {
            if (physiotherapist.getId() == physioId) {
                return physiotherapist;
            }
        }
        return null; 
    }
}
