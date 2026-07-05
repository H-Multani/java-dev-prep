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
@WebServlet("/firstservlet")
public class dostuff extends HttpServlet {

    //    here we will learn about servlet life cycle
//    sabse pehle chalega static block
    static {
        System.out.println("Servlet is loaded ........");
    }

    public dostuff(){
        // we here means servlet ka object bana hai
        System.out.println("Servlet object is created");
    }

    @Override
    public void init(ServletConfig config) throws ServletException {

//        ab servlet initialize hoga
        System.out.println("Servlet initialized...");
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        kuch bhi service ke liye yahi funcn chalega
        System.out.println("service method to handle HTTP request and return response");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }

    @Override
    public void destroy() {
        System.out.println("obect destroyed");

    }
}
