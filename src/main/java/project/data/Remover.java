package project.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Remover implements Runnable {
    String title;

    /**
     * constructor injects string title into class for multithreading call
     * @param title title of game to be removed
     */
    public Remover(String title){
        this.title = title;
    }
    
    /**
     * remove game from database with provided title
     * @param title title of game to be removed
     */
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

    /**
     * override of runnable run method for removing game from database in concurrent environment
     */
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