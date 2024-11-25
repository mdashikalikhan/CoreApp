package com.interview.streams;

import java.util.Map;
import java.util.stream.Collectors;

public class CharacterFrequency {
    public static void main(String[] args) {
        String input = "bananabanana";

        Map<Character, Long> charFrequency = input.chars().mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(c -> c, Collectors.counting()));

        charFrequency.forEach((ch, count)-> System.out.println(ch + ": " + count));

    }
}
