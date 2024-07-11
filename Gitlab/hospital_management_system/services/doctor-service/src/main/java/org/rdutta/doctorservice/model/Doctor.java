package org.rdutta.doctorservice.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.UUID;

@Document(indexName = "doctor")
public class Doctor {
    @Id
    private UUID id;
    @Field(type = FieldType.Text, name = "firstname")
    private String firstName;
    @Field(type = FieldType.Text, name = "lastname")
    private String lastName;
    @Field(type = FieldType.Text, name = "email")
    private String email;
    @Field(type = FieldType.Text, name = "specialist")
    private String specialist;

    public Doctor() {}

    public Doctor(String firstName, String lastName, String email, String specialist) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.specialist = specialist;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
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

    public String getSpecialist() {
        return specialist;
    }

    public void setSpecialist(String specialist) {
        this.specialist = specialist;
    }

}
