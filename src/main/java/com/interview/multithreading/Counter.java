package com.interview.multithreading;

import java.util.concurrent.locks.ReentrantLock;

public class Counter {

    private int count = 0;

    private final ReentrantLock lock = new ReentrantLock();

    public void increment() {
        lock.lock();
        count++;
        System.out.println(Thread.currentThread().getName() + ": " + count);
        lock.unlock();
    }

    public static void main(String[] args) {

        Counter counter = new Counter();
        for (int i = 0; i < 10; i++) {

            new Thread(counter::increment).start();
        }

    }
}
