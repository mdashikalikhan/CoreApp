package com.oop.dao;

import com.oop.database.DatabaseConnectionManager;
import com.oop.domain.Employee;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;


public class EmployeeDao {
    DatabaseConnectionManager connectionManager;

    Map<Long, Employee> employees;
    public EmployeeDao() {
        connectionManager = DatabaseConnectionManager.getInstance();
        employees  = new LinkedHashMap<>();
    }

    public void saveEmployee(Employee employee) {
        connectionManager.connect();
        employees.put(employee.getId(), employee);
        System.out.println("Save: " + employee);
        connectionManager.disconnect();
    }

    public void deleteEmployee(Employee employee) {

        connectionManager.connect();
        employees.remove(employee.getId());
        System.out.println("Delete: " + employee.getId());
        connectionManager.disconnect();
    }
}
