package com.oop.rideshare;

import com.oop.rideshare.model.*;
import com.oop.rideshare.payment.CreditCardPayment;
import com.oop.rideshare.payment.Payment;
import com.oop.rideshare.payment.WalletPayment;

public class RideShareTest {
    public static void main(String[] args) {
        //Class Object
        User ashik = new User("MD. ASHIK ALI KHAN", "01777401985");
        ashik.bookRide();

        //Inheritance
        Driver akram = new Driver("MD AKRAM", "0130000000", "Car");

        //Encaptulation
        akram.setLicenseNumber("L72637812487W");

        akram.startRide();

        System.out.println("License: " + akram.getLicenseNumber());


        //sub class treats its parent class reference
        Ride cardRide = new CarRide();
        Ride busRide = new BusRide();
        Ride bikeRide = new BikeRide();

        //polymorphism-- overriding
        cardRide.calculateFare();
        busRide.calculateFare();
        bikeRide.calculateFare();

        Payment credit = new CreditCardPayment();
        Payment wallet = new WalletPayment();

        //polymorphism-- overriding
        credit.pay(200);
        wallet.pay(100);
    }
}
