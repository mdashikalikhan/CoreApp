package com.interview.collection;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ProducerConsumerExample {
    public static void main(String[] args) {
        BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(10);
        Thread t1 = new Thread(new Producer(queue));

        Thread t2 = new Thread(new Consumer(queue));

        t1.start();
        t2.start();
    }
}
