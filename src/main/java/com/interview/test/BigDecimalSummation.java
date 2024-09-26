package com.interview.test;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class BigDecimalSummation {
    public static void main(String[] args) {
        BigDecimal add = BigDecimal.valueOf(2.741).add(BigDecimal.valueOf(0.484));
        BigDecimal total = BigDecimal.valueOf(3.225);
        if(add.compareTo(total)==0){
            System.out.println("Equal");
        }

        List<BigDecimal> l = Arrays.asList(BigDecimal.valueOf(2.741), BigDecimal.valueOf(0.484));
        BigDecimal sum = l.stream().reduce(BigDecimal.ZERO, (a, b) -> a.add(b));
        System.out.println(sum);
    }

}
