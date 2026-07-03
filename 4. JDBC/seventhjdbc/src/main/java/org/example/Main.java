package org.example;

import java.sql.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main() {
        Connection connect = null;
//        Statement stmt = null;
        PreparedStatement stmt=null;

        try {

//          establish connectionś
            connect = jdbcUtil.connectionBanao();

//          create the statement
//          ye ? daale hai, run time me values daalne ke liye, can take from user, mai abhi yaha variables me le raha

//            int id=1,age=34;
//            String name="karan",city="bangalore";
            String q="insert into studentinfo(id,name,age,city) values(?,?,?,?)";

//            pehle stmt ko prepare karna hai
            stmt=connect.prepareStatement(q);

//            ab is stmt me values dalo

//            column 1 me id daalo
//            stmt.setInt(1,id);
////            col 2 me name dalo
//            stmt.setString(2,name);
////            col 3 me age dalo
//            stmt.setInt(3,age);
////            col 4 me city daalo
//            stmt.setString(4,city);

//            ek baar me ek record dalenge time lagega, we insert 3 records in 1 batch


//            stmt bana hua hai already,

//            prepare first query
            stmt.setInt(1,4);
            stmt.setString(2,"aditya");
            stmt.setInt(3,78);
            stmt.setString(4,"pune");
//            first query prepare karne ke baad add it to batch
            stmt.addBatch();

//            prepare second query
            stmt.setInt(1,5);
            stmt.setString(2,"ekansh");
            stmt.setInt(3,43);
            stmt.setString(4,"durg");
//            second query prepare karne ke baad add it to batch
            stmt.addBatch();

//            prepare third query
            stmt.setInt(1,6);
            stmt.setString(2,"ishan");
            stmt.setInt(3,23);
            stmt.setString(4,"indore");
//            third query prepare karne ke baad add it to batch
            stmt.addBatch();

//            now all queries have been made in batches, execute all
            stmt.executeBatch();


//            all set

//            ab stmt ko execute kardo, since we are inserting stuff,hence executeUpdate
//            stmt.executeUpdate();

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
