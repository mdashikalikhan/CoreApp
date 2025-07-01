package com.oop.rideshare.model;

public class BusRide extends Ride {

    @Override
    public void calculateFare() {
        System.out.println("Bus Fair: $20");
    }
}
