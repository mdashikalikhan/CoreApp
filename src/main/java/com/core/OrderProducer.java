package com.core;

import java.util.concurrent.BlockingQueue;

public class OrderProducer implements Runnable {

    private BlockingQueue<String> queue;

    @Override
    public void run() {
        try {
            for(int i=1; i<=10; i++){
                System.out.println("Produce: " + i);
                queue.put(i+"");
                //Thread.sleep(1000);
            }
            queue.put("END");

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public OrderProducer(BlockingQueue<String> queue) {
        this.queue = queue;
    }
}
