package com.interview.streams;

import java.util.List;

public class StreamOperation {

    public static void main(String[] args) {
        List<Integer> lists = List.of(100,1,23,40);

        Integer sum = lists.stream()
                .filter(x -> x % 2 == 0)
                .map(x -> x * 2)
                .reduce(0, Integer::sum);

        System.out.println(sum);

        List<String> names = List.of("MD ASHIK ALI KHAN",
                "LEO", "ASHIK", "");
    }
}
