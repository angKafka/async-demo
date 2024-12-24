package org.rdutta.employee.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Employee {
    @Id
    private int id;
    private String name;
    private String surname;
    private String email;
    private String phone;
    private String address;
    private String city;
    private String state;
    private String zip;
    public Employee() {}
    private Employee(builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.surname = builder.surname;
        this.email = builder.email;
        this.phone = builder.phone;
        this.address = builder.address;
        this.city = builder.city;
        this.state = builder.state;
        this.zip = builder.zip;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getZip() {
        return zip;
    }

    public static class builder{
        private int id;
        private String name;
        private String surname;
        private String email;
        private String phone;
        private String address;
        private String city;
        private String state;
        private String zip;

        public builder id(int id) {
            this.id = id;
            return this;
        }
        public builder name(String name) {
            this.name = name;
            return this;
        }
        public builder surname(String surname) {
            this.surname = surname;
            return this;
        }
        public builder email(String email) {
            this.email = email;
            return this;
        }
        public builder phone(String phone) {
            this.phone = phone;
            return this;
        }
        public builder address(String address) {
            this.address = address;
            return this;
        }
        public builder city(String city) {
            this.city = city;
            return this;
        }
        public builder state(String state) {
            this.state = state;
            return this;
        }
        public builder zip(String zip) {
            this.zip = zip;
            return this;
        }
        public Employee build() {
            return new Employee(this);
        }
    }
}
