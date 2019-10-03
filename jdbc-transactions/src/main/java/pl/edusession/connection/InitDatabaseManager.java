package pl.edusession.connection;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class InitDatabaseManager {

    private static final String CREATE_TABLE_SQL =
            "CREATE TABLE IF NOT EXISTS users ("
            + "ID INT NOT NULL AUTO_INCREMENT,"
            + "EMAIL VARCHAR(45) NOT NULL,"
            + "PRIMARY KEY (ID))";

    private static final String DROP_TABLE_USERS = "drop table if exists users;";

    public static void initStarterTable (Connection connection) throws SQLException {
        Statement stmt = connection.createStatement();
        stmt.executeUpdate(DROP_TABLE_USERS);
        stmt.executeUpdate(CREATE_TABLE_SQL);
    }
}
