package com.interview.string;

public class StringOperation {
    public static void main(String[] args) {
        String s1  = "ABCD";

        System.out.println(s1.substring(1));

        System.out.println(s1.substring(0,1) + s1.substring(2));

        System.out.println(s1.substring(0, s1.length()-1));
    }

}
