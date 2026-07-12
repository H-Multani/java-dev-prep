package com.example.spring01;


//@XmlRootElement, this was used originally to declare ki alienke pvt variables XML me jayenge bahar

// iska kaam hi nai lagega since spring boot me ye sab already included hota

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
//@Entity is used when you want a Java class to represent a table in a database using JPA/Hibernate.
public class Alien {

//    ye annotation, makes the below variable primary key
    @Id
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private String name;
    private int points;

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    //    toString bana do yaar
    @Override
    public String toString(){
        return "id is "+ id +" name is "+name+" points is "+ points;
    }
}