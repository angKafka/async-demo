package org.rdutta.doctorservice.service;

import org.rdutta.doctorservice.features.BMI;
import org.rdutta.doctorservice.model.Doctor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.UUID;

public interface I_DoctorService {
    ResponseEntity<?> getBMIDetails(@RequestBody BMI bmi);
}
