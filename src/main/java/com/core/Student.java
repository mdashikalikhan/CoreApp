package com.core;


public class Student implements Comparable<Student>{

    private int id;
    private String name;
    private int marks;

    public Student(int id, String name, int marks) {
        this.id = id;
        this.name = name;
        this.marks = marks;
    }

    @Override
    public int compareTo( Student o) {
        return Integer.compare(this.id, o.id);
    }
}
