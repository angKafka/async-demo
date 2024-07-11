package org.rdutta.tutorial.interface_training;

import java.time.LocalDateTime;

public class Person extends AirAsia{
    private String firstName;
    private String lastName;

    public String fullName(String firstName, String lastName) {
        return firstName + " " + lastName;
    }
    public static void main(String[] args) {
        Person personObject = new Person();
        personObject.registerPlainByUUID(personObject.getPlain_UID());
        personObject.setFlightTimings(LocalDateTime.now());
        System.out.println("Hello "+personObject.fullName("Raj", "Dutta")+",\n");
        System.out.println("====================================");
        System.out.println(personObject.showFlightDetails());
    }
}
