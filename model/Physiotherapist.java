package model;

import java.util.List;

public class Physiotherapist {
    private int id;
    private String name;
    private String address;
    private String phone;
    private String[] expertise; 
    private List<Treatment> timetable;

    // Constructor
    public Physiotherapist(int id, String name, String address, String phone, String[] expertise, List<Treatment> timetable) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.expertise = expertise;
        this.timetable = timetable;
    }

    
}
