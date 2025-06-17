package com.interview.streams;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class PartitionExample {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        Map<Boolean, List<Integer>> numberPartition =
                numbers.stream()
                        .collect(Collectors.partitioningBy(n -> n % 2 == 0));

        System.out.println("Odd = " + numberPartition.get(false));

        System.out.println("Even = " + numberPartition.get(true));

        List<Employee> employees = List.of(
                new Employee("ASHIK", 50, "R&D", 40),
                new Employee("MD ASHIK ALI KHAN", 43, "R&D", 40),
                new Employee("AKRAM KHAN", 30, "QC", 50)
        );

        String joinStr = employees.stream().map(Employee::getName)
                .collect(Collectors.joining(", "));

        System.out.println(joinStr);

        List<List<Integer>> listOfList=List.of(
                List.of(1,2,3,4),
                List.of(100, 1),
                List.of(5,6,7,90),
                List.of(90,100,200)

        );

        List<Integer> integerList = listOfList.stream().flatMap(list -> list.stream())
                .distinct().collect(Collectors.toList());

        System.out.println(integerList);

        List<Transaction> userTransactions = List.of(
                new Transaction("ASHIK", 100.90),
                new Transaction("ABIR", 80.01),
                new Transaction("MD ASHIK ALI KHAN", 40.90),
                new Transaction("ASHIK", 200.09)
        );

        Map<String, Double> avgTransaction = userTransactions.stream().collect(
                Collectors.groupingBy(transaction -> transaction.user,
                        Collectors.averagingDouble(transaction -> transaction.amount))
        );

        System.out.println(avgTransaction);

        Map<Boolean, List<Transaction>> partition = userTransactions.stream()
                .collect(Collectors.partitioningBy(t -> t.amount >= 100));

        System.out.println(partition);

        List<String> words = List.of("apple", "banana", "carrot", "apple", "banana", "date");

        Map<String, Integer> wordsMap = words.stream().distinct().collect(
                Collectors.toMap(s -> s, s -> s.length())
        );

        System.out.println(wordsMap);

        double second = userTransactions.stream().map(Transaction::getAmount)
                .distinct()
                .sorted((a, b) -> Double.compare(b, a))
                .skip(1)
                .findFirst().orElseThrow();

        System.out.println(second);


    }
}

@Data
@AllArgsConstructor
class Employee{
    String name;
    int id;
    String department;
    int age;
}

@Data
@AllArgsConstructor
class Transaction{
    String user;
    double amount;
}
