package com.interview.MVITech;

public class Q929 {

    public static void main(String[] args) {
        Runnable r = new Runnable() {
            @Override
            public void run() {
                Work.doIt();
            }
        };

        Thread t = new Thread(){
            public void start(){
                Work.doIt();
            }
        };
        t.start();

        A x = new A();

        B y = new B();

        C z = new C();

        x = y;

        //z = (C) x;

        y = (B) x;

        //z = (C) y;

        //y = (A )y;

        System.out.hashCode();

        System.out.println("".hashCode());

        //System.out.println(42.hashCode());

        System.out.println(("4"+2).equals(42));

        System.out.println((new java.util.Vector()).hashCode());

    }


}

class A {}

class B extends A {}

class C extends A {}

class Work{
    static void doIt(){
        System.out.println("doIt");
    }
}

