package com.interview.interfaces;

public class InterfaceTest {
    public static void main(String[] args) {
        Interface1 interface1 = (x,y)->x+y;

        System.out.println(interface1.sum(100,200));

    }
}
