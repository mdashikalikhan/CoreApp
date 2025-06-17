package com.oop.domain;

public class RemoteControl {

    private Device connectedDevice;

    private static final RemoteControl instance
            = new RemoteControl();

    private RemoteControl() {

    }

    public static RemoteControl getInstance() {
        return instance;
    }

    public  void connectToDevice(Device device){
         instance.connectedDevice = device;
        System.out.println("Connected to device: " +
                device.getClass().getSimpleName());
    }

    public void pressPowerOn(){
        connectedDevice.turnOn();
    }

    public void pressPowerOff(){
        connectedDevice.turnOff();
    }

}
