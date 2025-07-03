package com.interview.lambda;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SortingByLambda {

    public static void main(String[] args) {
        List<String> list = List.of("java", "lambda", "javascript",
                "kafka");

        list.stream().sorted(Comparator.naturalOrder())
                .forEach(System.out::println);

        List<Employee> empList = new ArrayList<>(
                List.of(new Employee("ADD", 72647.5),
                        new Employee("ANDGHD", 72647),
                        new Employee("IOUEUYR", 70000))
        );
        empList.stream().sorted((a,b)->Double.compare(a.salary,
                b.salary)).forEach(e->System.out.println(e.name
        + " " + e.salary));

        empList.stream().map(e->e.name.toLowerCase()).forEach(System.out::println);

    }
}

class Employee{
    String name;
    double salary;
    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }
}
