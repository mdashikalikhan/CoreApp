package com.oop.rideshare.model;

public class BikeRide extends Ride{

    @Override
    public void calculateFare() {
        System.out.println("Bike Fare: $12");
    }
}
