package com.interview.number;

public class SecondLargest {
    public static void main(String[] args) {
        System.out.println(findSecondLargest(new int[]{10,10,10,-10}));

        System.out.println(findSecondLargest(new int[]{1,2,2,3,3,4,4,5,1000,900,1000, 900}));
    }

    public static int findSecondLargest(int[] arr) {
        if(arr == null || arr.length <2){
            throw new IllegalArgumentException("Array must contain at least 2 elements");
        }
        int second = Integer.MIN_VALUE;
        int first = Integer.MIN_VALUE;

        for(int num:arr){
            if(num > first){
                second = first;
                first = num;
            } else if(num > second && num!=first){
                second = num;
            }
        }

        if(second == Integer.MIN_VALUE){
            throw new IllegalArgumentException("All elements are equal");
        }

        return second;

    }
}
