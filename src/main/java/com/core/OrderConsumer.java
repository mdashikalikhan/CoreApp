package com.core;

import java.util.concurrent.BlockingQueue;

public class OrderConsumer implements Runnable{
    @Override
    public void run() {
        try {

            while(true){
                String element = queue.take();
                if(element.equals("END")){
                    break;
                }
                System.out.println("Consume: " + element);
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private BlockingQueue<String> queue;

    public OrderConsumer(BlockingQueue<String> queue) {
        this.queue = queue;
    }
}
