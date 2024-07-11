package org.rdutta.tutorial.encapsulation;

import java.util.UUID;

public class Person {
    private UUID person_uid;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String dob;

    public UUID getPerson_uid() {
        person_uid = UUID.randomUUID();
        return person_uid;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String assignTeamToPerson(String team) {
        return "\nPersonID: " + getPerson_uid() + "\nFirst Name: " + getFirstName() + "\nLast Name: " + getLastName() + "\nEmail: " + getEmail() + "\nPhoneFeatures: " + getPhone() + "\nDob: " + getDob() + "\nTeam: " + team;
    }
}
