package org.rdutta.jdbc.calling;

import org.rdutta.jdbc.employee.allemployees.GetAllEmployee;
import org.rdutta.jdbc.utils.crud.AllEmployee;

import java.sql.Date;
import java.sql.SQLException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.UUID;


public class Employee {
    public static void main(String[] args) throws SQLException {
        GetAllEmployee getAllEmployee = new GetAllEmployee();
        LocalDate birthDate = LocalDate.of(1995, 7, 1);
        Date sqlBirthDate = Date.valueOf(birthDate);

        getAllEmployee.setFirstname("Payal");
        getAllEmployee.setLastname("Kumari");
        getAllEmployee.setGender("FEMALE");
        getAllEmployee.setEmail("pkumari@orderapp.com");
        getAllEmployee.setPhone("887-665-7896");
        getAllEmployee.setDob(sqlBirthDate);


//        System.out.println(getAllEmployee.fetchAllEmployees());
//        System.out.println(getAllEmployee.fetchEmployeeByName("Raj"));
//        System.out.println(getAllEmployee.createEmployee());
//        System.out.println(getAllEmployee.updateEmployee("firstname", "Raj", UUID.fromString("d280a0af-c232-4873-bfcf-08f607edef53")));
        System.out.println(getAllEmployee.DeleteAllEmployees());
    }
}
