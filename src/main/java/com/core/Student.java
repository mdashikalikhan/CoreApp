package com.core;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Student implements Comparable<Student>{

    private int id;
    private String name;
    private int marks;

    public Student(int id, String name, int marks) {
        this.id = id;
        this.name = name;
        this.marks = marks;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getMarks() {
        return marks;
    }

    @Override
    public int compareTo( Student o) {
        return Integer.compare(this.id, o.id);
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", marks=" + marks +
                '}';
    }

    public static void main(String[] args) {
        List<Student> students = new ArrayList<Student>();
        students.add(new Student(10, "A", 10));
        students.add(new Student(11, "B", 20));
        students.add(new Student(1, "C", 30));
        students.add(new Student(8, "D", 5));
        students.add(new Student(7, "B", 30));

        Collections.sort(students);

        System.out.println(students);

        Comparator<Student> comparator = (s1, s2) -> s2.marks - s1.marks;

        Collections.sort(students, comparator);

        System.out.println(students);

        students.sort(Comparator.comparing(Student::getMarks).reversed()
        .thenComparing(Comparator.comparing(Student::getName)));

        System.out.println(students);

    }
}
