package com.oop.domain;

public class Doctor extends Employee{
    public Doctor(long id, String name, String department, boolean working) {
        super(id, name, department, working);
        System.out.println("Doctor constructor");
    }

    @Override
    public void performDuties() {
        prescribeMedicine();
        diagnosePatients();
    }

    private void prescribeMedicine(){
        System.out.println("Prescribing Medicine");
    }

    private void diagnosePatients(){
        System.out.println("Diagnosing patients");
    }
}
