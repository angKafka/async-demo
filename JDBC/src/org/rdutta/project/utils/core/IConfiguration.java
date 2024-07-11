package org.rdutta.project.utils.core;

import java.sql.Connection;
import java.sql.SQLException;

public interface IConfiguration {
    String jdbcURI = "jdbc:postgresql://localhost:5432/order-app";
    String user = "postgres";
    String password = "Prerna@12345";

    public boolean getConnectionDetails() throws SQLException;
}
