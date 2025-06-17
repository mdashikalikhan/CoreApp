package com.oop.proxy.dynamic;

import com.oop.proxy.user.UserService;
import com.oop.proxy.user.UserServiceImpl;

import java.lang.reflect.Proxy;

public class DynamicUserProxy {

    public static void main(String[] args) {
        UserService realService = new UserServiceImpl();

        UserService proxy = (UserService) Proxy.newProxyInstance(
                UserService.class.getClassLoader(),
                new Class[]{UserService.class},
                new LoggingHandler(realService)
        );

        proxy.addUser("HI");
        proxy.removeUser("ABN");
    }
}
