package org.rdutta.employee.utils;

import org.rdutta.employee.dto.EmployeeDto;
import org.rdutta.employee.service.EmployeeService;
import org.springframework.stereotype.Service;

@Service
public class EmployeeUpdateTask extends RetryableTask {

    private final EmployeeService employeeService;
    private final EmployeeDto employeeDto;
    private final int empId;

    public EmployeeUpdateTask(EmployeeService employeeService, RetryStrategy retryStrategy, EmployeeDto employeeDto, int empId) {
        super(retryStrategy); // Pass the retry strategy to the parent class
        this.employeeService = employeeService;
        this.employeeDto = employeeDto;
        this.empId = empId;
    }

    @Override
    protected void performTask() throws Exception {
        String result = employeeService.updateEmployee(empId, employeeDto);
        if (!result.equals(Messages.UPDATED_EMPLOYEE)) {
            throw new Exception("Failed to update employee " + empId);
        }
    }
}