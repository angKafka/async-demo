package org.rdutta.bmiservice.controller;

import org.rdutta.bmiservice.entity.BMI;
import org.rdutta.bmiservice.feature.BMIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/health")
public class BMIController {
    private final BMIService bmiService;
    @Autowired
    public BMIController(BMIService bmiService) {
        this.bmiService = bmiService;
    }

    @GetMapping("/bmi")
    public ResponseEntity<?> getBMIDetails(@RequestBody BMI bmi){
        return new ResponseEntity<>(bmiService.getBMI(bmi), HttpStatus.OK);
    }
}
