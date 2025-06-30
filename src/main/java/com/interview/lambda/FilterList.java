package com.interview.lambda;

import java.util.List;

public class FilterList {
    public static void main(String[] args) {
        List<String> lists
                = List.of("Java", "JavaScript", "Python", "C++", "C");

        lists.stream().filter(s -> s.startsWith("J")).forEach(System.out::println);
    }
}
