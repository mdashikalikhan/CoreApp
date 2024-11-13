package com.interview.multithreading;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchTest {

    public static void main(String[] args) throws InterruptedException {
        test1();
    }

    private static void test1() throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(2);
        new Thread(()->{
            System.out.println(Thread.currentThread().getName() + " First Thread");

            try {
                Thread.sleep(6000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(Thread.currentThread().getName() + " completes");
            countDownLatch.countDown();
        }).start();

        new Thread(()->{
            System.out.println(Thread.currentThread().getName() + " Second Thread");

            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(Thread.currentThread().getName() + " completes");
            countDownLatch.countDown();
        }).start();

        countDownLatch.await();

        System.out.println("All tasks completes");
    }
}
