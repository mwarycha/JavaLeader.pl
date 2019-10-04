package pl.edusession.db.operations;

import java.sql.*;

import static java.lang.Thread.sleep;

public class CRUD {

    private static void printAllUsers(Connection connection) throws SQLException {

        try {
            sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        String sql     = "SELECT * FROM users where email = 'user@mail.com'";
        Statement stmt = connection.createStatement();
        ResultSet rs   = stmt.executeQuery(sql);
        while(rs.next()){
            String email  = rs.getString("email");
            System.out.print("email: " + email + System.lineSeparator());
        }
    }

    public static void getAllUsers(Connection connection) throws SQLException {
            System.out.println("start first read");
            printAllUsers(connection);
            System.out.println("end first read");

            try {
                sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("start second read");
            printAllUsers(connection);
            System.out.println("end second read");
    }

    public static void insertUsers(Connection connection) throws SQLException {

        try {
            sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("[INSERT]");
        String sqlInsert1 = "INSERT INTO users (email) VALUES ('user@mail.com');";
        PreparedStatement psInsert = connection.prepareStatement(sqlInsert1);
        psInsert.execute();

       // connection.commit();
    }

    public static void updateUsers(Connection connection) throws SQLException {

        try {
            sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("[UPDATE]");
        String updateSqlRowToUpdate = "UPDATE users SET email = 'example-update@example.com' WHERE email = 'user@mail.com'";

        Statement stmt = connection.createStatement();
        stmt.executeUpdate(updateSqlRowToUpdate);

        connection.commit();
    }
}
