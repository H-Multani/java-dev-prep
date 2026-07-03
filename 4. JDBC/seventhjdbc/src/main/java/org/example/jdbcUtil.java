package org.example;

import java.sql.*;

public class jdbcUtil {
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("class hi nai mili lol");
            throw new RuntimeException(e);
        }
    }
    public static Connection connectionBanao() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/mydb1";
        String user = "root";
        String pass = "Har@123";
        return DriverManager.getConnection(url, user, pass);
    }
    public static void closestuff(Connection c, PreparedStatement s) throws SQLException {
        c.close();
        s.close();
    }

}
