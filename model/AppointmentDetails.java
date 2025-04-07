package model;
public class AppointmentDetails {
    private String treatmentName;
    private String patientName;
    private String dateTime;
    private String status;

    public AppointmentDetails(String treatmentName, String patientName, String dateTime, String status) {
        this.treatmentName = treatmentName;
        this.patientName = patientName;
        this.dateTime = dateTime;
        this.status = status;
    }
}
