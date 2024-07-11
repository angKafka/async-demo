package org.rdutta.tutorial.multithreading.part_2;

public class SoundCheck {
    public static void main(String[] args) {
        Runnable d = new Dog();
        Runnable c = new Cat();

        Thread t1 = new Thread(d);
        Thread t2 = new Thread(c);
        t1.start();
        t2.start();
    }
}
