package com.interview.collection;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class WriteArray {
    public static void main(String[] args) {
        CopyOnWriteArrayList<Employee> lists = new CopyOnWriteArrayList<>(
                List.of(new Employee(1,"Cust1"),
                        new Employee(2, "Cust2"),
                        new Employee(3, "Cust3"))
        );

        System.out.println(lists);

        lists.stream().filter(c->c.getId()==2).forEach(c->c.setName("Cust200"));

        System.out.println(lists);

    }


}

@Data
@AllArgsConstructor
class Employee{
    int id;
    String name;
}