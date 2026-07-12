package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class jdbcUtil {
    //    static block since ye hamesga execute karna hai, since driver hamesha aayega
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("class hi nai mili lol");
            throw new RuntimeException(e);
        }
    }

//yaha we write a static method to connect the things,url,pass nd all, and ek connection bana kar return karega

    //    throws daal do since jo use karega vahi handle karega
    public static Connection connectionBanao() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/mydb1";
        String user = "root";
        String pass = "Har@123";

//        direct connection object bana kar return kardo
        return DriverManager.getConnection(url, user, pass);
    }

    //    ek aur static method to close the connection
//    close karne ke liye connection aayega and stmt aayega dono ko band kar dena
    public static void closestuff(Connection c, Statement s) throws SQLException {
        c.close();
        s.close();
    }

}
