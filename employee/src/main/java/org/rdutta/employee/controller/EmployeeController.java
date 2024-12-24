package org.rdutta.employee.controller;

import org.rdutta.employee.dto.EmployeeDto;
import org.rdutta.employee.model.Employee;
import org.rdutta.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping("/add")
    public ResponseEntity<String> insertEmployee(@RequestBody EmployeeDto employeeDto) {
        String message = employeeService.insertEmployee(employeeDto);
        return ResponseEntity.ok(message);
    }

    @PutMapping("/{empId}")
    public ResponseEntity<String> updateEmployee(@PathVariable int empId, @RequestBody EmployeeDto employeeDto) {
        String message = employeeService.updateEmployee(empId, employeeDto);
        return ResponseEntity.ok(message);
    }

    @GetMapping("/{empId}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable int empId) {
        Employee employee = employeeService.getEmployeeById(empId);
        return ResponseEntity.ok(employee);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Employee>> getAllEmployees() {
        List<Employee> employees = employeeService.getAllEmployees();
        return ResponseEntity.ok(employees);
    }

    @DeleteMapping("/{empId}")
    public ResponseEntity<String> deleteEmployee(@PathVariable int empId) {
        String message = employeeService.deleteEmployee(empId);
        return ResponseEntity.ok(message);
    }
}