package org.rdutta.project.restaurant.core;

import org.rdutta.project.customer.Customer;
import org.rdutta.project.restaurant.utilities.IRestaurant;
import org.rdutta.project.utils.features.ConnectionValidation;

import java.sql.*;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Restaurant extends ConnectionValidation implements IRestaurant, Runnable {

    private UUID restaurantId;
    private String validityToken;
    private String restaurantName;
    private List<String> products;
    private String restaurantDomain;
    private String restaurantAddress;
    private String contact;

    BlockingQueue<Customer> queueCustomer = new LinkedBlockingQueue<>();

    public Restaurant() {}

    public Restaurant(UUID restaurantId, String validityToken, String restaurantName, List<String> products, String restaurantDomain, String restaurantAddress, String contact) {
        this.restaurantId = restaurantId;
        this.validityToken = validityToken;
        this.restaurantName = restaurantName;
        this.products = products;
        this.restaurantDomain = restaurantDomain;
        this.restaurantAddress = restaurantAddress;
        this.contact = contact;
    }

    public UUID getRestaurantId() {
        return restaurantId;
    }

    public String getValidityToken() {
        return validityToken;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public List<String> getProducts() {
        return products;
    }

    public String getRestaurantDomain() {
        return restaurantDomain;
    }

    public String getRestaurantAddress() {
        return restaurantAddress;
    }

    public String getContact() {
        return contact;
    }

    @Override
    public String insertRestaurantData() throws SQLException {
        String log = "";
        try (Connection connection = DriverManager.getConnection(jdbcURI, user, password)) {
            if (!getConnectionDetails()) {
                log = "Get Connection Fixed!!";
            } else {
                String query = "INSERT INTO restaurant(restaurant_id, validitytoken, restaurantname, products, restaurantdomain, restaurantaddress, phone) VALUES (uuid_generate_v4(),?,?,?,?,?,?)";
                PreparedStatement ps = connection.prepareStatement(query);

                // Converting List<String> products to PostgreSQL TEXT[] array
                Array productArray = connection.createArrayOf("TEXT", products.toArray(new String[0]));

                ps.setString(1, getValidityToken());
                ps.setString(2, getRestaurantName());
                ps.setArray(3, productArray);  // Set the TEXT[] array
                ps.setString(4, getRestaurantDomain());
                ps.setString(5, getRestaurantAddress());
                ps.setString(6, getContact());

                ps.executeUpdate();
                log = "Insert Restaurant Data";
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return log;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Customer order = queueCustomer.take();
                System.out.println("Processing Order for Customer ID: " + order.getCustomerId());
                System.out.println("Customer Name: " + order.getCustomerName());
                System.out.println("Ordered Products: " + order.getProducts());
                System.out.println("Customer Email: " + order.getCustomerEmail());
                System.out.println("Customer Address: " + order.getCustomerAddress());
                System.out.println("Customer Phone: " + order.getCustomerPhone());
                System.out.println("Delivery Time: " + order.getDeliveryTime());

                Thread.sleep(1000); // Simulate processing time
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void setQueueCustomer(BlockingQueue<Customer> queueCustomer) {
        this.queueCustomer = queueCustomer;
    }
}
