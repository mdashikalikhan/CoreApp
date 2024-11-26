package com.interview.streams;

import java.util.Arrays;

public class SortPrimitiveArray {
    public static void main(String[] args) {
        int[] numbers = {5, 3, 8, 1, 2};

        int[] sortedNumbers = Arrays.stream(numbers).sorted().toArray();

        System.out.println(Arrays.toString(sortedNumbers));
    }
}
