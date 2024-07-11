package org.rdutta.asyncdemo.rest;

import org.rdutta.asyncdemo.dao.DoctorDAO;
import org.rdutta.asyncdemo.dto.DoctorDTO;
import org.rdutta.asyncdemo.entity.Doctor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1/doctors")
public class DoctorController {
    private DoctorDAO dao;

    @Autowired
    public DoctorController(DoctorDAO dao) {
        this.dao = dao;
    }

    @GetMapping("/list")
    public Flux<DoctorDTO> list() {
        return dao.getAllDoctors();
    }

    @PostMapping("/add")
    public Mono<Integer> add(@RequestBody DoctorDTO dto) {
         return dao.addDoctor(dto);
    }
}
