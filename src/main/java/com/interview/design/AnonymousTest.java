package com.interview.design;

public class AnonymousTest {
    public static void main(String[] args) {
        A a = new A(){
            public void print() {
                System.out.println("print subclass");
            }
        };

        a.print();
    }
}

class A {
    void print(){
        System.out.println("print");
    }
}
