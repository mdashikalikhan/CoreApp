package com.interview.collection;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class SortObjects {
    public static void main(String[] args) {
        List<Person> people=
                Arrays.asList(
                        new Person(43, "Ashik"),
                        new Person(10, "BABU"),
                        new Person(20, "Selim"),
                        new Person(5, "Baby")

                );

        people.sort(Comparator.comparingInt(p->p.getAge()));


        System.out.println(people);

        people.sort((p1,p2)->p2.getAge()-p1.getAge());

        System.out.println(people);
    }



}

@Data
@AllArgsConstructor
class Person{
    private int age;
    private String name;
}
