import model.*;
import controller.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        BookingManager manager = new BookingManager();

        Treatment t1 = new Treatment("Swedish Massage", "Massage", "2025-05-01 10:00");
        Treatment t2 = new Treatment("Core Physiotherapy", "Physiotherapy", "2025-05-02 11:00");
        Treatment t3 = new Treatment("Tension Relief Massage", "Massage", "2025-05-08 14:00");
        Treatment t4 = new Treatment("Neuro Muscular Therapy", "Physiotherapy", "2025-05-09 11:00");
        Treatment t5 = new Treatment("Balance Recovery Session", "Rehabilitation", "2025-05-01 12:00");
        Treatment t6 = new Treatment("Surgical Healing Program", "Rehabilitation", "2025-05-07 12:00");
        Treatment t7 = new Treatment("Mobility Enhancer", "Stretching", "2025-05-08 15:00");
        Treatment t8 = new Treatment("Flex Motion Session", "Stretching", "2025-05-15 16:00");
        Treatment t9 = new Treatment("Aquatic Therapy", "Hydrotherapy", "2025-05-02 13:00");
        Treatment t10 = new Treatment("Water Recovery Therapy", "Hydrotherapy", "2025-05-09 13:30");
        Treatment t11 = new Treatment("Soft Tissue Realignment", "Manual Therapy", "2025-05-03 14:00");
        Treatment t12 = new Treatment("Vertebra Adjustment", "Manual Therapy", "2025-05-10 14:00");
        Treatment t13 = new Treatment("Athlete Restoration", "Sports Therapy", "2025-05-04 09:00");
        Treatment t14 = new Treatment("Peak Performance Therapy", "Sports Therapy", "2025-05-11 09:30");
        Treatment t15 = new Treatment("Relaxing Massage Plus", "Massage", "2025-05-16 10:30");
        Treatment t16 = new Treatment("Elite Physio Care", "Physiotherapy", "2025-05-23 11:15");

        Physiotherapist physio1 = new Physiotherapist(1, "Samantha Green", "101 Health St", "1231231234", Arrays.asList("Massage", "Physiotherapy"));
        Physiotherapist physio2 = new Physiotherapist(2, "Thomas Wright", "202 Rehab Lane", "4321432143", Arrays.asList("Rehabilitation", "Stretching"));
        Physiotherapist physio3 = new Physiotherapist(3, "Natalie Brooks", "303 Therapy Blvd", "3456345634", Arrays.asList("Hydrotherapy", "Manual Therapy"));
        Physiotherapist physio4 = new Physiotherapist(4, "Edward Turner", "404 Wellness Rd", "6789678967", Arrays.asList("Sports Therapy", "Massage", "Physiotherapy"));

        
        timetable1.put("Week 1", Arrays.asList(t1, t2));
        timetable1.put("Week 2", Arrays.asList(t3, t4));
        timetable1.put("Week 3", Arrays.asList(t15));
        timetable1.put("Week 4", Arrays.asList(t16));
        physio1.setTimetable(timetable1);

        Map<String, List<Treatment>> timetable2 = new HashMap<>();
        timetable2.put("Week 1", Arrays.asList(t5, t7));
        timetable2.put("Week 2", Arrays.asList(t6, t8));
        timetable2.put("Week 3", Arrays.asList(
            new Treatment("Hip Stability Rehab", "Rehabilitation", "2025-05-16 12:00"),
            new Treatment("Sunrise Stretch", "Stretching", "2025-05-17 08:30")
        ));
        timetable2.put("Week 4", Arrays.asList(
            new Treatment("Spinal Recovery Plan", "Rehabilitation", "2025-05-23 12:00"),
            new Treatment("Stretch Boost", "Stretching", "2025-05-24 09:00")
        ));
        physio2.setTimetable(timetable2);

        Map<String, List<Treatment>> timetable3 = new HashMap<>();
        timetable3.put("Week 1", Arrays.asList(t9, t11));
        timetable3.put("Week 2", Arrays.asList(t10, t12));
        timetable3.put("Week 3", Arrays.asList(
            new Treatment("Aqua Flex Routine", "Hydrotherapy", "2025-05-15 13:00"),
            new Treatment("Neck Relief Technique", "Manual Therapy", "2025-05-15 14:30")
        ));
        timetable3.put("Week 4", Arrays.asList(
            new Treatment("Hydro Core Stability", "Hydrotherapy", "2025-05-22 13:00"),
            new Treatment("Muscle Mobilization", "Manual Therapy", "2025-05-22 15:00")
        ));
        physio3.setTimetable(timetable3);

        Map<String, List<Treatment>> timetable4 = new HashMap<>();
        timetable4.put("Week 1", Arrays.asList(t13));
        timetable4.put("Week 2", Arrays.asList(t14));
        timetable4.put("Week 3", Arrays.asList(
            new Treatment("Energize Massage", "Massage", "2025-05-15 10:00"),
            new Treatment("Dynamic Sports Recovery", "Sports Therapy", "2025-05-15 09:00")
        ));
        timetable4.put("Week 4", Arrays.asList(
            new Treatment("Deep Muscle Massage", "Massage", "2025-05-22 10:00"),
            new Treatment("Elite Athlete Therapy", "Physiotherapy", "2025-05-22 11:30")
        ));
        physio4.setTimetable(timetable4);

        manager.addPhysiotherapist(physio1);
        manager.addPhysiotherapist(physio2);
        manager.addPhysiotherapist(physio3);
        manager.addPhysiotherapist(physio4);

        // PATIENTS
        Patient patient1 = new Patient("Adam Cross", "10 Sycamore St", "1112223333");
        Patient patient2 = new Patient("Beth Nolan", "11 Redwood Ave", "2223334444");
        Patient patient3 = new Patient("Clark Kent", "12 Krypton Lane", "3334445555");
        Patient patient4 = new Patient("Daisy Carter", "13 Blossom Rd", "4445556666");
        Patient patient5 = new Patient("Eli Watson", "14 Orchard Dr", "5556667777");
        Patient patient6 = new Patient("Faith Daniels", "15 Riverbank Ave", "6667778888");
        Patient patient7 = new Patient("Gavin Ross", "16 Cedar Rd", "7778889999");
        Patient patient8 = new Patient("Hailey Brooks", "17 Ash Ln", "8889990000");
        Patient patient9 = new Patient("Ian Parker", "18 Pinehurst Blvd", "9990001111");
        Patient patient10 = new Patient("Jenna Wright", "19 Magnolia Ct", "0001112222");
        Patient patient11 = new Patient("Kevin Tran", "20 Chestnut Way", "1113335555");
        Patient patient12 = new Patient("Lily Thompson", "21 Willow Walk", "2224446666");

        manager.addPatient(patient1);
        manager.addPatient(patient2);
        manager.addPatient(patient3);
        manager.addPatient(patient4);
        manager.addPatient(patient5);
        manager.addPatient(patient6);
        manager.addPatient(patient7);
        manager.addPatient(patient8);
        manager.addPatient(patient9);
        manager.addPatient(patient10);
        manager.addPatient(patient11);
        manager.addPatient(patient12);
        
        Booking booking1 = manager.bookAppointment(patient1, physio1, t1); 
        Booking booking2 = manager.bookAppointment(patient2, physio2, t5); 
        Booking booking3 = manager.bookAppointment(patient3, physio3, t9); 
        Booking booking4 = manager.bookAppointment(patient4, physio4, t13);
        Booking booking5 = manager.bookAppointment(patient5, physio1, t3);

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n\n1. Book an Appointment");
            System.out.println("2. Cancel a Booking");
            System.out.println("3. Change an Appointment");
            System.out.println("4. Attend an Appointment");
            System.out.println("5. Print Report");
            System.out.println("6. Remove a Patient");
            System.out.println("7. Add a Patient");
            System.out.println("8. List Patients");
            System.out.println("9. List Physiotherapists");
            System.out.println("10. List Bookings");

            System.out.println("11. Exit");

            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
System.out.print("Enter Patient ID: ");
                    int patientId = scanner.nextInt();
                    scanner.nextLine();

                    Patient patient = manager.getPatientById(patientId);
                    if (patient == null) {
                        System.out.println("Patient not found.");
                        break;
                    }

                    System.out.print("Book by (1) Expertise or (2) Physiotherapist? Enter 1 or 2: ");
                    int c = scanner.nextInt();
                    scanner.nextLine();

                    Physiotherapist selectedPhysio = null;
                    Treatment selectedTreatment = null;

                    if (c == 1) {
                        // Expertise-based booking
                        Set<String> allExpertise = new HashSet<>();
                        for (Physiotherapist p : manager.getPhysiotherapists()) {
                            allExpertise.addAll(p.getAreasOfExpertise());
                        }

                        System.out.println("Available Expertise:");
                        allExpertise.forEach(System.out::println);

                        System.out.print("Enter expertise: ");
                        String expertise = scanner.nextLine();

                        for (Physiotherapist p : manager.getPhysiotherapists()) {
                            if (p.getAreasOfExpertise().contains(expertise)) {
                                System.out.println("Physio: " + p.getName());
                                for (List<Treatment> treatments : p.getTimetable().values()) {
                                    for (Treatment t : treatments) {
                                        if (t.getStatus() == AppointmentStatus.AVAILABLE) {
                                            System.out.println("  - " + t.getName() + " at " + t.getDateTime());
                                        }
                                    }
                                }
                            }
                        }

                        System.out.print("Enter Physiotherapist Name: ");
                        String physioName = scanner.nextLine();
                        selectedPhysio = manager.getPhysiotherapists().stream()
                            .filter(p -> p.getName().equalsIgnoreCase(physioName))
                            .findFirst().orElse(null);

                    } else if (c == 2) {
                        // Physiotherapist-based booking
                        System.out.println("Available Physiotherapists:");
                        for (Physiotherapist p : manager.getPhysiotherapists()) {
                            System.out.println(p.getId() + " - " + p.getName());
                        }

                        System.out.print("Enter Physiotherapist ID: ");
                        int physioId = scanner.nextInt();
                        scanner.nextLine();
                        selectedPhysio = manager.getPhysiotherapistById(physioId);
                    }

                    if (selectedPhysio == null) {
                        System.out.println("Physiotherapist not found.");
                        break;
                    }

                    System.out.println("Available Treatments:");
                    for (List<Treatment> treatments : selectedPhysio.getTimetable().values()) {
                        for (Treatment t : treatments) {
                            if (t.getStatus() == AppointmentStatus.AVAILABLE) {
                                System.out.println("  - " + t.getName() + " at " + t.getDateTime());
                            }
                        }
                    }

                    System.out.print("Enter Treatment Name: ");
                    String treatmentName = scanner.nextLine();

                    for (List<Treatment> treatments : selectedPhysio.getTimetable().values()) {
                        for (Treatment t : treatments) {
                            if (t.getName().equalsIgnoreCase(treatmentName) && t.getStatus() == AppointmentStatus.AVAILABLE) {
                                selectedTreatment = t;
                                break;
                            }
                        }
                        if (selectedTreatment != null) break;
                    }

                    if (selectedTreatment == null) {
                        System.out.println("No available treatment found with that name.");
                        break;
                    }

                    manager.bookAppointment(patient, selectedPhysio, selectedTreatment);
                    break;
                case 2:
                    System.out.print("under construction");
                case 3:
                    System.out.print("under construction");
                case 4:
                    System.out.print("under construction");
                case 5:
                    System.out.print("under construction");
                case 6:
                    System.out.print("Enter Patient ID to remove: ");
                    int patientIdRemove = scanner.nextInt();
                    scanner.nextLine();
                    if (manager.removePatient(patientIdRemove)) {
                        System.out.println("Patient removed successfully!");
                    } else {
                        System.out.println("Patient removal failed.");
                    }
                    break;

                case 7:
                    System.out.print("Enter Patient Name: ");
                    String newPatientName = scanner.nextLine();
                
                    System.out.print("Enter Patient Address: ");
                    String newPatientAddress = scanner.nextLine();
                
                    System.out.print("Enter Patient Phone: ");
                    String newPatientPhone = scanner.nextLine();
                
                    Patient newPatient = new Patient(newPatientName, newPatientAddress, newPatientPhone);
                    manager.addPatient(newPatient);
                
                    System.out.println("Patient added successfully!");
                    break;
                
                case 8:
                    System.out.println("\n=== List of Patients ===");
                    for (Patient p : manager.getPatients()) {
                        System.out.println("ID: " + p.getId() + " | Name: " + p.getName() +
                                           " | Address: " + p.getAddress() + " | Phone: " + p.getPhoneNumber());
                    }
                    System.out.println("=========================\n");
                    break;
                
                case 9:
                    System.out.println("\n=== List of Physiotherapists ===");
                    for (Physiotherapist phys : manager.getPhysiotherapists()) {
                        System.out.println("ID: " + phys.getId());
                        System.out.println("Name: " + phys.getName());
                        System.out.println("Address: " + phys.getAddress());
                        System.out.println("Phone: " + phys.getPhoneNumber());
                        System.out.println("Specialties: " + String.join(", ", phys.getAreasOfExpertise()));
                        System.out.println("-----------------------------------");
                    }
                    System.out.println("====================================\n");
                    break;
                
                
                case 10:
                    System.out.println("\n=== List of Bookings ===");
                    for (Booking b : manager.getBookings()) {
                        System.out.println("Booking ID: " + b.getBookingId() +
                                           " | Patient: " + b.getPatient().getName() +
                                           " | Physiotherapist: " + b.getPhysiotherapist().getName() +
                                           " | Treatment: " + b.getTreatment().getName() +
                                           " | Time: " + b.getTreatment().getDateTime() + 
                                           " | Status: " + b.getTreatment().getStatus());
                    }
                    System.out.println("==========================\n");
                    break;
                
                case 11:
                    System.out.println("Exiting system. Goodbye!");
                    return;

                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }
    }

   
}
