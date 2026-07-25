package com.example.spring07.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

//yaha since we want JPA to make table of this class, hence we need to mention it as an entity
@Entity
@Data
//constructor chahiye all argument lene wala
@AllArgsConstructor
//component bhi mark kardo
//@Component

//no args constructor since ye nai lagaenge toh fatega, since hibernate ko object chahiye,
// aur vo banane ke liye default constuctor lagega, vo kaam ye karega @noargsConstructor
@NoArgsConstructor
public class product {

//    har entity ke primary key par @id chahiye
    @Id
    private int prod_id;
    private String prod_name;
    private int price;
}
