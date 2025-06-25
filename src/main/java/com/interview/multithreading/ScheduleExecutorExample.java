package com.interview.multithreading;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class ScheduleExecutorExample {

    public static void main(String[] args) {
        ScheduledExecutorService executor
                = Executors.newScheduledThreadPool(1);
        AtomicInteger count = new AtomicInteger();

        Runnable task
                = ()->{
            System.out.println("Scheduler run at " + System.currentTimeMillis()
            + " with fixed delay.. count = " + (count.get()+1));
            count.getAndIncrement();
        };

        executor.scheduleAtFixedRate(task, 0, 3, TimeUnit.SECONDS);

        int max = 20;
        new Thread(
                ()->{
                    System.out.println("Scheduler will run  20 times");
                    while(count.get()<max){

                    }
                    executor.shutdown();
                    System.out.println("Scheduler shutdown...");
                }

        ).start();


    }
}
