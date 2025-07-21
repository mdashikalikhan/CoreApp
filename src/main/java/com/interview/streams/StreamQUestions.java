package com.interview.streams;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class StreamQUestions {
    public static void main(String[] args) {
        q1();
    }

    static void q1(){
        List<String> lists = List.of("apple", "banana", "avocado", "blueberry", "cherry");
        Map<Character, List<String>> collect = lists.stream().collect(Collectors.groupingBy(s -> s.charAt(0))
        );

        System.out.println(collect);

        Map<Character, Long> collect1 = lists.stream().collect(Collectors.groupingBy(s -> s.charAt(0), Collectors.mapping(s -> s.charAt(0), Collectors.counting()))
        );

        System.out.println(collect1);

        String max = lists.stream().max(Comparator.comparing(String::length)).orElse("");
        System.out.println(max);
    }
}
