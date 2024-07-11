package org.rdutta.msoauth.controller;

import org.rdutta.msoauth.model.EmailRequest;
import org.rdutta.msoauth.service.EmailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/email")
public class EmailController {


    private final EmailService emailService;
    private final Logger log = LoggerFactory.getLogger(getClass());
    @Autowired
    public EmailController(EmailService emailService) {
        this.emailService = emailService;
    }



    @PostMapping("/send")
    public ResponseEntity<String> sendEmail(@RequestBody EmailRequest emailRequest) {

        log.info("REST API invoked to send email");
        emailService.sendEmail(emailRequest);

        return ResponseEntity.ok("Email sent successfully");
    }


}