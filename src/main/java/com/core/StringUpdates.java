package com.core;

import java.util.stream.Collectors;

public class StringUpdates {

    public static void main(String[] args) {
        String s = null;
        System.out.println("".isBlank());
        System.out.println("  ".isBlank());
        s = "I am\n passionate\n for learning";
        System.out.println(s);

        System.out.println(s.lines().collect(Collectors.toList()));

        char c = '\u2000';

        s = c+s+c;

        System.out.println(s.trim());

        System.out.println(s.strip());
    }
}
