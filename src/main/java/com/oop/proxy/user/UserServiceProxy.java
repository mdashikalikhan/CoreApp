package com.oop.proxy.user;

public class UserServiceProxy implements UserService{

    private UserService realUserService;

    public UserServiceProxy(UserService realUserService) {
        this.realUserService = realUserService;
    }

    @Override
    public void addUser(String userName) {
        System.out.println("[Proxy] Logging before adding user");
        realUserService.addUser(userName);
        System.out.println("[Proxy] Logging after adding user");
    }

    @Override
    public void removeUser(String userName) {
        System.out.println("[Proxy] Logging before removing user");
        realUserService.removeUser(userName);
        System.out.println("[Proxy] Logging after removing user");
    }
}
