package com.interview.sorting;

import java.math.BigDecimal;
import java.util.*;

public class SortingTest {

    public static void main(String[] args) {
        Comparator<Person> personComparator
                = (p1, p2)->{
            /*return p2.getSalary().compareTo(p1.getSalary());*/
            int comparedTo = p1.getSalary().compareTo(p2.getSalary());
            return comparedTo * -1;
        };



        Person p1 = new Person();
        p1.setName("ASHIK");
        p1.setSalary(BigDecimal.valueOf(6000.90));
        Person p2 = new Person();
        p2.setName("KHAN");
        p2.setSalary(BigDecimal.valueOf(600000));
        Person p3 = new Person();
        p3.setName("RAHIM");
        p3.setSalary(BigDecimal.valueOf(10000000));
        Person p4 = new Person();
        p4.setName("SAMSU");
        p4.setSalary(BigDecimal.valueOf(890));

        List<Person> personList = new ArrayList<>(
                Arrays.asList(p1, p2, p3, p4)
        );

        Collections.sort(personList, personComparator);

        System.out.println(personList);

    }
}
