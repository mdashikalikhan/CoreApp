package com.interview.cp;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KthSum {

    public static void main(String[] args) {
        int[] nums = {3,1,5,12,2,2,5,11, 12};
        int k = 3;

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int n: nums){
            if(pq.size()<k){
                pq.add(n);
            } else{
                if(pq.peek()<n){
                    pq.poll();
                    pq.add(n);
                }
            }
        }

        int sum = pq.stream().reduce(0, (a,b)->a+b);
        System.out.println(sum);
    }
}
