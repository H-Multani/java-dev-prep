package com.example;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;



public class jdbcutil {
    //    static block for driver
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("class not found");
            throw new RuntimeException(e);
        }
    }

    //    ab bana do 2 functions , one for connection
    public static Connection getcon() throws SQLException {
        String url="jdbc:mysql://localhost:3306/mydb1";
        String name="root";
        String pass="Har@123";

//        direct connection return kardo
        return DriverManager.getConnection(url,name,pass);
    }


    //    one funcn to close all the stuff
    public static void closestuff(Connection c, Statement s) throws SQLException {
        c.close();
        s.close();
    }

}
