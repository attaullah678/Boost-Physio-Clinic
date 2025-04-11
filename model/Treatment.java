package model;
public class Treatment {
    private String name;
    private String expertise;
    private String dateTime;
    private AppointmentStatus status; 

    public Treatment(String name, String expertise, String dateTime) {
        this.name = name;
        this.expertise = expertise;
        this.dateTime = dateTime;
        this.status = AppointmentStatus.AVAILABLE; 
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getExpertise() {
        return expertise;
    }

    public void setExpertise(String expertise) {
        this.expertise = expertise;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public AppointmentStatus getStatus() {
        return status;
    }

    public void setStatus(AppointmentStatus status) {
        this.status = status;
    }
}
