package com.interview.streams;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ArrayMerge {
    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4};
        int[] arr2 = {3, 4, 5, 6, 7, 8};
        Integer[] array = IntStream.concat(Arrays.stream(arr1), Arrays.stream(arr2))
                .boxed()
                .toArray(Integer[]::new);

        Arrays.stream(array).forEach(System.out::println);
    }
}
