package org.rdutta.doctorservice.controller;

import org.rdutta.doctorservice.features.BMI;
import org.rdutta.doctorservice.model.Doctor;
import org.rdutta.doctorservice.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.UUID;


@RestController
@RequestMapping("/api/v1/doctors")
public class DoctorController {



    private DoctorService doctorService;

    @Autowired
    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }


    @GetMapping("/bmi-check")
    public ResponseEntity<?> calculateBMICheck(@RequestBody BMI bmi) {
        return ResponseEntity.ok(doctorService.getBMIDetails(bmi));
    }
}
