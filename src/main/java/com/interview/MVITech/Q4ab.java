package com.interview.MVITech;

public class Q4ab {

    public void foo() {
        /*try{
            bar();
        } finally{
            baz();
        } catch (MyException e){

        }*/
    }
    public void bar() throws MyException {
        throw new MyException();
    }

    public void baz() throws RuntimeException {
        throw new RuntimeException();
    }
}

class MyException extends Exception {}
