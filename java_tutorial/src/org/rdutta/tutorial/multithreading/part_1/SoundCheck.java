package org.rdutta.tutorial.multithreading.part_1;

public class SoundCheck {
    public static void main(String[] args) {
        Dog d = new Dog();
        Cat c = new Cat();

        d.start();
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        c.start();
    }
}
