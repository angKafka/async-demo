package org.rdutta.asyncdemo.dto;

public record DoctorDTO(
        int doctor_id,
        String doctor_name,
        String specialization,
        String doctor_degree,
        String ratings
) {
}
