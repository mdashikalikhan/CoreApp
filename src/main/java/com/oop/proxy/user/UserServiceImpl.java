package com.oop.proxy.user;

public class UserServiceImpl implements UserService {
    @Override
    public void addUser(String userName) {
        System.out.println("User added: " + userName);
    }

    @Override
    public void removeUser(String userName) {
        System.out.println("User removed: " + userName);
    }
}
