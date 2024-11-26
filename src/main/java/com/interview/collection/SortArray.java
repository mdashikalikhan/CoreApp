package com.interview.collection;

import java.util.Arrays;

public class SortArray {

    public static void main(String[] args) {
        int[] numbers = {5, 3, 8, 1, 2};

        Arrays.sort(numbers);

        Arrays.stream(numbers).mapToObj(n->(String)(n+"...")).forEach(s -> System.out.println(s));
    }
}
