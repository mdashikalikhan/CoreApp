package com.interview.hashing;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Objects;

@Data
@AllArgsConstructor
public class Person {
    private String name;
    private int age;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age && Objects.equals(name, person.name);
    }

    /*@Override
    public int hashCode() {
        return Objects.hash(name, age);
    }*/

    public static void main(String[] args) {
        Person person1 = new Person("Rahim", 20);

        Person person2 = new Person("Rahim", 20);

        if(person2==person1){
            System.out.println("Equal");
        }

        System.out.println(person1.hashCode() + " " + person2.hashCode());
    }

}
