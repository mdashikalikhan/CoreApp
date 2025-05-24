package com.interview.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamOperation {

    public static void main(String[] args) {
        List<Integer> lists = List.of(100,1,23,40);

        Integer sum = lists.stream()
                .filter(x -> x % 2 == 0)
                .map(x -> x * 2)
                .reduce(0, Integer::sum);

        System.out.println(sum);

        List<String> names = List.of("MD ASHIK ALI KHAN",
                "LEO", "ASHIK", "AKRAM", "ABRAR", "RAFIQ", "MD AKRAM");

        List<String> stringList = names.stream().filter(name -> name.startsWith("A") || name.startsWith("M"))
                .map(String::toLowerCase).collect(Collectors.toList());

        System.out.println(stringList);

        List<String> flatString = names.stream().flatMap(s -> Arrays.stream(s.split(" ")))
                .collect(Collectors.toList());

        System.out.println(flatString);

    }
}
