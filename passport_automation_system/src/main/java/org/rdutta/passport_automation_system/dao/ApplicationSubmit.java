package org.rdutta.passport_automation_system.dao;


import org.rdutta.passport_automation_system.entity.Application;

public interface ApplicationSubmit {
    String submitApplication(Integer applicant_id);
    String updateApplicationStatus(Integer application_id);
}
