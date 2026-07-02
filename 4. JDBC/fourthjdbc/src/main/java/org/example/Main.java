package org.example;

import java.sql.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");

//        establish connection
        String url="jdbc:mysql://localhost:3306/mydb1";
        String user="root";
        String pass="Har@123";
        Connection connect = DriverManager.getConnection(url,user,pass);


//        create the statement
        Statement stmt =connect.createStatement();

//        for update query(non select)
//        String query="update studentinfo set age=31 where id=1";
//        stmt.executeUpdate(query);

//        retrieve the data/ show the data
//        String query="select * from studentinfo";
////        sends all data in table to resultset
//        ResultSet d1= stmt.executeQuery(query);
//
////        ab is d1 par itertate karke we can show all the data
//
////        process the result
//        while(d1.next()){
////            har type ka data manga kar store bhi kar sakte and display bhi kar sakte
////            System.out.println("id "+d1.getInt(1));
////            System.out.println("name "+d1.getString(2));
////            System.out.println("age "+d1.getInt(3));
////            System.out.println("city "+d1.getString(4));
//            System.out.println("id "+d1.getInt("id"));
//            System.out.println("name "+d1.getString("name"));
//            System.out.println("age "+d1.getInt("age"));
//            System.out.println("city "+d1.getString("city"));
//            System.out.println();
//        }


//        delete the data
//        String que="delete from studentinfo where id=1";
//        stmt.executeUpdate(que);

//        close resources
        stmt.close();
        connect.close();


    }
}
