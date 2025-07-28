package com.interview.design;

import java.util.ArrayDeque;
import java.util.Deque;

public class DequeueExample {
    public static void main(String[] args) {
        Deque<String> deque = new ArrayDeque<>();
        deque.addFirst("a");
        deque.addFirst("b");
        deque.offerLast("Z");

        System.out.println(deque);

        deque.removeFirst();

        deque.removeLast();

        System.out.println(deque);

    }
}
