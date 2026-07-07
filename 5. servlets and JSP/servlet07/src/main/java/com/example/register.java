package com.example;



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
public class register extends HttpServlet{
//    kuch get post nai daalna abhi sirf service lagao since yaha kaam nai karenge apan bas connection karenge

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        yaha par data nikalo bas
        String id=req.getParameter("uid");
        String name=req.getParameter("uname");
        String age=req.getParameter("uage");
        String city=req.getParameter("ucity");


//        yaha model ka object bana lo ek
        model m=new model();
        m.setAge(age);
        m.setId(id);
        m.setName(name);
        m.setCity(city);



//        register kardo bande ko
        int rowsAffected=m.register();

//        dynamic banana hai toh register ho gaya toh session me dikhayenge, toh name add kardo session me
        HttpSession session =req.getSession();
//        session me name daal do
        session.setAttribute("name",name);

        if(rowsAffected==0){
            // means no rows affected,means user not registered, means data not sent to the dbms
            // , iss case me failure.jsp par jao

//            redirect/send control to failure.jsp
            resp.sendRedirect("/servlet07/failure.jsp");
        }
        else{
//            means user registered, iss case me success.jsp par jana
//            redirect/send control to success.jsp
            resp.sendRedirect("/servlet07/success.jsp");
        }
    }
}
