package com.interview.multithreading;

import java.util.concurrent.locks.ReentrantLock;

public class TryLockExample {

    private final ReentrantLock lock = new ReentrantLock();

    private void acquireLock() {
        if(lock.tryLock()) {
            try {
                System.out.println(Thread.currentThread().getName() +
                        ":  Lock acquired");
            }finally {
                lock.unlock();
            }
        } else {
            System.out.println(Thread.currentThread().getName()
            + ":  Lock not acquired");
        }
    }

    public static void main(String[] args) {
        TryLockExample t = new TryLockExample();
        for (int i = 0; i < 10; i++) {
            new Thread(t::acquireLock).start();
        }
    }
}
