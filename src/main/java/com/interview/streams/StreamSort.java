package com.interview.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamSort {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("banana", "apple", "cherry", "date");
        List<String> stringList = strings.stream().sorted().collect(Collectors.toList());
        System.out.println(stringList);
    }
}
