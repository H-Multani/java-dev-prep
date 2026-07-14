package org.example;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

//ye class is eligible for hibernate, toh need to annotate it Entity
@Entity
@Table(name="alienka_table")
public class Alien {
//    har alien ka name,id,tech hoga

    //    we need this id to be primary key of table, hence annotate with @id
    @Id
    private int id;
    @Column(name="naeme")
    private String name;
    private String tech;

//    getter setter bana do


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTech() {
        return tech;
    }

    public void setTech(String tech) {
        this.tech = tech;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    //    toString bana do
    @Override
    public String toString() {
        return "Alien{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", tech='" + tech + '\'' +
                '}';
    }
}