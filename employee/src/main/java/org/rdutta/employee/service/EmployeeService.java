package org.rdutta.employee.service;

import org.rdutta.employee.dao.EmployeeDao;
import org.rdutta.employee.dto.EmployeeDto;
import org.rdutta.employee.model.Employee;
import org.rdutta.employee.utils.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService implements EmployeeDao {
    private final EmployeeRepo employeeRepo;
    private final RetryService retryService;
    private final RetryStrategy retryStrategy;
    private final ModelMapper modelMapper;

    @Autowired
    public EmployeeService(EmployeeRepo employeeRepo, RetryService retryService, RetryStrategy retryStrategy, ModelMapper modelMapper) {
        this.employeeRepo = employeeRepo;
        this.retryService = retryService;
        this.retryStrategy = retryStrategy;
        this.modelMapper = modelMapper;
    }

    @Override
    public String insertEmployee(EmployeeDto employeeDto) {
        Employee employee = modelMapper.mapEmployee(employeeDto);

        if (employee == null) throw new EmployeeExceptions(Messages.EMPLOYEE_DATA_NOT_EXISTS);
        employeeRepo.save(employee);
        return Messages.CREATED_EMPLOYEE;
    }

    @Override
    public String updateEmployee(int empId, EmployeeDto employeeDto) {
        simulateTimeout();
        // Fetch the employee from the database
        RetryStrategy strategy = new ExponentialBackoffRetryStrategy(); // Or use ImmediateRetryStrategy

        // Create the retryable task
        EmployeeUpdateTask task = new EmployeeUpdateTask(this, strategy, employeeDto, empId);

        // Execute with retry logic
        task.execute();

        return Messages.UPDATED_EMPLOYEE;
    }

    @Override
    public Employee getEmployeeById(int id) {
        return employeeRepo.findById(id).orElseThrow(() -> new EmployeeExceptions(Messages.EMPLOYEE_NOT_FOUND));
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepo.findAll(); // Returns all employees from MongoDB
    }

    @Override
    public String deleteEmployee(int employeeId) {
        Employee employee = employeeRepo.findById(employeeId).orElseThrow(() -> new EmployeeExceptions(Messages.EMPLOYEE_NOT_FOUND));
        employeeRepo.delete(employee);
        return Messages.DELETED_EMPLOYEE; // Assuming a success message
    }


    private void simulateTimeout() {
        try {
            Thread.sleep(5000);  // Simulating a timeout by introducing a delay (5 seconds)
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
