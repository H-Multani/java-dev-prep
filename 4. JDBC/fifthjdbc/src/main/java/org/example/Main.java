package org.example;

import java.sql.*;
import java.sql.DriverManager;
import java.sql.Statement;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main() throws SQLException {

//        throws use karna bad way to write code, try catch me likhdo sab kuch, ab agar kuch fata tab bhi handle kar lega



//        connection ko bahar bana do abhi ke liye, andar update kar dena nai toh finally me close nai kar paoge
        Connection connect=null;
        Statement stmt=null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

//        establish connection
            String url = "jdbc:mysql://localhost:3306/mydb1";
            String user = "root";
            String pass = "Har@123";
            connect = DriverManager.getConnection(url, user, pass);


//        create the statement
            stmt = connect.createStatement();


//        retrieve the data/ show the data
            String query = "select * from studentinfo";
//        sends all data in table to resultset
            ResultSet d1 = stmt.executeQuery(query);

//        ab is d1 par itertate karke we can show all the data

//        process the result
            while (d1.next()) {
//            har type ka data manga kar store bhi kar sakte and display bhi kar sakte
//            System.out.println("id "+d1.getInt(1));
//            System.out.println("name "+d1.getString(2));
//            System.out.println("age "+d1.getInt(3));
//            System.out.println("city "+d1.getString(4));
                System.out.println("id " + d1.getInt("id"));
                System.out.println("name " + d1.getString("name"));
                System.out.println("age " + d1.getInt("age"));
                System.out.println("city " + d1.getString("city"));
                System.out.println();
            }

        }
        catch (SQLException e){
            System.out.println("sql fata hai");
            e.printStackTrace();
        }
        catch (ClassNotFoundException e){
            System.out.println("calss nai mili");
            e.printStackTrace();
        }
        finally{
//        close resources

//            ye resources bhi possible hai null ho toh close na ho, inka bhi try catch banando
            try{
                stmt.close();
                connect.close();
            }
            catch (SQLException e){
                System.out.println("close bhi nai hua stme");
            }

        }
    }
}
