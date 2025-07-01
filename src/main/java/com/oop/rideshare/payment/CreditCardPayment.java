package com.oop.rideshare.payment;

public class CreditCardPayment extends Payment{
    @Override
    public void pay(double amount) {
        System.out.println("Credit card payment: $" + amount);

    }
}
