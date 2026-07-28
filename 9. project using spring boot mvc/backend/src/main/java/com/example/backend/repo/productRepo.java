package com.example.backend.repo;


import com.example.backend.model.product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//ye extend karega JPA ko toh basic functions like save nd all automatically ban jaenge
@Repository
public interface productRepo extends JpaRepository<product,Integer> {

}
