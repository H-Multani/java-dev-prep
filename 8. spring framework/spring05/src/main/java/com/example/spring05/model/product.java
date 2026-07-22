package com.example.spring05.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;

@Data
//constructor chahiye all argument lene wala
@AllArgsConstructor
//component bhi mark kardo
//@Component
public class product {
    private int prod_id;
    private String prod_name;
    private int price;
}
