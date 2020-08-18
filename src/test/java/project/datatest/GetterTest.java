package project.datatest;

import static org.junit.Assert.assertEquals;

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
                Game game = new Game("Starcraft", "Strategy", "Top Down", false);
                String sql = "INSERT INTO games (title, genre, cont, started) VALUES (?, ?, ?, ?)";
                PreparedStatement statement = connection.prepareStatement(sql);
                statement.setString(1, game.title);
                statement.setString(2, game.genre);
                statement.setString(3, game.control);
                statement.setBoolean(4, game.started);
                statement.executeUpdate();
                GameList gamelist1 = new GameList();
                gamelist1.testAdd(game);
                GameList gamelist = new GameList();
                Statement statement1 = connection.createStatement();
                ResultSet rs = statement1.executeQuery("SELECT * FROM games");
                while (rs.next()){
                    gamelist.initAdd(new Game(rs.getString("title"), rs.getString("genre"), rs.getString("cont"), rs.getBoolean("started")));
                }
                assertEquals(gamelist1.gamelist.get(0).title, gamelist.gamelist.get(0).title);
                connection.rollback();
                connection.close();
            } finally {
                
            }
        }catch(SQLException e){
            System.err.println(e.toString());
        }
    }

    @Test
    public void getGenreTest(){
        try (Connection connection = ConnectionUtil.getConnection()){
            try (Statement check = connection.createStatement()){
                connection.setAutoCommit(false);
                check.executeUpdate("DELETE FROM games");
                Game game = new Game("Starcraft", "Strategy", "Top Down", false);
                check.executeUpdate("INSERT INTO games (title, genre, cont, started) VALUES ('Skyrim', 'RPG', 'First Person', 'false')");
                check.executeUpdate("INSERT INTO games (title, genre, cont, started) VALUES ('Starcraft', 'Strategy', 'Top Down', 'false')");
                GameList expected = new GameList();
                expected.testAdd(game);
                GameList actual = new GameList();
                PreparedStatement statement = connection.prepareStatement("SELECT * FROM games WHERE genre = ?");
                statement.setString(1, "Strategy");
                ResultSet rs = statement.executeQuery();
                while (rs.next()){
                    actual.initAdd(new Game(rs.getString("title"), rs.getString("genre"), rs.getString("cont"), rs.getBoolean("started")));
                }
                assertEquals(expected.gamelist.get(0).title, actual.gamelist.get(0).title);
                connection.rollback();
                connection.close();
            } finally {
                
            }
        }catch(SQLException e){
            System.err.println(e.toString());
        }
    }

    @Test
    public void getControlTest(){
        try (Connection connection = ConnectionUtil.getConnection()){
            try (Statement check = connection.createStatement()){
                connection.setAutoCommit(false);
                check.executeUpdate("DELETE FROM games");
                Game game = new Game("Starcraft", "Strategy", "Top Down", false);
                check.executeUpdate("INSERT INTO games (title, genre, cont, started) VALUES ('Skyrim', 'RPG', 'First Person', 'false')");
                check.executeUpdate("INSERT INTO games (title, genre, cont, started) VALUES ('Starcraft', 'Strategy', 'Top Down', 'false')");
                GameList expected = new GameList();
                expected.testAdd(game);
                GameList actual = new GameList();
                PreparedStatement statement = connection.prepareStatement("SELECT * FROM games WHERE cont = ?");
                statement.setString(1, "Top Down");
                ResultSet rs = statement.executeQuery();
                while (rs.next()){
                    actual.initAdd(new Game(rs.getString("title"), rs.getString("genre"), rs.getString("cont"), rs.getBoolean("started")));
                }
                assertEquals(expected.gamelist.get(0).title, actual.gamelist.get(0).title);
                connection.rollback();
                connection.close();
            } finally {
                
            }
        }catch(SQLException e){
            System.err.println(e.toString());
        }
    }

    @Test
    public void getStartedTest(){
        try (Connection connection = ConnectionUtil.getConnection()){
            try (Statement check = connection.createStatement()){
                connection.setAutoCommit(false);
                check.executeUpdate("DELETE FROM games");
                Game game = new Game("Starcraft", "Strategy", "Top Down", true);
                check.executeUpdate("INSERT INTO games (title, genre, cont, started) VALUES ('Skyrim', 'RPG', 'First Person', 'false')");
                check.executeUpdate("INSERT INTO games (title, genre, cont, started) VALUES ('Starcraft', 'Strategy', 'Top Down', 'true')");
                GameList expected = new GameList();
                expected.testAdd(game);
                GameList actual = new GameList();
                PreparedStatement statement = connection.prepareStatement("SELECT * FROM games WHERE started = ?");
                statement.setBoolean(1, true);
                ResultSet rs = statement.executeQuery();
                while (rs.next()){
                    actual.initAdd(new Game(rs.getString("title"), rs.getString("genre"), rs.getString("cont"), rs.getBoolean("started")));
                }
                assertEquals(expected.gamelist.get(0).title, actual.gamelist.get(0).title);
                connection.rollback();
                connection.close();
            } finally {
                
            }
        }catch(SQLException e){
            System.err.println(e.toString());
        }
    }
}