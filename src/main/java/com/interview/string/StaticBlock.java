package com.interview.string;

public class StaticBlock {

    int i;
    public StaticBlock(){
        System.out.println("Constructor StaticBlock");
    }

    {
        System.out.println("Anonymous block.. i = " + i);
    }
    static{
        System.out.println("Static block 1");
    }

    static{
        System.out.println("Static block 2");
    }

    public static void main(String[] args) {
        String s1 = "ABCDEFGHI";

        System.out.println(s1.substring(0,0));

        System.out.println(s1.substring(1));

        StaticBlock staticBlock = new StaticBlock();

        staticBlock = new StaticBlock();
    }
}
