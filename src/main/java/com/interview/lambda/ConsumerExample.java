package com.interview.lambda;


import java.util.function.Consumer;

public class ConsumerExample {
    public static void main(String[] args) {
        Consumer<Number> consumer = (num)-> System.out.println(num.intValue()*100);
        consumer.andThen(c->c.intValue());

        consumer.accept(100);

    }
}
