package org.example;

import javax.swing.plaf.nimbus.State;
import java.sql.*;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

//        load and register driver
        Class.forName("com.mysql.cj.jdbc.Driver");


//        establish the connection


//        url iss pattern me likho "jdbc:mysql://localhost:3306/database_name"
        String url="jdbc:mysql://localhost:3306/mydb1";
        String user="root";
        String pass="Har@123";

//        drivermanager class ka static funcn getConnection() which takes url,user,pass and connection baitha kar dega apan ko, object bhej dega vapas, toh ye objet apan store kar lenge


        Connection connect =DriverManager.getConnection(url,user,pass);
//        kyuki ye exception throw KAR sakta hai toh isko apan ko ya try catch block me likhna padega ya fir iska exception handle karna padega



//        create the statement
        Statement stmt =connect.createStatement();


//        execute the query
//        process the result



//        in the end close all the objects used
        stmt.close();
        connect.close();








    }
}
