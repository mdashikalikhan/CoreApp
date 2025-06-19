package com.interview.multithreading;

public class BlockingTest {

    public static void main(String[] args) {

        Object obj = new Object();

        Thread t1 = new Thread(
                () -> {
                    synchronized (obj) {
                        /*System.out.println("Thread 1 holds lock");*/
                        /*try {
                            Thread.sleep(6000);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }*/
                        System.out.println("Thread 1 is waiting for notify...");

                        try {
                            obj.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        System.out.println("Thread 1 is notified..");
                    }

                }
        );

        Thread t2 = new Thread(
                () -> {
                    try {
                        Thread.sleep(7000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    synchronized (obj) {
                        //System.out.println("Thread 2 holds lock");



                        System.out.println("Thread 2 send notify to all threads");
                        obj.notifyAll();



                    }

                }
        );

        Thread t3 = new Thread(
                () -> {
                    synchronized (obj) {
                        System.out.println("Thread 3 is waiting for notify");
                        try {
                            obj.wait();
                            System.out.println("Thread 3 is notified");
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }

                }
        );

        Thread t4 = new Thread(
                () -> {
                    synchronized (obj) {
                        System.out.println("Thread 4 is waiting for notify");
                        try {
                            obj.wait();
                            System.out.println("Thread 4 is notified");
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }

                }
        );


        t1.start();

        t2.start();

        t3.start();

        t4.start();
    }
}
