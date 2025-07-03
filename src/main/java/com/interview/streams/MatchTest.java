package com.interview.streams;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MatchTest {

    public static void main(String[] args) {
        List<String> strings = List.of("java", "spring", "lambda", "spring");

        boolean java = strings.stream().anyMatch(s -> s.equals("java"));
        System.out.println(java);

        boolean noneMatch = strings.stream().noneMatch(s -> s.equals("java1"));

        System.out.println(noneMatch);

        List<Integer> list = List.of(2, 4, 6, 8, 10, 20, 60);

        boolean allMatch = list.stream().allMatch(p -> p % 2 == 0);
        System.out.println(allMatch);

        System.out.println(list.stream().mapToInt(Integer::intValue).sum());

        strings.stream().findFirst().ifPresent(System.out::println);
        strings.stream().filter(s -> s.startsWith("s"))
                .findFirst().ifPresent(System.out::println);

        strings.stream().filter(s -> s.startsWith("s"))
                .findAny().ifPresent(System.out::println);

        int minValue = list.stream().mapToInt(i -> i)
                .min().orElseThrow(() -> new RuntimeException("No min value"));

        System.out.println(minValue);

        int max = list.stream().mapToInt(i -> i).max()
                .orElseThrow(RuntimeException::new);

        System.out.println(max);

        String joining = strings.stream().collect(Collectors.joining(", "));
        System.out.println(joining);

        String listJoin = list.stream().map(i -> i + "").collect(Collectors.joining(", "));

        System.out.println(listJoin);

        Map<String, Long> frequency = strings.stream().collect(Collectors.groupingBy(
                s -> s, Collectors.counting()
        ));

        frequency.forEach((k,v)->System.out.println(k + ": " + v));

        Map<String, String> groupJoin = strings.stream().collect(Collectors.groupingBy(s -> s,
                Collectors.joining(", ")));
        groupJoin.forEach((k,v)->System.out.println(k + ": " + v));

        Map<Integer, String> lengthJoin = strings.stream().collect(Collectors.groupingBy(s -> s.length(),
                Collectors.joining(", ")));
        lengthJoin.forEach( (k,v)->System.out.println(k + ": " + v));

        Map<Boolean, List<Integer>> partitionEvenOdd = list.stream().collect(Collectors.partitioningBy(n -> n % 2 == 0));

        partitionEvenOdd.forEach( (k,v)->System.out.println(k + ": " + v));

        Map<Integer, List<String>> collect = strings.stream().collect(Collectors.groupingBy(s -> s.length()));
        collect.forEach((k,v)->System.out.println(k + ": " + v));

        strings.stream().limit(1).forEach(System.out::println);

        strings.stream().skip(2).forEach(System.out::println);
    }
}
