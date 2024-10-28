package com.interview.lambda;

@FunctionalInterface
public interface Calculate<T> {

    T execute(T param1, T param2);

}
