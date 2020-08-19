package project.data;

import java.sql.SQLException;

import project.cli.Game;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 * class to add games to database
 */
public class Adder implements Runnable {
    Game game;
    
    /**
     * constructor to inject game for multithreading call 
     */
    public Adder(Game game){
        this.game = game;
    }

    /**
     * method adds game to database
     * @param game game to add
     */
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

    /**
     * override of Runnable run method for adding game to database in concurrent environment
     */
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