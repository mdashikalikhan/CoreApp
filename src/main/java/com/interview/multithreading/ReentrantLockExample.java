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
                Thread.sleep(6000);
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
                    Thread.sleep(3000);
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

    public static void main(String[] args) throws InterruptedException {
        ReentrantLockExample reentrantLockExample = new ReentrantLockExample();

        Thread t1 = new Thread(reentrantLockExample::performLockWithInterruption, "T-1");

        Thread t2 = new Thread(reentrantLockExample::tryLOckWithTimeout, "T-2");

        t1.start();

        Thread.sleep(800);

        t2.start();

        Thread t3 = new Thread(
                ()->{
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {

                    }
                    System.out.println("Interrupting thread T-1");
                    t1.interrupt();

                }
        );

        t3.start();

    }

}
