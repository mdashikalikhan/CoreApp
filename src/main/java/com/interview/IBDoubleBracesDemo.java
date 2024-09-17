package com.interview;

import java.util.HashSet;
import java.util.Set;

public class IBDoubleBracesDemo {

    public static void main(String[] args) {
        Set<String> stringSets = new HashSet<>(){
            {
                add("set1");
                add("set2");
                add("set3");
            }
        };

        System.out.println(stringSets);
    }
}
