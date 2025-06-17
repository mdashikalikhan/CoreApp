package com.interview.collection;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class KLargestElement {
    public static void main(String[] args) {
        int[] numbers = {3, 1, 5, 12, 2, 11, 11, 6, 13, 4, 8};
        int k = 4;

        KLargestElement(numbers, k);
    }

    public static void KLargestElement(int[] numbers, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->b-a);

        for(int n : numbers) {
            pq.add(n);
            /*if(pq.size()>k){
                pq.poll();
            }*/
        }


        for(int i=0;i<k;i++) {
            System.out.println(pq.poll());
        }

        /*while (!pq.isEmpty()) {
            System.out.println(pq.poll());
        }*/



    }
}
