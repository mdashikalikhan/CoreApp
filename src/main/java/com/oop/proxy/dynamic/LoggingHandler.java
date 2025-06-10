package com.oop.proxy.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class LoggingHandler implements InvocationHandler {

    private Object target;

    public LoggingHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("[dynamic proxy] before: " + method.getName());

        Object result = method.invoke(target, args);

        System.out.println("[dynamic proxy] after: " + method.getName());

        return result;
    }
}
