package org.example;


//every alien will have name and points
//ye bana li clas, iske objects bana kar resource me bhejenge, ab MyResource
// me bhi kar sakte hai lekin alag se banara mai

//ab we know ki alien has to return XML structure, toh root kon hoga samajh me aana chahiye

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

//we need Alien -> root element
//name,points-> elements inside that
@XmlRootElement
public class Alien {
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