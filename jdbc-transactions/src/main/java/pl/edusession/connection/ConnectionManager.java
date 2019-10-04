package pl.edusession.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
    public static Connection getConnectionManager(String connectionLink, String user, String password) throws SQLException {
        return DriverManager.getConnection(connectionLink, user, password);
    }
    public static void closeConnection(Connection connection) throws SQLException {
        connection.close();
    }
}
