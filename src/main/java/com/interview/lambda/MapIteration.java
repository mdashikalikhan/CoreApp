package com.interview.lambda;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapIteration {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();

        map.put("a", 1);
        map.put("b", 2);
        map.put("c", 3);

        map.forEach((k, v) -> System.out.println(k + ": " + v));

        for(Map.Entry<String, Integer> m : map.entrySet()) {
            System.out.println(m.getKey() + ": " + m.getValue());
        }

    }
}
