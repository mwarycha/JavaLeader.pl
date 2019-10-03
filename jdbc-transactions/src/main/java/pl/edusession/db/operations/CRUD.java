package pl.edusession.db.operations;

import java.sql.*;

public class CRUD {

    private static void printAllUsers(Connection connection) throws SQLException {
        String sql     = "SELECT * FROM users";
        Statement stmt = connection.createStatement();
        ResultSet rs   = stmt.executeQuery(sql);
        while(rs.next()){
            String email  = rs.getString("email");
            System.out.print("email: " + email + System.lineSeparator());
        }
    }

    public static void getAllUsers(Connection connection) throws SQLException {
        System.out.println("[SELECT]");
        printAllUsers(connection);
    }

    public static void insertUsers(Connection connection) throws SQLException {
        System.out.println("[INSERT]");
        String sqlInsert1 = "INSERT INTO users (email) VALUES ('user@mail.com');";
        PreparedStatement psInsert = connection.prepareStatement(sqlInsert1);
        psInsert.execute();
        connection.commit();
    }
}
