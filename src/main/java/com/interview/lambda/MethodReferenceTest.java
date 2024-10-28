package com.interview.lambda;

public class MethodReferenceTest {
    public static void main(String[] args) {
        MethodReferenceTest test = new MethodReferenceTest();

        Calculate<Integer> addition = test :: add;

        System.out.println(addition.execute(1000,2080));

        System.out.println(test.addition((a,b)->10+20));

        Calculate<String> concat = test :: concatenation;

        System.out.println(concat.execute("ABC", "XYZ"));

    }

    int add(int a, int b){
        return a + b;
    }

    String concatenation(String x, String y){
        return x+y;
    }

    int addition(Calculate<Integer> calculate){
        return calculate.execute(0, 0);
    }
}
