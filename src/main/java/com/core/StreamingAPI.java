package com.core;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamingAPI {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(8, 9, 10, 40, 1, 2, 3, 4, 5, 6, 7, 18, 23, null);

        System.out.println(list.stream().takeWhile(x -> x < 20).collect(Collectors.toList()));

        System.out.println(list.stream().dropWhile(x -> x < 10).collect(Collectors.toList()));
    }
}
