package com.interview.multithreading;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class MultiTaskExample {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(3);

        List<Callable<String>> tasks = new ArrayList<>();

        for (int i = 1; i <= 10; i++) {
            int taskId = i;
            tasks.add(() -> {
                System.out.println("Task " + taskId + " starts");

                Thread.sleep(2000);
                return "Task " + taskId + " completes...";
            });
        }

        try {
            List<Future<String>> results = executor.invokeAll(tasks);

            for (Future<String> result : results) {

                System.out.println(result.get()); //Blocks until result is ready
            }

        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        } finally {
            executor.shutdown();
        }


        ExecutorService exec = Executors.newFixedThreadPool(4);

        List<Callable<String>> taskList =
                List.of(() -> {
                            Thread.sleep(2000);
                            return "Task 1 finished";
                        },
                        () -> {
                            Thread.sleep(2000);
                            return "Task 2 finished";
                        },
                        () -> {
                            Thread.sleep(2000);
                            return "Task 3 finished";
                        },
                        () -> {
                            Thread.sleep(2000);
                            return "Task 4 finished";
                        },
                        () -> {
                            Thread.sleep(2000);
                            return "Task 5 finished";
                        },
                        () -> {
                            Thread.sleep(2000);
                            return "Task 6 finished";
                        },
                        () -> {
                            Thread.sleep(2000);
                            return "Task 7 finished";
                        },
                        () -> {
                            Thread.sleep(2000);
                            return "Task 8 finished";
                        });

        try {
            String result = exec.invokeAny(taskList);
            System.out.println("First: " + result);
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        } finally {
            exec.shutdown();
        }

    }
}
