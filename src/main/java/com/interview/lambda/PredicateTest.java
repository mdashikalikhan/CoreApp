package com.interview.lambda;

import java.util.function.Predicate;

public class PredicateTest {
    public static void main(String[] args) {
        Predicate<String> p1
                = s->s.equals("HELLO");

        Predicate<String> p2 = p1.and(s -> s.startsWith("S"));
        System.out.println(p1.test("HELLO"));

        System.out.println(p2.test("SAMSU"));

    }
}
