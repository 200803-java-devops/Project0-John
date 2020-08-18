package project.datatest;

import java.sql.Statement;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;

import project.cli.Game;
import project.data.ConnectionUtil;

public class AdderTest{

    @Test
    public void addGameTest() {
        try (Connection connection = ConnectionUtil.getConnection()){
            try (Statement check = connection.createStatement();) {
                connection.setAutoCommit(false);
                check.executeUpdate("DELETE FROM games");
                Game game = new Game("testT", "testG", "testC", false);
                String sql = "INSERT INTO games (title, genre, cont, started) VALUES (?, ?, ?, ?)";
                PreparedStatement statement = connection.prepareStatement(sql);
                statement.setString(1, game.title);
                statement.setString(2, game.genre);
                statement.setString(3, game.control);
                statement.setBoolean(4, game.started);
                statement.executeUpdate();
                try (ResultSet rs = check.executeQuery("SELECT * FROM games")){
                    assertTrue(rs.next());
                    assertEquals(game.title, rs.getString("title"));
                    assertEquals(game.genre, rs.getString("genre"));
                    assertEquals(game.control, rs.getString("cont"));
                    assertEquals(game.started, rs.getBoolean("started"));
                    assertFalse(rs.next());
                }
            } finally {
                connection.rollback();
                connection.close();
            }
        }catch(SQLException e){
            System.err.println(e.toString());
        }
    }
}