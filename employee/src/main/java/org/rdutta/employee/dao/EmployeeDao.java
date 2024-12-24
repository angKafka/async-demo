package org.rdutta.employee.dao;

import org.rdutta.employee.dto.EmployeeDto;
import org.rdutta.employee.model.Employee;


import java.util.List;


public interface EmployeeDao {
    String insertEmployee(EmployeeDto employeeDto);
    String updateEmployee(int empId, EmployeeDto employeeDto);
    Employee getEmployeeById(int id);
    List<Employee> getAllEmployees();
    String deleteEmployee(int employeeId);
}
