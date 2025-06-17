package com.oop.domain;

public class SmartPhoneManufacturingProcess
        extends GeneralManufacturingProcess {

    public SmartPhoneManufacturingProcess(String processName) {
        super(processName);
    }

    @Override
    protected void assembleDevice() {
        System.out.println("smartphone assembled");
    }

    @Override
    protected void testDevice() {
        System.out.println("smartphone tested");
    }

    @Override
    protected void packageDevice() {
        System.out.println("smartphone packaged");
    }

    @Override
    protected void storeDevice() {
        System.out.println("smartphone stored");
    }
}
