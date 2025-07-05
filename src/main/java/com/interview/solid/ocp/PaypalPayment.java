package com.interview.solid.ocp;

public class PaypalPayment implements PaymentMethod{
    @Override
    public void pay(double amount) {
        System.out.println("Paypal payment method: " + amount);
    }
}
