package com.oop.rideshare.model;

public class CarRide extends Ride{
    @Override
    public void calculateFare() {
        System.out.println("Car Fare: $15");
    }
}
