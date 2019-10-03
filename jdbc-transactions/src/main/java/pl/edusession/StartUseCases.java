package pl.edusession;

import pl.edusession.connection.ConnectionManager;
import pl.edusession.connection.InitDatabaseManager;
import pl.edusession.db.operations.CRUD;
import java.sql.Connection;
import java.sql.SQLException;

public class StartUseCases {

    private static Connection connection;
    private static Connection connection2;

    public StartUseCases(String connectionLink, String user, String password) {
        try {

            connection = ConnectionManager.getConnectionManager(connectionLink,user,password);
            connection.setAutoCommit(false);
            connection.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);

            connection2 = ConnectionManager.getConnectionManager(connectionLink,user,password);
            connection2.setAutoCommit(false);
            connection2.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);

            InitDatabaseManager.initStarterTable(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws SQLException {

        String h2ConnectionLink    = "jdbc:h2:~/test, myProp";
        String mysqlConnectionLink = "jdbc:mysql://localhost:3307/javaleader?useLegacyDatetimeCode=false&serverTimezone=UTC";

        new StartUseCases(h2ConnectionLink,"sa", "");

        CRUD.insertUsers(connection2);
        CRUD.getAllUsers(connection);
    }

}
