package com.interview.hashing;

import java.util.ArrayList;
import java.util.List;

public class HashCodeCollisionExample {
    public static void main(String[] args) {
        String str1 = "FB";
        String str2 = "Ea";

        System.out.println(str1.hashCode());
        System.out.println(str2.hashCode());
        System.out.println(str1.equals(str2));

    }
}
