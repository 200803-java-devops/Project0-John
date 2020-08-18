package project.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Remover implements Runnable {
    String title;

    public Remover(String title){
        this.title = title;
    }
    
    public static void removeGame(String title){
        String sql = "DELETE FROM games WHERE title = ?";
        try(Connection connection = ConnectionUtil.getConnection()){
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, title);
            statement.executeUpdate();
            connection.close();
        }catch(SQLException e){
            System.err.println("connection failed in removeGame of remove class");
        }
    }

    @Override
    public void run() {
        String sql = "DELETE FROM games WHERE title = ?";
        try(Connection connection = ConnectionUtil.getConnection()){
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, title);
            statement.executeUpdate();
            connection.close();
        }catch(SQLException e){
            System.err.println("connection failed in removeGame of remove class");
        }
    }
}