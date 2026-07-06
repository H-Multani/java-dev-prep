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

//this is first servlet yaha se control bhejemge to second servlet
@WebServlet("/firstservlet")
public class firstservlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("control in first servlet");
        String name=req.getParameter("uname");
        String city=req.getParameter("ucity");

//        ab yaha req use karenge to dispatch request to another servlet,ie send control to another servlet,
//        and this returns an object which can be used to foward the control to the other servlet

        RequestDispatcher reqdispatch =req.getRequestDispatcher("/secondservlet");

//        to give access of name and city to other servlets, we add these to sessions
        HttpSession sesion=req.getSession();
//        session object bana liya, this is accessible through all servlets
//        to add values to this
        sesion.setAttribute("nameofperson",name);
        sesion.setAttribute("cityname",city);

//        session data par timeer laga sakte ki iske baad session will vanish like
//        sesion.setMaxInactiveInterval(10000);


//        we use forward(), kya kya forward karoge bata do, yaha par we forward both the request and response object
//        reqdispatch.forward(req,resp);
//        ab ye apne se forward kar dega control to the second servlet


//        now if i want to send response of both first and 2nd servlet, we use include method
        reqdispatch.include(req,resp);

//        to check if control is actually gone, we use writer here to check
        PrintWriter w=resp.getWriter();
        w.println("response frm servlet 1");
        w.close();
        System.out.println("control in first servlet again ");





    }
}