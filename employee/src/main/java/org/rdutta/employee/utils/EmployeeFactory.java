package org.rdutta.employee.utils;

import org.rdutta.employee.dto.EmployeeDto;
import org.rdutta.employee.model.Employee;
import org.springframework.stereotype.Component;

@Component
public class EmployeeFactory {
    public static Employee createEmployee(EmployeeDto employeeDto) {
       return new Employee.builder()
                .id(employeeDto.empId()) // Assuming empId is used as the ID
                .name(employeeDto.name())
                .surname(employeeDto.surname())
                .email(employeeDto.email())
                .phone(employeeDto.phone())
                .address(employeeDto.address())
                .city(employeeDto.city())
                .state(employeeDto.state())
                .zip(employeeDto.zip())
                .build();
    }
}
