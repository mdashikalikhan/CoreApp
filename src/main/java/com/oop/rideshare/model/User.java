package com.oop.rideshare.model;

public class User {
    protected String name;
    protected String phone;

    public User(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    public void bookRide(){
        System.out.println(name + " booked a ride...");
    }
}
