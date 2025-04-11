package model;
import java.util.*;

public class Physiotherapist {
    private int id;
    private String name;
    private String address;
    private String phoneNumber;
    private List<String> areasOfExpertise;
    private Map<String, List<Treatment>> timetable; 

    public Physiotherapist(int id, String name, String address, String phoneNumber, List<String> areasOfExpertise) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.areasOfExpertise = new ArrayList<>(areasOfExpertise); 
        this.timetable = new HashMap<>();
    }

    public int getId(){
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<String, List<Treatment>> getTimetable() {
        return timetable;
    }

    public void setTimetable(Map<String, List<Treatment>> timetable) {
        this.timetable = timetable;
    }

    public void addExpertise(String expertise) {
        this.areasOfExpertise.add(expertise);
    }

    public void removeExpertise(String expertise) {
        this.areasOfExpertise.remove(expertise);
    }
    public List<String> getAreasOfExpertise() {
        return new ArrayList<>(areasOfExpertise); 
    }
    

    public List<Treatment> getAvailableTreatments(String expertise) {
        List<Treatment> availableTreatments = new ArrayList<>();
        for (String week : timetable.keySet()) {
            for (Treatment treatment : timetable.get(week)) {
                if (treatment.getExpertise().equals(expertise) && treatment.getStatus() == AppointmentStatus.AVAILABLE) {
                    availableTreatments.add(treatment);
                }
            }
        }
        return availableTreatments;
    }

    public List<Treatment> getAvailableTreatmentsForPhysio() {
        List<Treatment> availableTreatments = new ArrayList<>();
        for (String week : timetable.keySet()) {
            availableTreatments.addAll(timetable.get(week));
        }
        return availableTreatments;
    }


    public String getAddress() {
        return address;
    }


    public String getPhoneNumber() {
        return phoneNumber;
    }
}
