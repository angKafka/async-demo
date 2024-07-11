package org.rdutta.asyncdemo.repository;

import org.rdutta.asyncdemo.entity.Doctor;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorRepository extends ReactiveCrudRepository<Doctor, Integer> {
}
