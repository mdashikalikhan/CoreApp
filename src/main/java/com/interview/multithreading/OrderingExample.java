package com.interview.multithreading;

public class OrderingExample {

    private int x = 0;

    private boolean flag = false;

    public void writer(){
        x = 42;
        flag = true;
    }

    public void reader(){
        if (flag){
            System.out.println("x: " +x);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        OrderingExample orderingExample = new OrderingExample();
        new Thread(orderingExample::writer).start();
        Thread.sleep(10);
        new Thread(orderingExample::reader).start();
    }
}
