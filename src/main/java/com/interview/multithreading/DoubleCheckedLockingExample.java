package com.interview.multithreading;

public class DoubleCheckedLockingExample {
    public static void main(String[] args) {
        for (int i = 0; i<10; i++){
            new Thread(()->Singleton.getInstance().doSomething()).start();
        }
    }
}
