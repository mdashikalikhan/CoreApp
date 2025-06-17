package com.oop;

import com.oop.domain.Doctor;
import com.oop.domain.Employee;
import com.oop.domain.HospitalManagement;
import com.oop.domain.Nurse;

public class EmergencyRoomProcess {

    public static void main(String[] args) {
        HospitalManagement director = new HospitalManagement();

        Employee suzeel = new Nurse(1, "Suzeel",
                "emergency", true);

        director.callUpon(suzeel);

        Employee akram = new Doctor(2, "Akram",
                "emergency", true);

        director.callUpon(akram);

    }
}
