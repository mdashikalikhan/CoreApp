package com.oop.proxy.user;

public class UserProxy {

    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();

        UserServiceProxy userServiceProxy = new UserServiceProxy(userService);

        userServiceProxy.addUser("RAHIM");
        userServiceProxy.addUser("JANE");
        userServiceProxy.removeUser("JANE");
    }
}
