package com.interview.multithreading;

public class VisibilityExample {

    private boolean  flag = false;

    public void setFlag(){
        flag = true;
        System.out.println("Flag is set");
    }

    public void checkFlag(){
        while(!flag){

        }

        System.out.println("Loop exits");
    }

    public static void main(String[] args) throws InterruptedException {
        VisibilityExample obj = new VisibilityExample();

        new Thread(obj::checkFlag).start();

        Thread.sleep(1000);

        new Thread(obj::setFlag).start();

    }
}
