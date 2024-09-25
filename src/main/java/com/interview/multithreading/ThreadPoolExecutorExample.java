package com.interview.multithreading;

import lombok.Data;
import lombok.SneakyThrows;

import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class ThreadPoolExecutorExample {
    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor
                = (ThreadPoolExecutor)Executors.newFixedThreadPool(10);

        IntStream.range(1, 5000).forEach(
                i -> {
                    Task task = new Task("Task " + i);
                    System.out.println("Submitting " + task.getName());
                    threadPoolExecutor.execute(task);
                }
        );
        threadPoolExecutor.shutdown();

        try {
            if(!threadPoolExecutor.awaitTermination(1, TimeUnit.MINUTES)){
                List<Runnable> runnables = threadPoolExecutor.shutdownNow();
                System.out.println(runnables);
            }
        } catch (InterruptedException e) {
            List<Runnable> runnables = threadPoolExecutor.shutdownNow();
            System.out.println(runnables);
        }
    }


}

@Data
class Task implements Runnable {

    private final String name;

    @Override
    public void run() {

        System.out.println(Thread.currentThread().getName()
                + " is executing " + name);
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

    }
}
