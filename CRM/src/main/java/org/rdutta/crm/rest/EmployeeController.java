package org.rdutta.crm.rest;

import org.rdutta.crm.entity.Employee;
import org.rdutta.crm.global.GlobalException;
import org.rdutta.crm.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/employee")
public class EmployeeController {
    private EmployeeService employeeService;
    private GlobalException globalException;

    public EmployeeController(EmployeeService employeeService, GlobalException globalException) {

        this.employeeService = employeeService;
        this.globalException = globalException;
    }

    @GetMapping("/")
    public List<Employee> getAllEmployees() {
        return employeeService
                .getAllEmployees();
    }

    @GetMapping("/{employee_id}")
    public Employee getEmployeeById(@PathVariable("employee_id") UUID employeeId) {
        return employeeService.getEmployeeById(employeeId);
    }


    @PostMapping("/add")
    public void addEmployee(@RequestBody Employee employee) {
        employeeService.saveEmployee(
                employee
        );
    }


    @PutMapping("/edit")
    public void updateEmployee(@RequestBody Employee employee) {
        employeeService.saveEmployee(employee);
    }

    @DeleteMapping("/{employee_id}")
    public void deleteEmployeeById(@PathVariable("employee_id") UUID employeeId) {
        employeeService.deleteEmployeeByID(employeeId);
    }
}
