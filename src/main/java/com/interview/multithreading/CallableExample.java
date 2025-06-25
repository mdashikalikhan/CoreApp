package com.interview.multithreading;

import java.util.concurrent.*;

public class CallableExample {

    public static void main(String[] args) {
        ExecutorService executorService
                = Executors.newFixedThreadPool(2);

        Callable<String>
                task1 = ()-> {
            Thread.sleep(9000);
            return "Result from thread: " + Thread.currentThread().getName();
        };

        Future<String> future = executorService.submit(task1);

        try {
            String result = future.get();
            System.out.println("Result: " + result);
        } catch (InterruptedException  | ExecutionException e) {
                e.printStackTrace();
        } finally {
            executorService.shutdown();
        }
        }



}
