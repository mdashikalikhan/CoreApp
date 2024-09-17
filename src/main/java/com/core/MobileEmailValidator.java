package com.core;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MobileEmailValidator {
    public static void main(String[] args) {
        String emailPattern = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";
        String mobilePattern = "^(\\+8801)[0-9]{9}$";
        System.out.println(Pattern.matches(emailPattern, "khan.ashik@gmail.com"));
        System.out.println(Pattern.matches(emailPattern, "01777401985"));

        Pattern p = Pattern.compile(mobilePattern);

        Matcher matcher = p.matcher("+8801777401985");

        System.out.println(matcher.matches());


    }
}
