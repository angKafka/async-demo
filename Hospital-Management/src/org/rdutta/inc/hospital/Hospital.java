package org.rdutta.inc.hospital;

import org.rdutta.inc.Doctor.Doctor;
import org.rdutta.inc.Patient.Patient;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Hospital {
    public static void main(String[] args) {
        BlockingQueue<String> queue = new LinkedBlockingQueue<String>();
        Doctor doctor = new Doctor(queue, "Raj Kumar", "rdutta@orderapp.com", "799-220-4910");
        Patient patient = new Patient(queue, "Anil Chauhan", "achauhan@gmail.com", "889-445-8790");

        Thread doctorThread = new Thread(doctor);
        Thread patientThread = new Thread(patient);

        doctorThread.start();
        patientThread.start();

        try {
            doctorThread.join();
            patientThread.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
