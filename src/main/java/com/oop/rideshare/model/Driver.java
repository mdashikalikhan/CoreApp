package com.oop.rideshare.model;

public class Driver extends User{

    private String verhicleType;
    private String licenseNumber;
    public Driver(String name, String phone, String verhicleType) {
        super(name, phone);
        this.verhicleType = verhicleType;
    }

    public void startRide(){
        System.out.println("Driver: " + name + " starts a ride using " + verhicleType);
    }
    public String getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }
}
