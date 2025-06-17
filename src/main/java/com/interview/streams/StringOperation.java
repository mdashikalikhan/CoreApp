package com.interview.streams;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class StringOperation {
    public static void main(String[] args) {
        String str = "Hello World";
        Set<Character> set = new HashSet<>();
        str.chars().mapToObj(c->(char)c)
                .filter(c-> !set.add(c))
                .skip(2)
                .limit(1)
                .forEach(System.out::println);


        List<String> fruits = List.of("apple", "banana", "orange",
                "apple", "mango", "banana", "grape");

        fruits.stream().collect(Collectors.groupingBy(s->s,
                Collectors.counting()))
                .entrySet().forEach(System.out::println);
    }
}
