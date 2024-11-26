package com.interview.streams;

import java.util.Arrays;

public class SortStringArray {
    public static void main(String[] args) {
        String[] strings = {"banana", "apple", "apl", "samsu", "cherry", "date"};

        String[] sortedArray = Arrays.stream(strings).sorted().toArray(String[]::new);

        System.out.println(Arrays.toString(sortedArray));
    }
}
