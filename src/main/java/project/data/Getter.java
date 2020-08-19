package project.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import project.cli.Game;
import project.cli.GameList;

/**
 * class retreives games from database
 */
public class Getter {

    /**
     * retreives all games from database as gamelist
     * @return gamelist of all games in database
     * @throws SQLException bad practice but method would require several try/catch blocks, used throws due to time constraints
     */
    public static GameList getAll() throws SQLException {
        GameList gamelist = new GameList();
        Connection connection = ConnectionUtil.getConnection();
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("SELECT * FROM games");
        while (rs.next()){
            gamelist.initAdd(new Game(rs.getString("title"), rs.getString("genre"), rs.getString("cont"), rs.getBoolean("started")));
        }
        
        return gamelist;
    }

    /**
     * retreives all games of particular genre from database
     * @param genre genre to sort by
     * @return output gamelist
     * @throws SQLException same as above
     */
    public static GameList getGenre(String genre) throws SQLException {
        GameList gamelist = new GameList();
        Connection connection = ConnectionUtil.getConnection();
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM games WHERE genre = ?");
        statement.setString(1, genre);
        ResultSet rs = statement.executeQuery();
        while (rs.next()){
            gamelist.initAdd(new Game(rs.getString("title"), rs.getString("genre"), rs.getString("cont"), rs.getBoolean("started")));
        }
        return gamelist;
    }

    /**
     * retreives all games of particular control type from database
     * @param control type to sort by
     * @return output gamelist
     * @throws SQLException same as above
     */
    public static GameList getControl(String control) throws SQLException {
        GameList gamelist = new GameList();
        Connection connection = ConnectionUtil.getConnection();
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM games WHERE cont = ?");
        statement.setString(1, control);
        ResultSet rs = statement.executeQuery();
        while (rs.next()){
            gamelist.initAdd(new Game(rs.getString("title"), rs.getString("genre"), rs.getString("cont"), rs.getBoolean("started")));
        }
        return gamelist;
    }

    /**
     * retreives all games that have or have not been started
     * @param started started or not?
     * @return gamelist output
     * @throws SQLException same as above
     */
    public static GameList getStarted(boolean started) throws SQLException {
        GameList gamelist = new GameList();
        Connection connection = ConnectionUtil.getConnection();
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM games WHERE started = ?");
        statement.setBoolean(1, started);
        ResultSet rs = statement.executeQuery();
        while (rs.next()){
            gamelist.initAdd(new Game(rs.getString("title"), rs.getString("genre"), rs.getString("cont"), rs.getBoolean("started")));
        }
        return gamelist;
    }
}