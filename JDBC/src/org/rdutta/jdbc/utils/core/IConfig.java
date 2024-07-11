package org.rdutta.jdbc.utils.core;



import org.rdutta.jdbc.utils.crud.AllEmployee;

import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.UUID;

public interface IConfig {
    String url = "jdbc:postgresql://localhost:5432/office";
    String user = "postgres";
    String password = "Prerna@12345";

    public String fetchAllEmployees() throws SQLException;

    public String fetchEmployeeByName(String firstname) throws SQLException;

    public String createEmployee() throws SQLException;

    public String updateEmployee(String column, String updateData, UUID employee_id) throws SQLException;
    public String DeleteAllEmployees() throws SQLException;
}
