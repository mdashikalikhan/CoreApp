package com.core;

public class MyWorker implements AutoCloseable {
    @Override
    public void close() throws Exception {
        System.out.println("Closing MyWorker resource");
    }

    public MyWorker() {
        System.out.println("Creating MyWorker resource");
    }

    public void doSomething() {
        System.out.println("doSomething method");
    }
}
