package com.interview;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Interview2 {

    public static void main(String[] args) {
        /*int[] arr = {1, 2, 3, 4, 2, 5, 1};

        Set<Integer> set = new HashSet<>();
        int[] result = Arrays.stream(arr).filter(i -> !set.add(i)).toArray();

        Arrays.stream(result).forEach(System.out::println);*/

        int[] arr = {3, 5, 7, 2, 8};

        int max = Integer.MIN_VALUE;

        for(int i: arr){
            if(max<i){
                max = i;
            }
        }

        System.out.println(max);
    }


}
