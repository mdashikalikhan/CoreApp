package com.interview.multithreading;

public class DeadLockDemo {

    private final Object resource1 = new Object();

    private final Object resource2 = new Object();

    public static void main(String[] args) {
        DeadLockDemo deadLockDemo = new DeadLockDemo();

        Thread t1 = new Thread(deadLockDemo::method1);

        Thread t2 = new Thread(deadLockDemo::method2);

        t1.start();

        t2.start();
    }

    public void method1(){
        synchronized (resource1){
            System.out.println("Method 1: holding lock for resource 1");

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                //throw new RuntimeException(e);
            }

            System.out.println("Method 1: waiting for resource 2");
            synchronized (resource2){

                System.out.println("Method 1: holding lock for resource 2");

            }
        }
    }

    public void method2(){
        synchronized (resource2){
            System.out.println("Method 2: holding lock for resource 2");

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                //throw new RuntimeException(e);
            }

            System.out.println("Method 2: waiting for resource 1");
            synchronized (resource1){

                System.out.println("Method 2: holding lock for resource 1");

            }
        }
    }
}
