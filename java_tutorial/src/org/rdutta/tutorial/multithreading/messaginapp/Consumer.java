package org.rdutta.tutorial.multithreading.messaginapp;

import java.util.concurrent.BlockingQueue;

class Consumer implements Runnable {
    private BlockingQueue<String> queue;

    public Consumer(BlockingQueue<String> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            String message;
            while (!(message = queue.take()).equals("END")) {
                System.out.println("Consumed: " + message);
                Thread.sleep(1000); // Simulate time taken to process a message
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

