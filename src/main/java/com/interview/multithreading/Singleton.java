package com.interview.multithreading;

public class Singleton {

    private static Singleton instance;

    private Singleton(){

    }

    public static Singleton getInstance(){
        if(instance==null){

            synchronized (Singleton.class){
                if(instance==null){
                    System.out.println("Instance created");
                    instance = new Singleton();
                }
            }
        }

        return instance;
    }

    public void doSomething(){
        System.out.println("Do something..");
    }
}
