package com.oop.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public abstract class Employee {
    private long id;
    private String name;
    private String department;
    private boolean working;

    public abstract void performDuties();


}
