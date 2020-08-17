package project.data;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import project.cli.Game;
import project.cli.GameList;

public class Getter {

    public static GameList getAll() throws SQLException {
        GameList gamelist = new GameList();
        Connection connection = ConnectionUtil.getConnection();
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("SELECT * FROM games");
        while (rs.next()){
            gamelist.add(new Game(rs.getString("title"), rs.getString("genre"), rs.getString("control")));
        }
        
        return gamelist;
    }
}