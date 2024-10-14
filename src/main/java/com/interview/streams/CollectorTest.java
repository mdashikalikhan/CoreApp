package com.interview.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class CollectorTest {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("a", "b", "c", null, "bangla",
                "desh");
        List<String> uppercase = list.stream()
                .filter(Objects::nonNull).map(String::toUpperCase)
                .collect(Collectors.toList());

        System.out.println(uppercase);

        List<String> strList = Arrays.asList("fgdf", "rute84", "lgfdkjiy");

        List<Integer> integerList = strList.stream().filter(Objects::nonNull)
                .map(String::length).toList();

        System.out.println(integerList);

        List<List<Integer>> listOfLIsts = Arrays.asList(
                Arrays.asList(1),
                Arrays.asList(2,3),
                Arrays.asList(4,5,6)
        );

        System.out.println(listOfLIsts);

        List<Integer> integers = listOfLIsts.stream().flatMap(List::stream)
                .toList();

        System.out.println(integers);


    }
}
