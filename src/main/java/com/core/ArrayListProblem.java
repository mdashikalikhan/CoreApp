package com.core;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;

public class ArrayListProblem extends Thread{
    public void run(){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        courses.add("Kubernetes " + new Random().nextInt(1000));
    }

    //static ArrayList<String> courses = new ArrayList<>();

    static CopyOnWriteArrayList<String> courses = new CopyOnWriteArrayList<>();

    public static void main(String[] args) throws InterruptedException {
        ArrayListProblem arrayListProblem = new ArrayListProblem();
        arrayListProblem.start();

        courses.add("Java");
        courses.add("Python");
        courses.add("C#");
        courses.add("C++");
        courses.add("Go");
        courses.add("Ruby");
        courses.add("Docker");
        courses.add("AWS");

        Iterator<String> iterator = courses.iterator();

        while (iterator.hasNext()){
            Thread.sleep(2100);
            System.out.println(iterator.next());
        }
        System.out.println(courses);
    }
}
