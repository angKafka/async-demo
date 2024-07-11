package org.rdutta.asyncdemo.dao;

import org.rdutta.asyncdemo.dto.DoctorDTO;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface DoctorDAO {
    Mono<Integer> addDoctor(DoctorDTO doctorDTO);
    Mono<DoctorDTO> getDoctor(Integer doctor_id);
    Flux<DoctorDTO> getAllDoctors();
    Mono<String> deleteDoctor(Integer doctor_id);
}
