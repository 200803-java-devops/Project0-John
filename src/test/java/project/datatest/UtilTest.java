package project.datatest;

import static org.junit.Assert.assertTrue;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Test;

import project.data.ConnectionUtil;

public class UtilTest {

    @Test
    public void testConnectionUtil() {
        Connection connection = ConnectionUtil.getConnection();
        try {
            assertTrue(connection.isValid(10));
        } catch (SQLException e) {
            System.err.println("sqlexception in isvalid method");
        }
        try {
            connection.close();
        } catch (SQLException e) {
            System.err.println("close failed in test case");
        }
    }
}