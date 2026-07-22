package com.example.spring05.controller;


import com.example.spring05.model.product;
import com.example.spring05.service.productService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.condition.ProducesRequestCondition;

import java.util.List;


//this controller accepts requests for products
@RestController
public class productController {

//    controller gets the data frm the service, we want spring apne se object banaye laga do autowired
    @Autowired
    productService service;


//    we want ki ye products laa kar de when we write /products toh bana do mapping
    @GetMapping("/products")
    public List<product> getProducts(){
//        returns all products listed

//        service ke object se boldo ki leke aaye data
        return service.getProducts();
    }


//    to get 1 specific data of id given inside url
    @GetMapping("/products/{id}")
    public product getProdById(@PathVariable int id){

//        service wale object se bolo laa kar dega
        return service.getProductsById(id);
    }

//    to add product, sent by client
    @PostMapping("/products/add")
    public void addProduct(@RequestBody product p){
        service.addProd(p);
    }

//    to update record
    @PutMapping("/products/update")
    public void updateProduct(@RequestBody product prod){
        // service se bolo update kare
        service.updateProd( prod);
    }

//    to delete stuff
    @DeleteMapping("/products/{id}")
    public void deleteProduct(@PathVariable int id){
        service.deleteProd(id);
    }

}
