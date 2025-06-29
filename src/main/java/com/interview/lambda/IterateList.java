package com.interview.lambda;


import java.util.List;
import java.util.function.Consumer;

public class IterateList {
    public static void main(String[] args) {
        List<String> lists = List.of("Java", "Spring", "Lambda");

        lists.forEach(System.out::println);
    }

}
