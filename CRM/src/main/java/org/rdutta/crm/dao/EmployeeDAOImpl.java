package org.rdutta.crm.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import org.rdutta.crm.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {
    private EntityManager em;

    @Autowired
    public EmployeeDAOImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<Employee> getAllEmployees() {
        TypedQuery<Employee> query = em.createQuery("FROM Employee", Employee.class);
        List<Employee> employees = query.getResultList();
        return employees;
    }


    @Override
    public Employee saveEmployee(Employee employee) {
        Employee dbEmployee = em.merge(employee);
        return dbEmployee;
    }

    @Override
    public Employee getEmployeeById(UUID employeeId) {
        return em.find(Employee.class, employeeId);
    }

    @Override
    public void deleteEmployeeById(UUID employeeId) {
        Employee dbEmployee = em.find(Employee.class, employeeId);
        em.remove(dbEmployee);
    }
}
