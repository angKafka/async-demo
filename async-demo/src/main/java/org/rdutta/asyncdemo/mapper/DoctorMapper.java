package org.rdutta.asyncdemo.mapper;

import org.rdutta.asyncdemo.dto.DoctorDTO;
import org.rdutta.asyncdemo.entity.Doctor;
import org.springframework.stereotype.Service;

@Service
public class DoctorMapper {
    public Doctor toDoctor(DoctorDTO dto) {
        Doctor doctor = new Doctor();
        doctor.setDoctor_id(dto.doctor_id());
        doctor.setDoctor_name(dto.doctor_name());
        doctor.setSpecialization(dto.specialization());
        doctor.setDegree(dto.doctor_degree());
        doctor.setRatings(dto.ratings());
        return doctor;
    }

    public DoctorDTO toDoctorDTO(Doctor doctor) {
        return new DoctorDTO(
                doctor.getDoctor_id(),
                doctor.getDoctor_name(),
                doctor.getSpecialization(),
                doctor.getDegree(),
                doctor.getRatings()
        );
    }
}
