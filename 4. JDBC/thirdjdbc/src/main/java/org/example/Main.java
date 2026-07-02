package org.example;

import java.sql.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main() throws  ClassNotFoundException, SQLException {
//        load and register driver
        Class.forName("com.mysql.cj.jdbc.Driver");


//        establish the connection
        String url="jdbc:mysql://localhost:3306/mydb1";
        String user="root";
        String pass="Har@123";
        Connection connect = DriverManager.getConnection(url,user,pass);


//        create the statement
        Statement stmt =connect.createStatement();


//        execute the query
//        for non select queries we use executeUpdate()
//        String sql="update studentinfo set age=27 where id=1";
//        int rowsaffected=stmt.executeUpdate(sql);
//        if(rowsaffected==0){
//            System.out.println("no rows affected");
//        }
//        else{
//            System.out.println(rowsaffected+" rows affected");
//        }


//        to fetch data from database, we arent updating anything in the table,we just want to retrieve the data back to this application here

//        execute the query
//        for this we use executeQuery()
        String sql="select * from studentinfo";
         ResultSet rs=stmt.executeQuery(sql);
//        iska return type is ResultSet (not int, since we arent updating anything)
//        jitne record hai saare ResultSet me aa jaega,
//        ResultSet-> representative of table of database, holds records from database, like ta table in the java program
//        ab ResultSet ke methods use karke process kar sakte hai apan

//        ab process karenge results ko

//        process the result

        while(rs.next()){
//            means aage hai abhi result set me data fetch karlo

//            first column is id-> integer hence getInteger(col_no/col_name)
//            ip me we can specify column no ya column name
//            int id=rs.getInt(1);
//            int id2=rs.getInt(id);
//            can store this id in int
//            ya ye sab karo ya direct print kara lo

//            aage we have name-> String-> getString()
//            aage we have age-> int-> getInt()
//            aage we have city-> String-> getString()

            System.out.println(rs.getInt(1)+ " "+ rs.getString(2)+" "+ rs.getInt(3)+" "+ rs.getString(4));


        }





//        in the end close all the objects used
        stmt.close();
        connect.close();




    }
}