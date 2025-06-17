package com.interview.multithreading;

public class BlockingTest {

    public static void main(String[] args) {

        Object obj = new Object();

        Thread t1 = new Thread(
                () -> {
                    synchronized (obj) {
                        System.out.println("Thread 1 holds lock");
                        try {
                            Thread.sleep(6000);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        System.out.println("Waiting to be notified...");

                        try {
                            obj.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        System.out.println("Thread 1 notified..");
                    }

                }
        );

        Thread t2 = new Thread(
                () -> {
                    synchronized (obj) {
                        System.out.println("Thread 2 holds lock");
                        try {
                            Thread.sleep(2000);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }


                        System.out.println("Thread 2 send notify");
                        obj.notify();



                    }

                }
        );


        t1.start();

        t2.start();
    }
}
