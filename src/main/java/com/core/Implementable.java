package com.core;

public interface Implementable {
    default public int getId() {
        return getNumber();
    }

    static void displayObjectDetails() {
        System.out.println("Dsiplay Implementable");
    }

    private static int getNumber(){
        return 0;
    }
}
