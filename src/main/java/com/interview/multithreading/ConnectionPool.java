package com.interview.multithreading;

import lombok.SneakyThrows;

import java.util.concurrent.Semaphore;

public class ConnectionPool {
    private final Semaphore semaphore;

    public ConnectionPool(int poolSize) {
        this.semaphore = new Semaphore(poolSize);
    }

    public void accessConnection()  {

        System.out.println(Thread.currentThread().getName() + " is waiting for connection");
        try {
            semaphore.acquire();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(Thread.currentThread().getName() + " acquired connection");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(Thread.currentThread().getName() + " releasing connection");
        semaphore.release();


    }

    public static void main(String[] args)  {
        ConnectionPool pool = new ConnectionPool(5);

        for (int i = 0; i < 35; i++) {
            new Thread(pool::accessConnection).start();
        }
    }
}
