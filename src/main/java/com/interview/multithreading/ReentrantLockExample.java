package com.interview.multithreading;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockExample {

    private final ReentrantLock lock = new ReentrantLock(true);

    public void performLockWithInterruption(){
        System.out.println(Thread.currentThread().getName()
        + " attempting to acquire lock...");
        try {
            lock.lockInterruptibly();

            System.out.println(Thread.currentThread().getName()
            + " acquired lock...");

            try{
                Thread.sleep(5000);
            } finally {
                lock.unlock();
                System.out.println(Thread.currentThread().getName()
                + " released lock...");
            }


        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName()
            + " interrupted while trying to acquire lock");
        }
    }

    public void tryLOckWithTimeout(){
        boolean acquired = false;

        System.out.println(Thread.currentThread().getName()
        + " trying to acquire lock with timeout...");

        try {
            acquired = lock.tryLock(2, TimeUnit.SECONDS);

            if(acquired){
                try{
                    Thread.sleep(2000);
                } finally {
                    lock.unlock();
                    System.out.println(Thread.currentThread().getName()
                            + " released lock");
                }
            } else{
                System.out.println(Thread.currentThread().getName()
                + " could not acquire lock within timeout...");
            }


        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName() +
            " interrupted during try lock....");
        }
    }

    public static void main(String[] args) {
        ReentrantLockExample reentrantLockExample = new ReentrantLockExample();
    }

}
