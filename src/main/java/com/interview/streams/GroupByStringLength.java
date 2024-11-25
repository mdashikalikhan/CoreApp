package com.interview.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupByStringLength {
    public static void main(String[] args) {
        List<String> stringList = Arrays.asList("apple", "banana", "cherry", "date", "fig", "grape",
                "a", "b", "c");
        Map<Integer, List<String>> groupingByLength
                = stringList.stream().collect(Collectors.groupingBy(String::length));

        groupingByLength.forEach((len, str)-> System.out.println(len + ": " + str));

    }
}
