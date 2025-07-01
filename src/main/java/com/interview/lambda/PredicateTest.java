package com.interview.lambda;

import java.util.function.Predicate;

public class PredicateTest {
    public static void main(String[] args) {
        Predicate<String> p1
                = s->s.equals("HELLO");
        System.out.println(p1.test("SAMSU"));
    }
}
