package controller;

import model.*;
import java.util.*;

public class BookingManager {
    private List<Booking> bookings;
    private List<Patient> patients;
    private Map<Integer, Integer> physiotherapistAttendance = new HashMap<>();


    public BookingManager() {
        bookings = new ArrayList<>();
        patients = new ArrayList<>();
    }

    public void bookAppointment(Booking booking) {
        bookings.add(booking);
    }

    public List<Booking> getBookings() {
        return bookings;
    }
    
}
