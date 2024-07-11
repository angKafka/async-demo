package org.rdutta.tutorial.multithreading.part_1;

public class Dog extends Thread {
    public void run(){
        for (int i = 0; i < 5; i++) {
            System.out.println("bow");
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
