package org.rdutta.assignment.entities;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "GUEST")
public class Guest {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "GUEST_ID")
    private UUID guest_id;
    @Column(name = "FIRST_NAME")
    private String first_name;
    @Column(name = "LAST_NAME")
    private String last_name;
    @Column(name = "GENDER")
    private String gender;
    @Column(name = "USERNAME")
    private String username;
    @Column(name = "EMAIL_ADDRESS")
    private String email_address;
    @Column(name = "PASSWORD")
    private String password;
    @Column(name = "ADDRESS")
    private String address;
    @Column(name = "COUNTRY")
    private String country;
    @Column(name = "CITY")
    private String city;
    @Column(name = "STATE")
    private String state;
    @Column(name = "PHONE_NUMBER")
    private String phone_number;
    @Column(name = "ACTIVE")
    private int active;

    public UUID getGuest_id() {
        return guest_id;
    }

    public void setGuest_id(UUID guest_id) {
        this.guest_id = guest_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail_address() {
        return email_address;
    }

    public void setEmail_address(String email_address) {
        this.email_address = email_address;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "Guest{" +
                "guest_id=" + guest_id +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", gender='" + gender + '\'' +
                ", username='" + username + '\'' +
                ", email_address='" + email_address + '\'' +
                ", password='" + password + '\'' +
                ", address='" + address + '\'' +
                ", country='" + country + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", phone_number='" + phone_number + '\'' +
                ", active=" + active +
                '}';
    }
}
