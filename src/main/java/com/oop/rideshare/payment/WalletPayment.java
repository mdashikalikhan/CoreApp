package com.oop.rideshare.payment;

public class WalletPayment extends Payment{
    @Override
    public void pay(double amount) {
        System.out.println("Wallet Payment: $" + amount);
    }
}
