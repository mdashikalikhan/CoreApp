package com.interview.streams;

import java.util.List;

public class ReduceTest {
    public static void main(String[] args) {
        List<Integer> integerList = List.of(1, 2, 2,3, 3, 4, 5, 6, 7);

        Integer sum = integerList.stream().reduce(0, (a, b) -> a + b);

        System.out.println(sum);

        Integer distinctSum = integerList.stream().distinct().reduce(0, (a, b) -> a + b);

        System.out.println(distinctSum);

        System.out.println(integerList.stream().count());

    }
}
