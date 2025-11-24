package com.core;

public class MyGenericClass<T> {
    private T obj;

    public MyGenericClass(T obj){
        this.obj = obj;
    }

    public void displayObjectDetails(){
        System.out.println("Object Type: " + obj.getClass().getTypeName());
    }

    public T getObject(){
        return obj;
    }
}
