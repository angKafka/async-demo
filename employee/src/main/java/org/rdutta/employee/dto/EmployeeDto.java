package org.rdutta.employee.dto;

public record EmployeeDto(
        int empId,
        String name,
        String surname,
        String email,
        String phone,
        String address,
        String city,
        String state,
        String zip
) {
}
