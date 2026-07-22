package com.example.spring05.service;

import com.example.spring05.model.product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


//since this is service hence we can use annotoation, behind the scene works same as @component
@Service
public class productService {
//    we need method which will return list of products

//    bana do variable products ka list
    List<product> prod= new ArrayList<>(Arrays.asList(new product(1,"iphone",50000),
                                        new product(2,"samsung",70000),
                                        new product(3,"huawei",55000)));


    public List<product> getProducts(){

//        return kardo products ko
        return prod;

    }

    public product getProductsById(int id) {
//        for(product p:prod){
//            if(p.getProd_id()==id) return p;
//        }

//        we can use stream api here, jo return kiya uska logic


//        prod me se stream banana hai(since stream se filter kar sakte products)
//        ab usme filter laga lo
//        for any product p i get frm stream, if uss product p ka getProdId() == id
//        ye product mil jaaye toh stop search, find the first product which matches and return that
        return prod.stream().filter(p->p.getProd_id()==id).findFirst().get();
    }

//    funcn to add product
    public void addProd(product p){
        prod.add(p);
    }

//    to update product
    public void updateProd(product p) {
//        loop chala kar kardo bc
        for(int i = 0; i< this.prod.size(); i++){
            if(prod.get(i).getProd_id()==p.getProd_id()){
//                update the object
                prod.set(i,p);
            }
        }
    }

//    to delete product
    public void deleteProd(int id) {
        for(int i = 0; i< this.prod.size(); i++){
            if(prod.get(i).getProd_id()==id){
//                remove the object
                prod.remove(i);
            }
        }
    }
}
