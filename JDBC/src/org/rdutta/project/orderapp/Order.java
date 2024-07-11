package org.rdutta.project.orderapp;

import org.rdutta.project.customer.Customer;
import org.rdutta.project.restaurant.core.Restaurant;

import java.sql.SQLException;
import java.util.UUID;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Order {

    public static void main(String[] args) throws SQLException, InterruptedException {
        BlockingQueue<Customer> orderQueue = new LinkedBlockingQueue<>();

        Restaurant restaurant = new Restaurant();
        restaurant.setQueueCustomer(orderQueue);

        Customer customer = new Customer(
                UUID.randomUUID(),
                UUID.fromString("7f30acc4-1119-44f0-a59f-38da17b3e44e"),
                "Raj",
                "rdutta@orderapp.com",
                "Prerna@123",
                "7992204910",
                "Cheeseburger",
                "20th Cross Road",
                10,
                "localuser",
                UUID.randomUUID(),
                orderQueue
        );
        customer.setOrderQueue(orderQueue);

        Thread customerThread = new Thread(customer);
        Thread restaurantThread = new Thread(restaurant);

        customerThread.start();
        restaurantThread.start();

        customerThread.join();
        restaurantThread.join();
    }
}
