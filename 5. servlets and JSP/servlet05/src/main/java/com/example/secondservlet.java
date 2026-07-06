package com.example;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/secondservlet")
public class secondservlet extends HttpServlet {

//    this is second servlet, yaha par control milega
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("control in second servlet");

        HttpSession sesion= req.getSession();
//        session object bana liya, ab session se value nikalne ke liye
//        need to convert from object back to string, tabhi typecasting
        String namehere=(String) sesion.getAttribute("nameofperson");

        PrintWriter w=resp.getWriter();
        w.println("response frm servlet 2, name is "+namehere);
        w.close();
    }
}
