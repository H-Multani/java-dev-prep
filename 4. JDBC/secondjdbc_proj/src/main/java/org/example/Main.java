package org.example;



public class Main {
    static void main() throws ClassNotFoundException{

//        demo d=new demo();

//        since org.example package ke andar hai demo class hence wahi se bulana padega
        Class.forName("org.example.demo");
    }
}


class demo{
    static {
        System.out.println("static block, run first");
    }

    {
        System.out.println("instance block-> non static, run later");
    }
}