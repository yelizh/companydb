package com.yeliz.utility;


import java.sql.*;


public class ConnectionProvider {
    String connectionString = "jdbc:postgresql://localhost:5432/companydb";
    String username = "postgres";
    String password = "root";
    Connection connection;
    PreparedStatement preparedStatement;

    public boolean openConnection()
    {
        try {
            connection = DriverManager.getConnection(connectionString,username,password);
            return true;
        } catch (SQLException e){
            return false;
        }
    }
    public boolean closeConnection()
    {
        try {
            if(!connection.isClosed()){
                connection.close();
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }return false;
    }
//Insert,Update ve Delete işlemler için kullanılacak method;
    public boolean executeUpdate(String sqlSorgu){
        if(openConnection()){
            try {
                preparedStatement=connection.prepareStatement(sqlSorgu);
                preparedStatement.executeUpdate();
                closeConnection();
                return true;

            } catch (SQLException e) {
                closeConnection();
            }
        }
        return false;


    }

}
