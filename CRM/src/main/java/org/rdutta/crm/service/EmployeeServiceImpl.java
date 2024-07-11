package org.rdutta.crm.service;

import jakarta.transaction.Transactional;
import org.rdutta.crm.dao.EmployeeDAO;
import org.rdutta.crm.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    private EmployeeDAO employeeDAO;

    @Autowired
    public void setEmployeeDAO(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }
    @Override
    public List<Employee> getAllEmployees() {
        return employeeDAO.getAllEmployees();
    }

    @Override
    public Employee getEmployeeById(UUID employeeId) {
        return employeeDAO.getEmployeeById(employeeId);
    }

    @Transactional
    @Override
    public void saveEmployee(Employee employee) {
        employeeDAO.saveEmployee(employee);
    }

    @Transactional
    @Override
    public void deleteEmployeeByID(UUID employeeId) {
        employeeDAO.deleteEmployeeById(employeeId);

    }

}