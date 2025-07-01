package com.interview.immute;

import java.util.ArrayList;
import java.util.List;

public final  class StudentRecord {

    private final String name;
    private final List<String> courses;

    static{
        System.out.println("This is static block");
    }
    public StudentRecord(String name, List<String> courses) {
        this.name = name;
        this.courses = courses;
    }

    public String getName() {
        return name;
    }

    public List<String> getCourses() {
        return new ArrayList<>(courses);
    }

    public static void main(String[] args) {
        List<String> courses = new ArrayList<>();
        courses.add("Java");
        courses.add("Python");
        courses.add("C#");
        courses.add("C++");
        courses.add("JavaScript");
        courses.add("React");

        StudentRecord sr = new StudentRecord("MD ASHIK ALI KHAN", courses);
        sr.getCourses().add("Angular");

        System.out.println(sr.getName()
        + "  " + sr.getCourses());

        System.out.println(new String("ABC").hashCode()
        + " " + "ABC".hashCode());



    }
}
