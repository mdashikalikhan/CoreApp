package com.oop.domain;

public class SorroundSoundSystem implements Device{
    @Override
    public void turnOn() {
        System.out.println("Turning on sound system");
    }

    @Override
    public void turnOff() {
        System.out.println("Turning off sound system");
    }
}
