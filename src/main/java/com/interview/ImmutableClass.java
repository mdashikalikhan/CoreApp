package com.interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ImmutableClass {

    private List<String> stringList;

    public ImmutableClass(List<String> stringList) {

        this.stringList = new ArrayList<>();
        stringList.stream().forEach(s->this.stringList.add(s));
    }

    public List<String> getStringList() {
        return stringList.stream().toList();
    }

    public static void main(String[] args) {
        List<String> myList = new ArrayList<>(){
            {
                add("123");
                add("456");
                add("789");
            }
        };

        ImmutableClass immutableClass = new ImmutableClass(myList);
        List<String> list = immutableClass.getStringList();

        System.out.println(list);
        list.add("abc");

        System.out.println(immutableClass.getStringList());
    }
}
