package project.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnectionUtil {

    /**
     * creates connection to database to abstract drivermanager.getconnection call
     * @return created connection
     */
    public static Connection getConnection(){
        Connection connection = null;
        try{
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/projectdb", "john", "root");
        } catch (SQLException e) {
           System.err.println("get connection failed");
        }
        return connection;
    }
    
}