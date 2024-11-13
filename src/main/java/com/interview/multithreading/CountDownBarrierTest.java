package com.interview.multithreading;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CountDownBarrierTest {

    public static void main(String[] args) {

    }

    private static void test1(){
        CyclicBarrier cyclicBarrier = new CyclicBarrier(4);

        Runnable task = ()->{
            System.out.println(Thread.currentThread().getName() + " waiting for barrier.");

            try {
                cyclicBarrier.await();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } catch (BrokenBarrierException e) {
                throw new RuntimeException(e);
            }
            System.out.println(Thread.currentThread().getName() + " proceeds.");

        };

        new Thread(task).start();
        new Thread(task).start();

        new Thread(()->{
            System.out.println(Thread.currentThread().getName() + " is working..");
            try {
                Thread.sleep(5000);
                cyclicBarrier.await();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } catch (BrokenBarrierException e) {
                throw new RuntimeException(e);
            }
        }).start();



    }
}
