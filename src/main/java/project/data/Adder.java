package project.data;

import java.sql.SQLException;

import project.cli.Game;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class Adder {
    
    public static void addGame(Game game){
        String sql = "INSERT INTO games (title, genre, cont) VALUES (?, ?, ?)";
        try(Connection connection = ConnectionUtil.getConnection()){
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, game.title);
            statement.setString(2, game.genre);
            statement.setString(3, game.control);
            statement.executeUpdate();
            connection.close();
        }catch(SQLException e){
            System.err.println("connection failed in addGame of add class");
        }
    }
}