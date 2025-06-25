package com.interview.cp;

import java.util.Arrays;
import java.util.stream.Collectors;

public class MergeString {
    public static void main(String[] args) {
        String word1 = "abc", word2 = "pqrzxc";

        StringBuilder sb = new StringBuilder();

        int min = Math.min(word1.length(), word2.length());

        int i=0;

        while (i < min) {
            sb.append( word1.charAt(i));
            sb.append( word2.charAt(i));
            i++;

        }

        while (i < word1.length()) {
            sb.append( word1.charAt(i));
            i++;
        }

        while (i < word2.length()) {
           sb.append( word2.charAt(i));
            i++;
        }

        System.out.println(sb.toString());


    }
}
