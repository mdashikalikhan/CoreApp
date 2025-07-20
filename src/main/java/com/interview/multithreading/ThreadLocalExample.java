package com.interview.multithreading;

public class ThreadLocalExample {


    public static void main(String[] args) {
        Runnable runnable = () -> {
            ThreadLocal<Integer> threadLocal = ThreadLocal.withInitial(() -> 1);
            try{
                threadLocal.set((int)(Math.random()*100));
                System.out.println( Thread.currentThread().getName() + ": " + threadLocal.get());
                Thread.sleep(200);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            } finally {
                threadLocal.remove();
            }

        };

        Thread thread1 = new Thread(runnable, "T-1");
        Thread thread2 = new Thread(runnable, "T-2");
        Thread thread3 = new Thread(runnable, "T-3");
        Thread thread4 = new Thread(runnable, "T-4");

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
    }
}
