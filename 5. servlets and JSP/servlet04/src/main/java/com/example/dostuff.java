package com.example;



//tomcat 10 use karra hu toh tomcat 10 ka dependency add kar dena
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


import java.io.IOException;
import java.io.PrintWriter;


// /firstservlet wala part must match exactly as the one in index.html
@WebServlet("/fourthservlet")
public class dostuff extends HttpServlet {
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        System.out.println("control in servlet");
////        since we are getting data from user we use ree and store the data in some variables
//        String name=req.getParameter("uname");
//        String city=req.getParameter("ucity");
//
////        lets put basic check here
//        if(name.equals("harsh") && city.equals("pune")){
////            sout karoge toh terminal me dikhega
//            System.out.println("success, the right harsh logged in");
//        }
//        else{
//            System.out.println("different harsh logged in");
//        }
//    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("control in servlet");
//        since we are getting data from user we use ree and store the data in some variables
        String name=req.getParameter("uname");
        String city=req.getParameter("ucity");

//        lets put basic check here
//        if(name.equals("harsh") && city.equals("pune")){
//           sout karoge toh terminal me dikhega
//            System.out.println("success, the right harsh logged in");
//        }
//        else{
//            System.out.println("different harsh logged in");


//        ab we know that the actual response has to go to user too, toh the respnse has to go to another HTML file, since servlet is just controller

//        for that we use sendRedirect(), this will send the control back to the file we specify, here we send control back to success.jsp
        resp.sendRedirect("/servlet04/success.jsp");

        }
    }
