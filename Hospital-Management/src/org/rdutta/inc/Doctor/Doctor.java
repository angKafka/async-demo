package org.rdutta.inc.Doctor;

import org.rdutta.inc.Patient.Patient;
import org.rdutta.inc.reuseable.User;

import java.util.List;
import java.util.UUID;
import java.util.ArrayList;
import java.util.concurrent.BlockingQueue;

public class Doctor implements User, Runnable {
    private BlockingQueue<String> queue;
    private UUID id;
    private String name;
    private String email;
    private String phone;
    private List<Patient> patients;

    public Doctor(BlockingQueue<String> queue, String name, String email, String phone) {
        this.queue = queue;
        this.id = UUID.randomUUID();
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.patients = new ArrayList<>();
    }

    @Override
    public UUID getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public String getPhone() {
        return phone;
    }

    @Override
    public boolean isValid() {
        return getId() != null;
    }

    @Override
    public String generateBadgeNumber() {
        if (!isValid()) {
            return null;
        }
        return "DOC-" + UUID.randomUUID().toString().substring(0, 8);
    }


    public List<Patient> getAllPatients() {
        return new ArrayList<>(patients);
    }

    @Override
    public void run() {
        try {
            String patientBadgeNumber = queue.take();
            System.out.println("Doctor received patient badge number: " + patientBadgeNumber);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
