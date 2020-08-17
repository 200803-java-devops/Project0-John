package project.datatest;

import static org.junit.Assert.assertTrue;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

import project.cli.Game;
import project.cli.GameList;
import project.data.ConnectionUtil;

public class GetterTest {
    
    @Test
    public void getAllTest(){
        try (Connection connection = ConnectionUtil.getConnection()){
            try (Statement check = connection.createStatement();) {
                connection.setAutoCommit(false);
                check.executeUpdate("DELETE FROM games");
                Game game = new Game("testT", "testG", "testC");
                String sql = "INSERT INTO games (title, genre, cont) VALUES (?, ?, ?)";
                PreparedStatement statement = connection.prepareStatement(sql);
                statement.setString(1, game.title);
                statement.setString(2, game.genre);
                statement.setString(3, game.control);
                statement.executeUpdate();
                GameList gamelist1 = new GameList();
                gamelist1.add(game);
                GameList gamelist = new GameList();
                Statement statement1 = connection.createStatement();
                ResultSet rs = statement1.executeQuery("SELECT * FROM games");
                while (rs.next()){
                    gamelist.add(new Game(rs.getString("title"), rs.getString("genre"), rs.getString("control")));
                }
                assertTrue(gamelist1.equals(gamelist));
            } finally {
                connection.rollback();
                connection.close();
            }
        }catch(SQLException e){
            System.err.println(e.toString());
        }
    }
}