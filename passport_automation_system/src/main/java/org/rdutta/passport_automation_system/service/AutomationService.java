package org.rdutta.passport_automation_system.service;

import jakarta.persistence.EntityManager;
import org.rdutta.passport_automation_system.dao.ApplicationSubmit;
import org.rdutta.passport_automation_system.dao.PassportApply;
import org.rdutta.passport_automation_system.dao.PassportValidation;
import org.rdutta.passport_automation_system.entity.Applicant;
import org.rdutta.passport_automation_system.entity.Application;
import org.rdutta.passport_automation_system.entity.Passport;
import org.rdutta.passport_automation_system.repository.ApplicantRepo;
import org.rdutta.passport_automation_system.repository.ApplicationRepo;
import org.rdutta.passport_automation_system.repository.PassportRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.UUID;


@Service
public class AutomationService extends PassportValidation implements ApplicationSubmit, PassportApply {
    private final ApplicantRepo applicantRepo;
    private final ApplicationRepo applicationRepo;
    private final PassportRepo passportRepo;

    @Autowired
    public AutomationService(ApplicantRepo applicantRepo, ApplicationRepo applicationRepo, PassportRepo passportRepo) {
        this.applicantRepo = applicantRepo;
        this.applicationRepo = applicationRepo;
        this.passportRepo = passportRepo;
    }

    @Override
    public String submitApplication(Integer applicant_id) {

        if (applicant_id != null){
            Application application = new Application(
                    "WAITING",
                    applicant_id
            );
            applicationRepo.save(application);
            return "Application submitted successfully!";

        }
        return "No applicant found, Hence application can't be submitted";
    }

    @Override
    public String updateApplicationStatus(Integer application_id) {
        Application existingForm = applicationRepo.findById(application_id).orElseThrow(()-> new RuntimeException("Application not found"));

        if (existingForm.getApplicant_id() == application_id){
            existingForm.setStatus("APPROVED");
            applicationRepo.save(existingForm);
            applyForPassport(existingForm.getId(), existingForm.getApplicant_id());
            return "Successfully updated application";
        }
        return "No application found, Hence application can't be updated";
    }

    @Override
    public String applyForPassport(Integer application_id, Integer applicant_id) {
        Application application = applicationRepo.findById(application_id).orElseThrow(()->new RuntimeException("Application not found"));

        if(application.getId() == application_id && application.getStatus().equals("APPROVED")){
            Passport passport = new Passport(
                    UUID.randomUUID(),
                    LocalDate.now(),
                    LocalDate.now().plusDays(5),
                    applicant_id
            );
            passportRepo.save(passport);
            return "Applied for passport successfully!";
        }
        return "Cannot apply for passport,Application still in Waiting status!";
    }

    @Override
    public String validatePassport(UUID passport_Id) {
        Passport passport = passportRepo.findById(passport_Id).orElseThrow(()->new RuntimeException("Passport not found"));

        if(passport.getPassportNumber() == passport_Id){
            return  "Passport number already in use, Validated!";
        }
        return "Passport not exists";
    }

    public String createApplication(Applicant applicant) {
        applicantRepo.save(applicant);
        return "Application created successfully!";
    }
}
