package project.data;

import java.sql.SQLException;

import project.cli.Game;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class Adder implements Runnable {
    Game game;
    
    public Adder(Game game){
        this.game = game;
    }

    public static void addGame(Game game){
        String sql = "INSERT INTO games (title, genre, cont, started) VALUES (?, ?, ?, ?)";
        try(Connection connection = ConnectionUtil.getConnection()){
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, game.title);
            statement.setString(2, game.genre);
            statement.setString(3, game.control);
            statement.setBoolean(4, game.started);
            statement.executeUpdate();
            connection.close();
        }catch(SQLException e){
            System.err.println("connection failed in addGame of add class");
        }
    }

    @Override
    public void run() {
        String sql = "INSERT INTO games (title, genre, cont, started) VALUES (?, ?, ?, ?)";
        try(Connection connection = ConnectionUtil.getConnection()){
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, game.title);
            statement.setString(2, game.genre);
            statement.setString(3, game.control);
            statement.setBoolean(4, game.started);
            statement.executeUpdate();
            connection.close();
        }catch(SQLException e){
            System.err.println("connection failed in addGame of add class");
        }
    }
}