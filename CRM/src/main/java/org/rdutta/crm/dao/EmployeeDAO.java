package org.rdutta.crm.dao;

import org.rdutta.crm.entity.Employee;

import java.util.List;
import java.util.UUID;

public interface EmployeeDAO {
    List<Employee> getAllEmployees();
    Employee saveEmployee(Employee employee);
    Employee getEmployeeById(UUID employeeId);
    void deleteEmployeeById(UUID employeeId);
}
