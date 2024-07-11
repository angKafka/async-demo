package org.rdutta.jdbc.utils.crud;

import org.rdutta.jdbc.utils.core.IConfig;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;
import java.util.stream.Collectors;

public class AllEmployee implements IConfig {
    private UUID employeeId;
    private String firstname;
    private String lastname;
    private String gender;
    private String email;
    private String phone;
    private Date dob;

    public AllEmployee() {}
    public AllEmployee(String firstname, String lastname, String gender, String email, String phone, Date dob) {

        this.firstname = firstname;
        this.lastname = lastname;
        this.gender = gender;
        this.email = email;
        this.phone = phone;
        this.dob = dob;
    }

    public UUID getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(UUID employeeId) {
        this.employeeId = employeeId;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    @Override
    public String toString() {
        return "{" +
                "\nemployeeId='" + employeeId + '\'' +
                ", \nfirstName'" + firstname + '\'' +
                ", \nlastName'" + lastname + '\'' +
                ", \ngender='" + gender + '\'' +
                ", \nemail='" + email + '\'' +
                ", \nphone='" + phone + '\'' +"\n"+
                '}'+",\n";
    }

    @Override
    public String fetchAllEmployees() throws SQLException {
        List<AllEmployee> allEmployees = new ArrayList<AllEmployee>();
        try(Connection conn = DriverManager.getConnection(url, user, password)){
//            System.out.println("Database connection established");
            //Fetch the data by SELECT * FROM employee--Table
            Statement stmt = conn.createStatement();
            stmt.executeQuery("SELECT * FROM public.employee;");
            ResultSet rs = stmt.getResultSet();
            while(rs.next()){
                AllEmployee employee = new AllEmployee();
                employee.setEmployeeId(UUID.fromString(rs.getString("employee_id")));
                employee.setFirstname(rs.getString("firstname"));
                employee.setLastname(rs.getString("lastname"));
                employee.setGender(rs.getString("gender"));
                employee.setEmail(rs.getString("email"));
                employee.setPhone(rs.getString("phone"));
                employee.setDob(rs.getDate("dob"));
                allEmployees.add(employee);
            }
        }catch(SQLException e){
            System.out.println("Database connection failed"+e.getMessage());
        }
        return allEmployees.stream()
                .map(AllEmployee::toString)
                .collect(Collectors.joining());
    }

    @Override
    public String fetchEmployeeByName(String firstname) throws SQLException {
        List<AllEmployee> allEmployees = new ArrayList<>();

        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            String query = "SELECT * FROM public.employee WHERE firstname = ?;";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, firstname);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                AllEmployee employee = new AllEmployee();
                employee.setEmployeeId(UUID.fromString(rs.getString("employee_id")));
                employee.setFirstname(rs.getString("firstname"));
                employee.setLastname(rs.getString("lastname"));
                employee.setGender(rs.getString("gender"));
                employee.setEmail(rs.getString("email"));
                employee.setPhone(rs.getString("phone"));
                employee.setDob(rs.getDate("dob"));
                allEmployees.add(employee);
            }
        } catch (SQLException e) {
            System.out.println("Database connection failed: " + e.getMessage());
            throw e; // Rethrow the exception after logging the error
        }

        return allEmployees.stream()
                .filter(employee -> employee.getFirstname().equals(firstname))
                .map(AllEmployee::toString)
                .collect(Collectors.joining("\n"));
    }

    @Override
    public String createEmployee() throws SQLException {
        String query = "INSERT INTO employee(employee_id, firstname, lastname, gender, email, phone, dob) VALUES (uuid_generate_v4(), ?, ?, ?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setString(1, getFirstname());
            pstmt.setString(2, getLastname());
            pstmt.setString(3, getGender());
            pstmt.setString(4, getEmail());
            pstmt.setString(5, getPhone());
            pstmt.setDate(6, getDob());  // Assuming getDob() returns LocalDate

            int affectedRows = pstmt.executeUpdate();

            if (affectedRows > 0) {
                return "Employee created successfully.";
            } else {
                return "Failed to create employee.";
            }

        } catch (SQLException e) {
            e.printStackTrace();
            throw new SQLException("Error creating employee.", e);
        }
    }

    @Override
    public String updateEmployee(String column, String updateData, UUID employee_id) throws SQLException {
        String query = "";
        setEmployeeId(employee_id);
        switch (column.toLowerCase()) {
            case "firstname":
                setFirstname(updateData);
                query = "UPDATE employee SET firstname = ? WHERE employee_id = ?";
                break;
            case "lastname":
                setLastname(updateData);
                query = "UPDATE employee SET lastname = ? WHERE employee_id = ?";
                break;
            case "gender":
                setGender(updateData);
                query = "UPDATE employee SET gender = ? WHERE employee_id = ?";
                break;
            case "email":
                setEmail(updateData);
                query = "UPDATE employee SET email = ? WHERE employee_id = ?";
                break;
            case "phone":
                setPhone(updateData);
                query = "UPDATE employee SET phone = ? WHERE employee_id = ?";
                break;
            default:
                return "Invalid column name.";
        }

        if (query.isEmpty()) {
            return "Invalid column name.";
        }

        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setString(1, updateData);
            pstmt.setObject(2, getEmployeeId()); // Assuming you have a method to get the employee ID

            int affectedRows = pstmt.executeUpdate();

            if (affectedRows > 0) {
                return "Employee updated successfully.";
            } else {
                return "Failed to update employee.";
            }

        } catch (SQLException e) {
            e.printStackTrace();
            throw new SQLException("Error updating employee.", e);
        }
    }

    @Override
    public String DeleteAllEmployees() throws SQLException {
        String log = "";
        try (Connection conn = DriverManager.getConnection(url, user, password);){
            String query = "DELETE FROM employee";
            PreparedStatement pstmt = conn.prepareStatement(query);
            int affectedRows = pstmt.executeUpdate();
            if (affectedRows > 0) {
                log = "All employees deleted successfully.";
            }else{
                log = "Failed to delete all employees.";
            }
        }

        return "All employees deleted successfully.";
    }

}
