package com.interview.lambda;

import java.util.function.BiFunction;

public class CustomeInterface {
    public static void main(String[] args) {
        Calculator<Integer, Integer, Integer> add =
                (a,b)-> a+b;

        Integer addition = add.calculate(4000, 5000);
        System.out.println(addition);

        Calculator<Long, Integer, Integer>
        multiplication = (a,b)-> a.longValue()*b.longValue();

        System.out.println(multiplication.calculate(4000, 5000));

        BiFunction<Integer, Integer, String>
                func = (a,b)-> ""+a+b;

        System.out.println(func.apply(4000, 5000));
    }
}

interface Calculator<X,Y,Z>{
    X calculate(Y a, Z b);
}
