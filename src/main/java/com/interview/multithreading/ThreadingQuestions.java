package com.interview.multithreading;

public class ThreadingQuestions {

    public static void main(String[] args) {
        printEvenOdd();
        //sleepAndYield();
    }

    static void printEvenOdd() {
        Object lock = new Object();
        Thread t1 = new Thread(
                () -> {
                    synchronized (lock) {
                        for (int i = 1; i <= 100; i += 2) {

                            System.out.println(i);

                                lock.notify();


                            try {
                                if(i!=99){
                                    lock.wait();
                                }
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }

                        }
                    }
                }
        );

        Thread t2 = new Thread(
                () -> {
                    synchronized (lock) {
                        for (int i = 2; i <= 100; i += 2) {

                            System.out.println(i);
                            lock.notify();
                            try {
                                if(i!=100){
                                    lock.wait();
                                }
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }

                        }
                    }
                }
        );

        t1.start();
        t2.start();
    }

    static void sleepAndYield(){
        Thread t1 = new Thread(()->{
           for (int i=0;i<5;i++){
               System.out.println("Sleep " + i);
               try {
                   Thread.sleep(1000);
               } catch (InterruptedException e) {
                   Thread.currentThread().interrupt();
               }
           }
        });

        Thread t2 = new Thread(()->{
            for (int i=0;i<5;i++){
                System.out.println("Yield " + i);
                Thread.yield();
            }
        });

        t1.start();
        t2.start();
    }
}
