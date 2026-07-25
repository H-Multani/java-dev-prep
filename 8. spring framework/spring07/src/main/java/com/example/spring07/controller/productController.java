package com.example.spring07.controller;


import com.example.spring07.model.product;
import com.example.spring07.service.productService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.condition.ProducesRequestCondition;

import java.util.List;


//this controller accepts requests for products
@RestController
public class productController {

    @Autowired
    productService service;


    @GetMapping("/products")
    public List<product> getProducts(){
        return service.getProducts();
    }


//    to get 1 specific data of id given inside url
    @GetMapping("/products/{id}")
    public product getProdById(@PathVariable int id){

        return service.getProductsById(id);
    }

//    to add product, sent by client
    @PostMapping("/products/add")
    public void addProduct(@RequestBody product p){
        service.addProd(p);
    }

    @PutMapping("/products/update")
    public void updateProduct(@RequestBody product prod){
        // service se bolo update kare
        service.updateProd( prod);
    }

    @DeleteMapping("/products/{id}")
    public void deleteProduct(@PathVariable int id){
        service.deleteProd(id);
    }

}
