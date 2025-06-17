package com.oop.database;

public class DatabaseConnectionManager {

    public void connect(){
        System.out.println("Connected to database...");
    }

    public void disconnect(){
        System.out.println("Disconnected from database...");
    }

    private DatabaseConnectionManager(){

    }

    public static DatabaseConnectionManager getInstance(){
        return new DatabaseConnectionManager();
    }
}
