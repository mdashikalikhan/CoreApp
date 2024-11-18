package com.interview.collection;

import java.util.HashSet;

public class HashExample {
    public static void main(String[] args) {
        HashSet<Integer>hashSet = new HashSet<>();

        hashSet.add(10);
        hashSet.add(10);

        System.out.println(hashSet);
    }
}
