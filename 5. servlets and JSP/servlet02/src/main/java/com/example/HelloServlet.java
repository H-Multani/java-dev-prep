package com.example;


//tomcat 10 use karra hu toh tomcat 10 ka dependency add kar dena
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


import java.io.IOException;
import java.io.PrintWriter;


// /firstservlet wala part must match exactly as the one in index.html
@WebServlet("/firstservlet")
public class HelloServlet extends HttpServlet {

//    ek constructor bana do dikhane ke liye ki ban gaua servlet inside servlet container


//    constructor banaoge toh public banana zarurat padta hai server ko
    public HelloServlet(){

//        this is displayed in termainal
        System.out.println("servlet obj is created internally by container");
    }



    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        since we are recieving data from client(index.html), hence req ka use karenge

//        jo bhi waha data aayega uname and ucity me stored hoga yaha lana hai
        String name=req.getParameter("uname");
        String city=req.getParameter("ucity");


//        le aaye data yaha seedha ab jdbc se connection karke bhej sakte data waha par
//        ab yaha se name and city ka msg bana kar respond karna hai, ie we have to send data back to user, hence resp ka use karenge yaha par
//        response se ek writer banvao which will be used to give response back
        PrintWriter writer=resp.getWriter();


//        print kardo desired msg

//        THIS MESSAGE IS SHOWN In THE WEB BROWSER
//        writer.println("hello "+name+" from "+city);

//        this whole thing can be written inside html too
        writer.println("<html><head><title> second app type shi</title></head>");
        writer.println("<body><h1>");
        writer.println("hello "+name+" from "+city);
        writer.println("</h1><body>");
        writer.println("</html>");


//        real me yaha html nai likhte apan, irl we will give this responses to a different html file and uska alag get post likhenge



//        ab writer close kardo
        writer.close();


    }
}
