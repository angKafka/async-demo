package org.rdutta.tutorial.multithreading.part_2;

public class Cat implements Runnable{

    @Override
    public void run(){
        for (int i = 0; i < 5; i++) {
            System.out.println("meow");
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
