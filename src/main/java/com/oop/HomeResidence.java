package com.oop;

import com.oop.domain.Projector;
import com.oop.domain.RemoteControl;
import com.oop.domain.SorroundSoundSystem;
import com.oop.domain.TV;

public class HomeResidence {

    public static void main(String[] args) {
        TV tv = new TV();
        Projector projector = new Projector();
        SorroundSoundSystem sorroundSoundSystem = new SorroundSoundSystem();

        RemoteControl remoteControl = RemoteControl.getInstance();
        remoteControl.connectToDevice(tv);
        remoteControl.pressPowerOn();
        remoteControl.pressPowerOff();

        remoteControl.connectToDevice((projector));

        remoteControl.pressPowerOn();
        remoteControl.pressPowerOff();

        remoteControl.connectToDevice((sorroundSoundSystem));
        remoteControl.pressPowerOn();
        remoteControl.pressPowerOff();
    }
}
