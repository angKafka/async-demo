package org.rdutta.tutorial.multithreading.messaginapp;

import java.util.concurrent.BlockingQueue;

class Producer implements Runnable {
    private BlockingQueue<String> queue;

    public Producer(BlockingQueue<String> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 10; i++) {
                String message = "Message " + i;
                queue.put(message);
                System.out.println("Produced: " + message);
                Thread.sleep(500); // Simulate time taken to produce a message
            }
            queue.put("END"); // Indicate end of messages
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
