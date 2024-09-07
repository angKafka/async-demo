package org.rdutta.passport_automation_system.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "PASSPORT")
public class Passport {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "passport_number")
    private UUID passportNumber;

    @Column(name = "issued_on")
    private LocalDate issueDate;

    @Column(name = "expires_on")
    private LocalDate expiryDate;

    @Column(name = "applicant_id")
    private Integer applicant_id;

    public Passport() {}
    public Passport(UUID passportNumber, LocalDate issueDate, LocalDate expiryDate, Integer applicant_id) {
        this.passportNumber = passportNumber;
        this.issueDate = issueDate;
        this.expiryDate = expiryDate;
        this.applicant_id = applicant_id;
    }

    public UUID getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(UUID passportNumber) {
        this.passportNumber = passportNumber;
    }

    public LocalDate getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(LocalDate issueDate) {
        this.issueDate = issueDate;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(LocalDate expiryDate) {
        this.expiryDate = expiryDate;
    }

    public Integer getApplicant_id() {
        return applicant_id;
    }

    public void setApplicant_id(Integer applicant_id) {
        this.applicant_id = applicant_id;
    }
}
