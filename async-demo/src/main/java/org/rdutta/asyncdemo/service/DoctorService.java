package org.rdutta.asyncdemo.service;

import org.rdutta.asyncdemo.dao.DoctorDAO;
import org.rdutta.asyncdemo.dto.DoctorDTO;
import org.rdutta.asyncdemo.entity.Doctor;
import org.rdutta.asyncdemo.mapper.DoctorMapper;
import org.rdutta.asyncdemo.repository.DoctorRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Service
public class DoctorService implements DoctorDAO {
    private final DoctorRepository doctorRepository;
    private final DoctorMapper doctorMapper;
    private final Logger log = LoggerFactory.getLogger(DoctorService.class);

    @Autowired
    public DoctorService(DoctorRepository doctorRepository, DoctorMapper doctorMapper) {
        this.doctorRepository = doctorRepository;
        this.doctorMapper = doctorMapper;
    }

    @Transactional
    @Override
    public Mono<Integer> addDoctor(DoctorDTO doctorDTO) {
        Doctor doctor = doctorMapper.toDoctor(doctorDTO);
        return doctorRepository.save(doctor)
                .map(Doctor::getDoctor_id);
    }




    @Override
    public Mono<DoctorDTO> getDoctor(Integer doctor_id) {
        return doctorRepository.findById(doctor_id).map(doctorMapper::toDoctorDTO);
    }

    @Override
    public Flux<DoctorDTO> getAllDoctors() {
        return doctorRepository.findAll().map(doctorMapper::toDoctorDTO);
    }


    @Transactional
    @Override
    public Mono<String> deleteDoctor(Integer doctor_id) {
        doctorRepository.deleteById(doctor_id);
        return Mono.just("Successfully deleted!");
    }
}
