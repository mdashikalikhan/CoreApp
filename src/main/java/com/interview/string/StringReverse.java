package com.interview.string;


public class StringReverse {
    public static void main(String[] args) {
        String str1 = "Hello World";
        System.out.println(reverseString(str1));

    }

    private static String reverseString(String str) {
        char charArray[] = str.toCharArray();

        for(int i=0, j=charArray.length-1; i<j; i++, j--){
            char temp = charArray[i];
            charArray[i] = charArray[j];
            charArray[j] = temp;
        }

        return new String(charArray);
    }
}
