package com.interview.multithreading;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class SharedData {
    private int data = 0;

    private final ReadWriteLock lock = new ReentrantReadWriteLock();

    private int readData(){
        lock.readLock().lock();
        System.out.println(Thread.currentThread().getName() + ": Reading data " + data);
        try {
            Thread.sleep(10000);
            return data;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            lock.readLock().unlock();
        }
    }

    private void writeData(int data){
        System.out.println(Thread.currentThread().getName() + ": Writing data trying to lock" );
        lock.writeLock().lock();
        this.data = data;
        System.out.println(Thread.currentThread().getName() + ": Writing data " + data);
        lock.writeLock().unlock();
    }

    public static void main(String[] args) {
        SharedData sharedData = new SharedData();

        new Thread(()->{sharedData.writeData(90);}).start();

        for (int i = 0; i < 30; i++) {
            new Thread(sharedData::readData).start();
        }


    }
}
