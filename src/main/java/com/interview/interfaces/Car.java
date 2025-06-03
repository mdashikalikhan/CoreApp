package com.interview.interfaces;

public class Car  extends Vehicle.AbstractVehicle{
    public Car(int speed) {
        super(speed);
    }

    @Override
    public void start() {
        System.out.println("Car Speed: " + speed);
    }

    @Override
    public int sum(int a, int b) {
        return a+b;
    }
}
