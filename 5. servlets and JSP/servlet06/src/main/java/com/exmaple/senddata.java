package com.exmaple;


import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

@WebServlet("/register")
public class senddata extends HttpServlet{
//    data yaha aayega, toh sabse pehle toh dbms se connection karne wala file banana padega

//    post se aayega data toh uska hi funcn bana lo bas


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        apan ne sab kuch yehi kar diya, it works lekin aise develop nai kiya jata hai,
//        this servlet is just controller, alag file me bhejna chahiye apan ko data
//        this is called MVC

//        abhi ke liye theek hai since 1-2 item hai, program badhega toh we will need to do 100s of things ek sath,
//        toh this business logic is preferred to be handled by another file, and writer se response bhejna html ko
//        isnt considered good practice, toh vo jsp ko bhejna chahiye, and good thing is ye neeche wala pura logic
//        we can write directly in the JSP file

//        check registered.jsp, iske andar ka jawa code will automaticlly be converted to a servlet and will be
//        run there before deployment

//        yaha par data nikalenge and update kar denge

//        now first things first, get the data
        String id=req.getParameter("uid");
        String name=req.getParameter("uname");
        String age=req.getParameter("uage");
        String city=req.getParameter("ucity");

//        ab connection and statement banao
        Connection conn=null;
        PreparedStatement stmt=null;

        try {

//            connection banano
            conn=dbmsutil.getcon();


//            ab string me likho sql query
            String query="insert into studentinfo(id,name,age,city) values(?,?,?,?)";

//            ab query se stmt bana do
//            stmt banao
            stmt=conn.prepareStatement(query);

//            ab isme values bhar do
            stmt.setInt(1,Integer.parseInt(id));
            stmt.setString(2,name);
            stmt.setInt(3,Integer.parseInt(age));
            stmt.setString(4,city);


            int updatedlines = stmt.executeUpdate();

            if(updatedlines==1){
                PrintWriter w=resp.getWriter();
                w.println("values updated, pushed to dbms");
            }
            else{
                PrintWriter w=resp.getWriter();
                w.println("values not updated");
            }


        } catch (SQLException e) {
            System.out.println("SQL fata hai");
            throw new RuntimeException(e);
        }
        finally {
//            close kardo resources ko
            try {
                dbmsutil.closestuff(conn,stmt);
            } catch (SQLException e) {
                System.out.println("close bhi nai kar paye wao");
                throw new RuntimeException(e);
            }
        }


    }
}
