package com.interview;

import java.util.Arrays;
import java.util.List;

public class Interview1 {
    public static void main(String[] args) {

        System.out.println(iterativeFactorial(5));

        System.out.println(recursiveFactorial(5));

        System.out.println(isPalindrome("ABCD") + "   ");

        System.out.println(isPalindrome("ABA") + "  "  + isPalindrome("AAA"));

        List<String> names = Arrays.asList("Alice", "Ankit", "Bob", "Arjun");

        names.stream().filter(s->s.startsWith("A")).forEach(System.out::println);

    }


    static boolean isPalindrome( String s){

        for(int left=0, right=s.length()-1; left<right; left++, right-- ){
            if(s.charAt(left)!=s.charAt(right)){
                return false;
            }
        }

        return true;
    }
    static long iterativeFactorial(int n){
        long l= 1l;

        for(int i=n;i>=1; i--){
            l *= i;

        }
        return l;


    }

    static long recursiveFactorial(int n){
        if(n==1){
            return n;
        }

        return n * recursiveFactorial(n-1);

    }
}
