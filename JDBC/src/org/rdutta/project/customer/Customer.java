package org.rdutta.project.customer;

import org.rdutta.project.utils.features.ConnectionValidation;

import java.sql.*;
import java.time.Instant;
import java.util.Date;
import java.util.Scanner;
import java.util.UUID;
import java.util.concurrent.BlockingQueue;

public class Customer extends ConnectionValidation implements Runnable {
    private UUID customerId;
    private UUID restaurantId;
    private UUID orderId;
    private String customerName;
    private String customerPassword;
    private String role;
    private String products;
    private String customerEmail;
    private String customerPhone;
    private String customerAddress;
    private Integer deliveryTime;
    private BlockingQueue<Customer> customerOrderQueue;

    public Customer(UUID customerId, UUID restaurantId, String customerName, String customerEmail, String customerPassword, String customerPhone, String products, String customerAddress, Integer deliveryTime, String role, UUID orderId, BlockingQueue<Customer> customerOrderQueue) {
        this.customerId = customerId;
        this.restaurantId = restaurantId;
        this.role = role;
        this.products = products;
        this.customerPassword = customerPassword;
        this.customerName = customerName;
        this.customerEmail = customerEmail;
        this.customerPhone = customerPhone;
        this.customerAddress = customerAddress;
        this.deliveryTime = deliveryTime;
        this.orderId = orderId;
        this.customerOrderQueue = customerOrderQueue;
    }

    public UUID getCustomerId() {
        return customerId;
    }

    public UUID getRestaurantId() {
        return restaurantId;
    }

    public String getRole() {
        return role;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public Integer getDeliveryTime() {
        return deliveryTime;
    }

    public String getCustomerPassword() {
        return customerPassword;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getProducts() {
        return products;
    }

    public UUID getOrderId() {
        return orderId;
    }

    public boolean isUserPresent() throws SQLException {
        String query = "SELECT customername FROM customer WHERE email = ?";

        try (Connection connection = DriverManager.getConnection(jdbcURI, user, password);
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, getCustomerEmail());
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                return resultSet.next();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
    }

    public String createCustomer() throws SQLException {
        String insertCustomerSQL = "INSERT INTO customer (customer_id, restaurant_id, approle, products, customername, customerpassword, email, phone, customeraddress, deliverytime) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";

        try (Connection connection = DriverManager.getConnection(jdbcURI, user, password);
             PreparedStatement preparedStatement = connection.prepareStatement(insertCustomerSQL)) {

            preparedStatement.setObject(1, getCustomerId());
            preparedStatement.setObject(2, getRestaurantId());
            preparedStatement.setString(3, getRole());
            preparedStatement.setString(4, getProducts());
            preparedStatement.setString(5, getCustomerName());
            preparedStatement.setString(6, getCustomerPassword());
            preparedStatement.setString(7, getCustomerEmail());
            preparedStatement.setString(8, getCustomerPhone());
            preparedStatement.setString(9, getCustomerAddress());
            preparedStatement.setInt(10, getDeliveryTime());

            int affectedRows = preparedStatement.executeUpdate();
            if (affectedRows > 0) {
                return "Successfully created customer";
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
        return "Customer can't be created.";
    }

    public boolean isAppUser() throws SQLException {
        String query = "SELECT approle FROM customer WHERE email = ?";

        try (Connection connection = DriverManager.getConnection(jdbcURI, user, password);
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, getCustomerEmail());
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    String appRole = resultSet.getString("approle");
                    return "appuser".equals(appRole);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
        return false;
    }

    public String makeUserAppUser() throws SQLException {
        String updateUserSQL = "UPDATE customer SET approle = ? WHERE email = ?";

        try (Connection connection = DriverManager.getConnection(jdbcURI, user, password);
             PreparedStatement preparedStatement = connection.prepareStatement(updateUserSQL)) {

            preparedStatement.setString(1, "appuser");
            preparedStatement.setString(2, getCustomerEmail());
            int affectedRows = preparedStatement.executeUpdate();
            if (affectedRows > 0) {
                return "Successfully made user app user";
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
        return "Failed to make user app user";
    }

    @Override
    public void run() {
        try (Connection connection = DriverManager.getConnection(jdbcURI, user, password)) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter your name: ");
            String yourName = scanner.next();
            System.out.println("Hello, " + yourName + ",\n" + Date.from(Instant.now()));
            System.out.println("\nWelcome to orderApp\nChoose any one of the options:\n1. signup\n2. login\n, before you proceed for order.");

            String choice = scanner.next();

            switch (choice) {
                case "signup":
                    if (!isUserPresent()) {
                        System.out.println(createCustomer());
                    } else {
                        System.out.println("User already present.");
                    }
                    break;
                case "login":
                    if (isUserPresent()) {
                        if (isAppUser()) {
                            System.out.println("User is already an app user.");
                        } else {
                            System.out.println(makeUserAppUser());
                        }
                    } else {
                        System.out.println("User not present.");
                    }
                    break;
                default:
                    System.out.println("Invalid option.");
                    return;
            }

            // Always show order options after signup or login
            System.out.println("Here are the list of products:\n");
            System.out.println(showProductList() + "\n");

            System.out.println("Proceed to Order: \n" + "\n1. PlaceOrder" + "\n2. CancelOrder");
            String orderOption = scanner.next();
            switch (orderOption) {
                case "1":
                    System.out.println(placeOrder());
                    break;
                case "2":
                    System.out.println(cancelOrder());
                    break;
                default:
                    System.out.println("Invalid option.");
                    break;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public String placeOrder() throws SQLException {
        String insertOrderSQL = "INSERT INTO orderapp ("
                + "orderapp_id, "
                + "customer_id, "
                + "restaurant_id, "
                + "products, "
                + "orderstatus, "
                + "orderdate"
                + ") VALUES ("
                + "uuid_generate_v4(), "
                + "?, "
                + "?, "
                + "ARRAY[?]::TEXT[], "
                + "?, "
                + "?"
                + ");";
        try (Connection connection = DriverManager.getConnection(jdbcURI, user, password);
             PreparedStatement preparedStatement = connection.prepareStatement(insertOrderSQL)) {
            preparedStatement.setObject(1, getCustomerId());
            preparedStatement.setObject(2, getRestaurantId());
            preparedStatement.setString(3, getProducts());
            preparedStatement.setString(4, "Pending");
            preparedStatement.setTimestamp(5, Timestamp.from(Instant.now()));
            int affectedRows = preparedStatement.executeUpdate();
            if (affectedRows > 0) {
                customerOrderQueue.put(this); // Add this customer to the queue
                return "Successfully placed order";
            }
        } catch (SQLException | InterruptedException e) {
            e.printStackTrace();
        }
        return "Order can't be placed.";
    }

    public String allOrders() throws SQLException {
        String orderDetails = "SELECT orderapp.orderapp_id, orderapp.customer_id, orderapp.products, orderapp.orderstatus, orderapp.orderdate FROM orderapp " +
                "JOIN customer ON orderapp.customer_id = customer.customer_id ORDER BY orderdate ASC;";
        try (Connection connection = DriverManager.getConnection(jdbcURI, user, password);
             PreparedStatement preparedStatement = connection.prepareStatement(orderDetails)) {
            preparedStatement.setObject(1, getCustomerId());
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                System.out.println("Order Id: " + resultSet.getString("orderapp_id") + "\n" +
                        "Customer Id: " + resultSet.getString("customer_id") + "\n" +
                        "Products: " + resultSet.getString("products") + "\n" +
                        "Status: " + resultSet.getString("orderstatus") + "\n" +
                        "Date Of Order: " + resultSet.getString("orderdate"));
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
            throw sqlException;
        }
        return "Order can't be placed.";
    }

    public String cancelOrder() throws SQLException {
        String deleteOrderSQL = "DELETE FROM orderapp WHERE orderapp_id = ?;";
        try (Connection connection = DriverManager.getConnection(jdbcURI, user, password);
             PreparedStatement preparedStatement = connection.prepareStatement(deleteOrderSQL)) {
            preparedStatement.setObject(1, getOrderId());
            int affectedRows = preparedStatement.executeUpdate();
            if (affectedRows > 0) {
                return "Successfully cancelled order";
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
            throw sqlException;
        }
        return "Order can't be cancelled.";
    }

    public void setOrderQueue(BlockingQueue<Customer> orderQueue) {
        this.customerOrderQueue = orderQueue;
    }

    private String showProductList() {
        // Here you can query your products from the database or return a static list for simplicity
        return "1. Cheeseburger\n2. Veggie Pizza\n3. Grilled Chicken\n4. Caesar Salad";
    }
}
