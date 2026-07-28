package com.example.backend.service;


import com.example.backend.model.product;
import com.example.backend.repo.productRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class productService {

//    yaha repo ka object bana do since usse hi bolenge data laane ko, and since we want ki spring object banaye toh autowire kardo
    @Autowired
    private productRepo repo;

    public List<product> getAllProducts() {
//        repo se bolo all products nikal kar de

        return repo.findAll();

    }

    public product getProductById(int id) {
//        repo se bolo required id wala banda laa kar de

//        ye funcn apne me fatega since ye sirf tabhi object dega if it exists,
//        otherwise fatega, ye humko handle karna,
//        toh we add orElse, give a new object
        return repo.findById(id).orElse(null);
//        usually we should get status code or smth here too but we dont have that so.....
//        laga diya status code jaha ye funcn call hora controller me
    }

    public product addProduct(product prod, MultipartFile image) throws IOException {
//        to send image we have to convert to bytes+name+type of image
//        toh jo object aaya hai usme hi changes kardo end me sab ek sath save kar dena
        prod.setImageName(image.getOriginalFilename());
        prod.setImageType(image.getContentType());
        prod.setImageData(image.getBytes());

//        ab prod me hi sab data properly update kar diye hai send to repo to update
        return repo.save(prod);
    }

    public product updateProduct(int id, product prod, MultipartFile image) throws IOException {

//        product me image daal do
        prod.setImageData(image.getBytes());
        prod.setImageName(image.getOriginalFilename());
        prod.setImageType(image.getContentType());
//        repo me update kardo product
        return repo.save(prod);
    }

    public void deleteProduct(int id) {
        repo.deleteById(id);
    }
}
