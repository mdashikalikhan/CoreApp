package com.core;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class BlockingQueueTest {
    public static void main(String[] args) {
        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(1024);
        OrderProducer orderProducer = new OrderProducer(blockingQueue);
        OrderConsumer orderConsumer = new OrderConsumer(blockingQueue);

        new Thread(orderConsumer).start();
        new Thread(orderProducer).start();
    }
}
