package org.rdutta.project.utils.features;

import org.rdutta.project.utils.core.IConfiguration;

import java.sql.*;

public class ConnectionValidation implements IConfiguration {
    @Override
    public boolean getConnectionDetails() throws SQLException{
        boolean log = false;
        try(Connection connection =DriverManager.getConnection(jdbcURI, user, password)){
            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery("SELECT * FROM orderapp;");

           while(resultSet.next()){
               resultSet.getString(1);
           }
           log =  true;
        }catch (SQLException e){
            log = false;
        }
        return log;
    }
}
