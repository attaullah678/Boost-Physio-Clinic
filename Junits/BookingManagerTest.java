package Junits;

import controller.BookingManager;
import model.Patient;
import model.Treatment;
import model.Booking;
import model.Physiotherapist;
import model.AppointmentStatus;

import org.junit.jupiter.api.*;


import static org.junit.jupiter.api.Assertions.*;


import java.util.List;

public class BookingManagerTest {

    private BookingManager bookingManager;
    private Patient patient;
    private Physiotherapist physiotherapist;
    private Treatment treatment;

    @BeforeEach
    public void setUp() {
        bookingManager = new BookingManager();

        patient = new Patient("John Doe", "123 Elm Street", "555-1234");
        physiotherapist = new Physiotherapist(1, "Dr. Smith", "456 Oak Avenue", "555-5678", List.of("Physio", "Sports"));
        treatment = new Treatment("Sports Therapy", "Physio", "2025-05-01 10:00");
    }

    @Test
    public void testAddPatient() {
        // test adding a patient
        bookingManager.addPatient(patient);
        assertEquals(1, bookingManager.getPatients().size(), "Patient should be added.");
    }

    @Test
    public void testRemovePatient() {
        // test removing a patient
        bookingManager.addPatient(patient);
        boolean removed = bookingManager.removePatient(patient.getId());
        assertTrue(removed, "Patient should be removed.");
        assertEquals(0, bookingManager.getPatients().size(), "Patient list should be empty.");
    }

    @Test
    public void testBookAppointment() {
        // test booking an appointment
        bookingManager.addPatient(patient);
        bookingManager.addPhysiotherapist(physiotherapist);

        Booking booking = bookingManager.bookAppointment(patient, physiotherapist, treatment);
        assertNotNull(booking, "Booking should be successful.");
        assertEquals(patient, booking.getPatient(), "Patient should match.");
        assertEquals(physiotherapist, booking.getPhysiotherapist(), "Physiotherapist should match.");
    }

    @Test
    public void testChangeBooking() {
        // 1. add a patient and physiotherapist
        bookingManager.addPatient(patient);
        bookingManager.addPhysiotherapist(physiotherapist);

        // 2. book an initial appointment
        Booking booking = bookingManager.bookAppointment(patient, physiotherapist, treatment);

        // 3. create a new treatment to change the booking to
        Treatment newTreatment = new Treatment("Massage Therapy", "Physio", "2025-05-01 14:00");

        // 4. change the booking
        boolean changed = bookingManager.changeBooking(booking.getBookingId(), newTreatment);

        // 5. assert the booking was successfully changed
        assertTrue(changed, "Booking should be changed successfully.");

        // 6. retrieve the updated booking and verify the new treatment
        Booking updatedBooking = bookingManager.findBookingById(booking.getBookingId());

        // 7. assert the updated booking is not null
        assertNotNull(updatedBooking, "Updated booking should not be null.");

        // 8. assert the treatment is the new one
        assertEquals(newTreatment, updatedBooking.getTreatment(), "New treatment should be booked.");
    }

    @Test
    public void testCancelBooking() {
        // test cancelling a booking
        bookingManager.addPatient(patient);
        bookingManager.addPhysiotherapist(physiotherapist);
        Booking booking = bookingManager.bookAppointment(patient, physiotherapist, treatment);

        boolean cancelled = bookingManager.cancelBooking(booking.getBookingId());
        assertTrue(cancelled, "Booking should be cancelled.");
        assertEquals(AppointmentStatus.CANCELLED, booking.getStatus(), "Booking status should be CANCELLED.");
    }

    @Test
    public void testAttendAppointment() {
        // test attending an appointment
        bookingManager.addPatient(patient);
        bookingManager.addPhysiotherapist(physiotherapist);
        Booking booking = bookingManager.bookAppointment(patient, physiotherapist, treatment);

        bookingManager.attendAppointment(booking.getBookingId());
        assertEquals(AppointmentStatus.ATTENDED, booking.getStatus(), "Booking status should be ATTENDED.");
    }

    @Test
    public void testPrintReport() {
        // test printing the report (just for checking output, not a typical test)
        bookingManager.addPatient(patient);
        bookingManager.addPhysiotherapist(physiotherapist);
        bookingManager.bookAppointment(patient, physiotherapist, treatment);

        bookingManager.printReport();
    }
}

