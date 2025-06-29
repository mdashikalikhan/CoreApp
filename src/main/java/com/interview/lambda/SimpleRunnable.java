package com.interview.lambda;

public class SimpleRunnable {
    public static void main(String[] args) {
        Runnable r = ()-> System.out.println("Hello Lambda");
        new Thread(r).start();
    }
}
