package org.rdutta.passport_automation_system.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "APPLICATION")
public class Application {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "application_id")
    private Integer id;
    @Column(name = "status")
    private String status;
    @Column(name = "applicant_id")
    private Integer applicant_id;


    public Application() {}
    public Application(String status, Integer applicant_id) {
        this.status = status;
        this.applicant_id = applicant_id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    public Integer getApplicant_id() {
        return applicant_id;
    }
    public void setApplicant_id(Integer applicant_id) {
        this.applicant_id = applicant_id;
    }
}
