package com.interview.interfaces;

@FunctionalInterface public interface Interface1 {

    int x=1;
    static int y=1;
    static void message(){
        System.out.println("Static method");
    }
    default void method1() {
         System.out.println("method1");

    }
    default void method2() {
        System.out.println("method2");
    }

    default void method3() {
        System.out.println("method3");

    }

    int sum(int a, int b);
}
