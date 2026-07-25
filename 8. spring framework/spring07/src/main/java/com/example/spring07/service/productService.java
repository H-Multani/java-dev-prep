package com.example.spring07.service;

import com.example.spring07.model.product;
import com.example.spring07.repo.productRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class productService {

//    JPA wali product repo ka ek object bana do, for that use @autowired
    @Autowired
    productRepo repo;
//    object bante hi boht saare methods honge apne paas to use as convenient,
//    ye methods JPA repo ke andar hai, since interface toh khali apna


//    not needed anymore
//    List<product> prod= new ArrayList<>(Arrays.asList(new product(1,"iphone",50000),
//                                        new product(2,"samsung",70000),
//                                        new product(3,"huawei",55000)));


    public List<product> getProducts(){

//        ye method se saare data mil jaenge
        return repo.findAll();

    }

    public product getProductsById(int id) {
//        to find by specific id we do
        return repo.findById(id).orElse(new product(-1,"aaa",123));
//        basically, repo ye id wala object nikal kar do mereko, nai mile toh new object bana kar de dena
    }

//    funcn to add product
    public void addProd(product p){
//        repo se product add karvado
        repo.save(p);
    }

//    to update product
    public void updateProd(product p) {
//        update ke liye bhi save() chalta hai
        repo.save(p);
//        agar data already hai toh update kar dega nai toh insert kar dega
    }

//    to delete product
    public void deleteProd(int id) {
        repo.deleteById(id);
    }
}
