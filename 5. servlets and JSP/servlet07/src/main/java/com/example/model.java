package com.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class model {
//    jitna data lena tha lelo yaha utne pvt variables bana do
    private String name;
    private String id;
    private String age;
    private String city;
    private Connection conn;
    private PreparedStatement stmt;
    private int rowsAffected;


//    getters and setters banao, since data yaha laane ke liye setters lagenge, and data bhejne ke liye getters lagenge

    public void setName(String name) {
        this.name = name;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public String getAge() {
        return age;
    }

    public String getCity() {
        return city;
    }


//    now we make function to register
    public int register()  {
        try {
//            connection banao
            conn=jdbcutil.getcon();
//            prepared stmt banao
            stmt=conn.prepareStatement("insert into studentinfo(id,name,age,city) values(?,?,?,?)");

//            set kardo values ko
            stmt.setInt(1,Integer.parseInt(id));
            stmt.setString(2,name);
            stmt.setInt(3,Integer.parseInt(age));
            stmt.setString(4,city);

//            execute kardo stmt ko, and output me jo aaya nikal lo

//            aur ye return kar dena valuesUpdated
            rowsAffected =stmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally {
            try {
                jdbcutil.closestuff(conn,stmt);
            } catch (SQLException e) {
                System.out.println("chii bc close bhi nai kar paa rahe resources");
                throw new RuntimeException(e);
            }
        }

//        end me return kar dena kitni rows affect hui
        return rowsAffected;
    }
}
