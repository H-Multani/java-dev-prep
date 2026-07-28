package com.example.backend.controller;


import com.example.backend.model.product;
import com.example.backend.service.productService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
//by default sab /api se jana chahiye, hence yaha map kardo
@RequestMapping("/api")
//we want ki cross origin data jaa paaye, ie CORS error na aaye for that we do
@CrossOrigin
public class productController {

//    service ka object bana do and autowire kardo
    @Autowired
    private productService service;



//    funcn for list of products
//    we need all products at api/products so
    @GetMapping("/products")
    public ResponseEntity<List<product>> getAllProducts(){
//        service se bolo products laa kar de


//        since response entity bhej rahe hai apan,
//        toh object return nai kar sakte need to convert this to ResponseEntity ka object
        return new ResponseEntity<>(service.getAllProducts(), HttpStatus.OK);
//        ab object ke sath me response code bhi bhej sakte yaha apan ne OK bheja hai
    }

//    funcn to get 1 product
//    iski specifiv mapping aayegi, frontend me product.jsx dekho waha se aayegi mapping for api/product/${id}
//    toh vahi bana do)
    @GetMapping("product/{id}")
    public ResponseEntity<product> getProduct(@PathVariable int id){
//        check karo if product hai bhi
        product p= service.getProductById(id);

        if(p!=null){
        return new ResponseEntity<>(service.getProductById(id),HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        service se bolo banda laa kar de
    }


//    ab add product wale section ke liye goto frontend/addComponents.jsx
//    waha line 37 par we see post("http://localhost:8080/api/product"
//    ie POST request jayegi api/product wale address par toh vahi bana do
    @PostMapping("/product")

//    now we just need the product info from the form filled, toh vo @RequestBody se lelo
//    but since we are taking image as well hence we use RequestPart for rest of the data
//    and image ke liye alag se accept karenge as MultiPartFile
    public ResponseEntity<?> addProduct(@RequestPart("product") product prod,
                                        @RequestPart("imageFile") MultipartFile image){
//        now to send this to next layer

//        bhej do aur object nikal lo
        try {
            product p= service.addProduct(prod,image);

//        we still here means product object add ho gaya
            return new ResponseEntity<>(p,HttpStatus.CREATED);

        }
        catch (Exception e){
            // means nai add kar paaye, return code ki nai mila
//            e.printStackTrace();
            return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);        }

    }


//    ab image alag se fetch hori hai in product.jsx at path
//        `http://localhost:8080/api/product/${id}/image`,
//    toh same path par bana do funcn ek fetch karne ke liye
//    image bhejni hai toh byte arr bhejna h
//    get mapping laga do
    @GetMapping("product/{id}/image")
    public ResponseEntity<byte[]> getImageByProductId(@PathVariable int id){
//        product fetch karlo, usme se byte[] nikal kar bhej do

        product p=service.getProductById(id);

//        iss product se image file nikalo
        byte[] imagefile=p.getImageData();

//        apan content type bhi bhej denge sath me
//        kya rahega bhi content ka type, same as type of image, ye object se nikal lenge
        return ResponseEntity.ok().contentType(MediaType.valueOf(p.getImageType())).body(imagefile);
    }


//    update product ke liye
//    iske liye goto UpdateProduct.jsx, line 89, waha we see
//    put(`${baseUrl}/api/product/${id}`,
//    ie put request hai /product/id par, bana do funcn
    @PutMapping("/product/{id}")
//    yaha input me apne paas id, product, multipart image,
    public ResponseEntity<String> updateProduct(@PathVariable int id,@RequestPart("product") product prod,@RequestPart("imageFile") MultipartFile image){

//        service ko bolo update karde, 3 cheezein jayegi isko, id, product and image
        product p= null;
        try {
            p = service.updateProduct(id,prod,image);
            return new ResponseEntity<>("updated",HttpStatus.OK);
        } catch (IOException e) {
            return new ResponseEntity<>("Failed to update",HttpStatus.BAD_REQUEST);
        }

//        agar p null nai h means success updated
//        if(p!=null){
//            return new ResponseEntity<>("updated",HttpStatus.OK);
//        }
//        else
//            return new ResponseEntity<>("Failed to update",HttpStatus.BAD_REQUEST);
    }


//    delete ke liye, goto product.jsx, line 44
//    .delete(`${baseUrl}/api/product/${id}
//    ie delete request and /product/{id} par, bana do funcn
    @DeleteMapping("/product/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable int id){
        product p= service.getProductById(id);
//        service se bolo direct delete kar de
        if(p!=null){
            service.deleteProduct(id);
            return new ResponseEntity<>("Deleted",HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>("Product not found",HttpStatus.NOT_FOUND);
        }
    }


}
