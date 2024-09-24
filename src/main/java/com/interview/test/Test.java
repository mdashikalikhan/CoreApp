package com.interview.test;

import java.util.Arrays;
import java.util.List;

public class Test {

    public static void main(String[] args) {
        var list = Arrays.asList("", "abc", "def");
        System.out.println(mapping(list));
    }

    public static List<String> mapping(List<String> list){
        return list.stream().map(s->s.toUpperCase()).toList();
    }
}
