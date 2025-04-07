package model;

public class Treatment {
    private String name;
    private String dateTime; // Using String for simplicity, later we can use a date-time object
    private Physiotherapist physiotherapist;

    // Constructor
    public Treatment(String name, String dateTime, Physiotherapist physiotherapist) {
        this.name = name;
        this.dateTime = dateTime;
        this.physiotherapist = physiotherapist;
    }

    // Getters and Setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDateTime() { return dateTime; }
    public void setDateTime(String dateTime) { this.dateTime = dateTime; }

    public Physiotherapist getPhysiotherapist() { return physiotherapist; }
    public void setPhysiotherapist(Physiotherapist physiotherapist) { this.physiotherapist = physiotherapist; }
}
