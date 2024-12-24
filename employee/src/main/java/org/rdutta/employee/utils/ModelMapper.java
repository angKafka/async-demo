package org.rdutta.employee.utils;

import org.rdutta.employee.dto.EmployeeDto;
import org.rdutta.employee.model.Employee;
import org.springframework.stereotype.Component;

@Component
public class ModelMapper {

    /**
     * Maps an EmployeeDto to an Employee entity.
     * @param employeeDto the EmployeeDto object to be mapped
     * @return the Employee entity
     * @throws EmployeeExceptions if employeeDto is null
     */
    public Employee mapEmployee(EmployeeDto employeeDto) {
        if (employeeDto == null) {
            throw new EmployeeExceptions(Messages.EMPLOYEE_DATA_NOT_EXISTS);
        }

        return EmployeeFactory.createEmployee(employeeDto);
    }
}