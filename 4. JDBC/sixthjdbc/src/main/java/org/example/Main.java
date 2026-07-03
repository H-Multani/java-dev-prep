package org.example;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main() {

//        ab ye jitna bhi kaam hai boilerplate wala pura ek uitility file me daal do wahi se karlo
//        name de dena jdbcUtil

//        since same package me hai file toh no need to import anything, seedha class ka name use karke functions bulao static waale, since uska static block already execute ho chuka hoga before we even make a connection


//        connection ko bahar bana do abhi ke liye, andar update kar dena nai toh finally me close nai kar paoge
        Connection connect = null;
        Statement stmt = null;

        try {

//        establish connectionś

//            connection ke liye ab seedha util se utha lo
            connect = jdbcUtil.connectionBanao();

//        create the statement
            stmt = connect.createStatement();


//        retrieve the data/ show the data
            String query = "select * from studentinfo";
//        sends all data in table to resultset
            ResultSet d1 = stmt.executeQuery(query);

//        ab is d1 par itertate karke we can show all the data

//        process the result
            while (d1.next()) {
                System.out.println("id " + d1.getInt("id"));
                System.out.println("name " + d1.getString("name"));
                System.out.println("age " + d1.getInt("age"));
                System.out.println("city " + d1.getString("city"));
                System.out.println();
            }

        } catch (SQLException e) {
            System.out.println("sql fata hai");
            e.printStackTrace();
        } finally {
//        close resources

//            ye resources bhi possible hai null ho toh close na ho, inka bhi try catch banando
            try {
//                static method ko bula kar band kardo
                jdbcUtil.closestuff(connect, stmt);
            } catch (SQLException e) {
                System.out.println("close bhi nai hua stmt");
            }

        }
    }
}
