package pl.edusession;

import pl.edusession.connection.ConnectionManager;
import pl.edusession.connection.InitDatabaseManager;
import pl.edusession.db.operations.CRUD;
import java.sql.Connection;
import java.sql.SQLException;

public class StartUseCases {

    final static String h2ConnectionLink    = "jdbc:h2:~/test, myProp";
    final static String mysqlConnectionLink = "jdbc:mysql://localhost:3307/javaleader?useLegacyDatetimeCode=false&serverTimezone=UTC";

    private static Connection connection;
    private static Connection connection2;

    public StartUseCases(String connectionLink,String user,String password) {
        try {
            connection = ConnectionManager.getConnectionManager(connectionLink,user,password);
            connection.setAutoCommit(false);
            connection2 = ConnectionManager.getConnectionManager(connectionLink,user,password);
            connection2.setAutoCommit(false);
            InitDatabaseManager.initStarterTable(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void startTransactionReadCommitedTest() throws SQLException {

        connection.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
        connection2.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);

        CRUD.insertUsers(connection2);
        CRUD.getAllUsers(connection);
    }

    private static void startTransactionRepeatableRead() throws SQLException {

        connection.setTransactionIsolation(Connection.TRANSACTION_REPEATABLE_READ);
        connection2.setTransactionIsolation(Connection.TRANSACTION_REPEATABLE_READ);

        CRUD.insertUsers(connection);

        Runnable r1 = new Runnable() {
            public void run() {
                try {
                    CRUD.getAllUsers(connection2);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        };

        Runnable r2 = new Runnable() {
            public void run() {
                try {
                    CRUD.updateUsers(connection);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        };

        new Thread(r1, "Thread-1").start();
        new Thread(r2, "Thread-2").start();

    }

    private static void startTransactionSerializable() throws SQLException {

        connection.setTransactionIsolation(Connection.TRANSACTION_REPEATABLE_READ);
        connection2.setTransactionIsolation(Connection.TRANSACTION_REPEATABLE_READ);

        Runnable r1 = new Runnable() {
            public void run() {
                try {
                    CRUD.getAllUsers(connection2);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        };

        Runnable r2 = new Runnable() {
            public void run() {
                try {
                    CRUD.insertUsers(connection);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        };

        new Thread(r1, "Thread-1").start();
        new Thread(r2, "Thread-2").start();
    }

    public static void main(String[] args) throws SQLException {
        new StartUseCases(mysqlConnectionLink,"root", "root");
        startTransactionReadCommitedTest();
        startTransactionRepeatableRead();
        startTransactionSerializable();
    }
}
