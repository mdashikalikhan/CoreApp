package com.interview.collection;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

public class FailFastOrSafe {
    public static void main(String[] args) {
        CopyOnWriteArrayList<Integer> list = new CopyOnWriteArrayList<>(
                List.of(100,200,300,400,500,600,700,800,900)
        );

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
            list.remove(i);
            //System.out.println(list.get(i));
        }

        CopyOnWriteArraySet<Integer> set = new CopyOnWriteArraySet<>(
                List.of(100,200,300,400,500,600,700,800,900)
        );

        for(Integer i : set) {
            System.out.println(i);
            set.remove(i);
        }

        System.out.println(set.size());
    }
}
