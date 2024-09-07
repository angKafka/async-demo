package org.rdutta.passport_automation_system.rest;

import org.rdutta.passport_automation_system.entity.Applicant;
import org.rdutta.passport_automation_system.entity.Application;
import org.rdutta.passport_automation_system.service.AutomationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/passport")
public class AutomationController {

    private final AutomationService automationService;

    @Autowired
    public AutomationController(AutomationService automationService) {
        this.automationService = automationService;
    }

    @PostMapping("/submit-application/{applicant_id}")
    public ResponseEntity<String> submitApplication(@PathVariable("applicant_id") Integer applicantId) {
        String response = automationService.submitApplication(applicantId);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/update-application-status/{application_id}")
    public ResponseEntity<String> updateApplicationStatus(@PathVariable("application_id") Integer applicationId) {
        String response = automationService.updateApplicationStatus(applicationId);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/validate-passport/{passport_number}")
    public ResponseEntity<String> validatePassport(@PathVariable("passport_number") UUID passportId) {
        String response = automationService.validatePassport(passportId);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/create-applicant")
    public ResponseEntity<String> createApplication(@RequestBody Applicant applicant) {
        String response = automationService.createApplication(applicant);
        return ResponseEntity.ok(response);
    }
}
