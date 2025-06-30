package com.interview.lambda;


import java.util.function.Consumer;

public class ConsumerExample {
    public static void main(String[] args) {
        Consumer<Number> consumer = (num) -> System.out.println("Initial Value: " + num);
        Consumer<Number> combined1 = consumer.andThen(n -> System.out.println("After that (n*n): " + n.doubleValue()
                * n.doubleValue()));
        combined1.andThen(n -> System.out.println("After that (n-n): " + (n.doubleValue()
        - n.doubleValue())));


        combined1.accept(100);

    }
}
