package org.rdutta.crm.service;

import org.rdutta.crm.entity.Employee;

import java.util.List;
import java.util.UUID;

public interface EmployeeService {
    List<Employee> getAllEmployees();

    Employee getEmployeeById(UUID employeeId);

    void saveEmployee(Employee employee);

    void deleteEmployeeByID(UUID employeeId);
}
