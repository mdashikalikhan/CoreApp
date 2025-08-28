package com.interview.multithreading;

import java.util.List;
import java.util.concurrent.*;

public class MultiTasks {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        blockingExample1();
        blockingExample2();
        nonBlockingExample1();
    }

    static void blockingExample1() throws ExecutionException, InterruptedException {
        ExecutorService executorService
                = Executors.newFixedThreadPool(2);

        Future<Integer> future =
                executorService.submit(() -> {
                    Thread.sleep(12000);
                    return 100;
                });

        Integer result = future.get();

        System.out.println("Result: " + result);


        executorService.shutdown();
    }

    static void blockingExample2() throws InterruptedException, ExecutionException {
        ExecutorService executorService =
                Executors.newFixedThreadPool(100);

        List<Callable<Integer>> lists = List.of(
                () -> {
                    Thread.sleep(2000);
                    return 100;
                },
                () -> {
                    Thread.sleep(2000);
                    return 200;
                },
                () -> {
                    Thread.sleep(2000);
                    return 300;
                },
                () -> {
                    Thread.sleep(2000);
                    return 400;
                },
                () -> {
                    Thread.sleep(2000);
                    return 500;
                },
                () -> {
                    Thread.sleep(2000);
                    return 600;
                },
                () -> {
                    Thread.sleep(2000);
                    return 700;
                },
                () -> {
                    Thread.sleep(2000);
                    return 800;
                }
        );
        List<Future<Integer>> futures = executorService.invokeAll(lists);

        futures.stream().forEach(f -> {
            try {
                System.out.println(f.get());
            } catch (Exception e) {
                throw new RuntimeException(e);

            }
        });


        executorService.shutdown();

        executorService.shutdown();
        System.out.println("All tasks complete");


    }

    static void nonBlockingExample1() throws ExecutionException, InterruptedException {
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(
                () -> {
                    try {
                        Thread.sleep(6000);
                        int x = 1;

                        if (x == 1)
                            throw new RuntimeException("Exception Occurs");
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    return 100;
                }
        );

        future.exceptionally(ex -> {
                    System.out.println(ex.getMessage());
                    return 0;
                }).thenApply(r -> r * 100)
                .thenAccept(System.out::println);


        CompletableFuture<Integer> f1 = CompletableFuture.supplyAsync(() -> 10);

        CompletableFuture<Integer> f2 = CompletableFuture.supplyAsync(() -> {
            return 20;
        });

        f1.thenCombine(f2, (a,b)->a*b)
                .thenApply(r -> r + 100)
                .thenAccept(System.out::println);

        System.out.println("Main Thread completes");


        while (!future.isDone()) ;
    }
}

