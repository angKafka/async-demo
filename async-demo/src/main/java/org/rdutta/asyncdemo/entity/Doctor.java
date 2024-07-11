package org.rdutta.asyncdemo.entity;


import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table(name = "doctor")
public class Doctor {
    @Id
    @Column(value = "doctor_id")
    private int doctor_id;
    @Column(value = "doctor_name")
    private String doctor_name;
    @Column(value = "specialization")
    private String specialization;
    @Column(value = "doctor_degree")
    private String degree;
    @Column(value = "ratings")
    private String ratings;

    public Doctor() {}

    public Doctor(String doctor_name, String specialization, String degree, String ratings) {
        this.doctor_name = doctor_name;
        this.specialization = specialization;
        this.degree = degree;
        this.ratings = ratings;
    }

    public int getDoctor_id() {
        return doctor_id;
    }

    public void setDoctor_id(int doctor_id) {
        this.doctor_id = doctor_id;
    }

    public String getDoctor_name() {
        return doctor_name;
    }

    public void setDoctor_name(String doctor_name) {
        this.doctor_name = doctor_name;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getRatings() {
        return ratings;
    }

    public void setRatings(String ratings) {
        this.ratings = ratings;
    }
}
