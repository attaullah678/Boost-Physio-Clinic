package model;

public class Patient {
    private static int idCounter = 1; //static counter for auto-incrementing IDs
    private int id;
    private String name;
    private String address;
    private String phoneNumber;

    public Patient(String name, String address, String phoneNumber) {
        this.id = idCounter++;
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public Patient(int id, String name, String address, String phoneNumber) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        if (id >= idCounter) {
            idCounter = id + 1;
        }
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
