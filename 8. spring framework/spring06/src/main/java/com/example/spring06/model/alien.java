package com.example.spring06.model;


//ye class model ke andar aani chahiye daal do package me

//we want spring to manage this class with bean/obejcts we use @component

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class alien {
    private int id;
    private String name;
    private  String tech;

//    inke getter setter bana do

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

//    toString bhi bana do

    @Override
    public String toString() {
        return "alien{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", tech='" + tech + '\'' +
                '}';
    }
}
