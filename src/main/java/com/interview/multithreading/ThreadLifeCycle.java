package com.interview.multithreading;

import lombok.SneakyThrows;

public class ThreadLifeCycle {

    private static final Object lock = new Object();
    private volatile boolean running = false;

    public void run(){
        System.out.println("Thread life cycle started");
        try{
            Thread.sleep(1000);
        }catch(InterruptedException e){}
        System.out.println("Thread life cycle stopped");
    }

    public void waiter() {
        synchronized (lock){
            if(!running){
                System.out.println("Waiter: Waiting for notification...");
                try {
                    lock.wait();
                } catch (InterruptedException e) {

                }
            }
        }
    }

    public void notifier()  {
        synchronized (lock){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {

            }
            running = true;
            lock.notify();
            System.out.println("Notifier: Notify waiter");
        }
    }


    public static void main(String[] args) throws InterruptedException {
        ThreadLifeCycle threadLifeCycle = new ThreadLifeCycle();
        Thread t1 = new Thread(threadLifeCycle::run);
        t1.start();
        t1.join();
        Thread t2 = new Thread(threadLifeCycle::waiter);
        Thread t3 = new Thread(threadLifeCycle::notifier);
        t2.start();
        t3.start();
        t2.join();
        t3.join();
        System.out.println("Main Thread ended ");
    }
}
