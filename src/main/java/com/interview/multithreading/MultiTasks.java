package com.interview.multithreading;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MultiTasks {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        blockingExample();
    }

    static void blockingExample() throws ExecutionException, InterruptedException {
        ExecutorService executorService
                = Executors.newFixedThreadPool(2);

        Future<Integer> future =
                executorService.submit(()->{
                    Thread.sleep(12000);
                    return 100;
                });

        Integer result = future.get();

        System.out.println("Result: " + result);

        executorService.shutdown();
    }

    static void nonBlockingExample(){

    }
}

