package com.interview.collection;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class SortCollection {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("banana", "apple", "cherry", "date");

        strings.sort(Comparator.naturalOrder());

        System.out.println(strings);

        strings.sort(Comparator.reverseOrder());

        System.out.println(strings);
    }
}
