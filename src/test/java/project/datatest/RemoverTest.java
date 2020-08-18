package project.datatest;

import static org.junit.Assert.assertFalse;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

import project.data.ConnectionUtil;

public class RemoverTest {
    
    @Test
    public void removeGameTest(){
        try (Connection connection = ConnectionUtil.getConnection()){
            try (Statement check = connection.createStatement();) {
                connection.setAutoCommit(false);
                check.executeUpdate("DELETE FROM games");
                check.executeUpdate("INSERT INTO games (title, genre, cont, started) VALUES ('testT', 'testG', 'testC', 'false')");
                String sql = "DELETE FROM games WHERE title = ?";
                PreparedStatement statement = connection.prepareStatement(sql);
                statement.setString(1, "testT");
                statement.executeUpdate();
                try (ResultSet rs = check.executeQuery("SELECT * FROM games")){
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