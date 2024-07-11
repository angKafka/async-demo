package org.rdutta.jdbc.employee.allemployees;

import org.rdutta.jdbc.utils.crud.AllEmployee;

import java.sql.Date;
import java.sql.SQLException;
import java.util.UUID;


public class GetAllEmployee extends AllEmployee {
    @Override
    public String fetchAllEmployees() throws SQLException {
        return super.fetchAllEmployees();
    }

    @Override
    public String fetchEmployeeByName(String firstname) throws SQLException {
        return super.fetchEmployeeByName(firstname);
    }

    @Override
    public String createEmployee() throws SQLException {
        return super.createEmployee();
    }

    @Override
    public String updateEmployee(String column, String updateData, UUID employee_id) throws SQLException {
        return super.updateEmployee(column, updateData, employee_id);
    }

    @Override
    public String DeleteAllEmployees() throws SQLException {
        return super.DeleteAllEmployees();
    }
}
