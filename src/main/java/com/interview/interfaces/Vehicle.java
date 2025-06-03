package com.interview.interfaces;

@FunctionalInterface
public interface Vehicle {

    void start();

    abstract  class AbstractVehicle implements Vehicle, Interface1{
        protected int speed;

        public  AbstractVehicle(int speed){
            this.speed = speed;
        }

        @Override
        public void start() {
            System.out.println("The Speed is " + speed);
        }
    }
}
