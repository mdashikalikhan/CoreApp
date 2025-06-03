package com.interview.interfaces;

public class InterfaceTest {
    public static void main(String[] args) {
        Interface1 interface1 = (x,y)->x+y;

        System.out.println(interface1.sum(100,200));

        Vehicle vehicle = new Car(200);

        vehicle.start();

        Vehicle v = ()-> System.out.println("Hi....");

        v.start();


    }
}
