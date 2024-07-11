package org.rdutta.inc.Patient;

import org.rdutta.inc.reuseable.User;

import java.util.UUID;
import java.util.concurrent.BlockingQueue;

public class Patient implements User, Runnable{
    private BlockingQueue<String> queue;
    private UUID id;
    private String name;
    private String email;
    private String phone;

    public Patient(BlockingQueue<String> queue) {
        this.queue = queue;
    }

    public Patient(BlockingQueue<String> queue, String name, String email, String phone) {
        this.queue = queue;
        this.id = UUID.randomUUID();
        this.name = name;
        this.email = email;
        this.phone = phone;
    }
    @Override
    public UUID getId() {
        return UUID.randomUUID();
    }

    @Override
    public String getName() {
        return "Anil Chauhan";
    }

    @Override
    public String getEmail() {
        return "achauhan@gmail.com";
    }

    @Override
    public String getPhone() {
        return "889-445-8790";
    }

    @Override
    public boolean isValid() {
        return getId() != null;
    }

    @Override
    public String generateBadgeNumber() {
        return "PAT-"+UUID.randomUUID().toString().substring(0,8);
    }

    @Override
    public void run() {
        try {
            queue.put(generateBadgeNumber());
        }catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
