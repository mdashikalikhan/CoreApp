package com.interview.solid.ocp;

public class CreditCardPayment implements PaymentMethod{
    @Override
    public void pay(double amount) {
        System.out.println("Payment credit card: " + amount);
    }
}
