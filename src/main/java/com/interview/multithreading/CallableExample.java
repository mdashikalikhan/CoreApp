package com.interview.multithreading;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableExample {

    public static void main(String[] args) {
        ExecutorService executorService
                = Executors.newFixedThreadPool(2);

        Callable<String>
                task = ()-> {
            Thread.sleep(9000);
            return "Result from thread: " + Thread.currentThread().getName();
        };

        Future<String> future = executorService.submit(task);
    }
}
