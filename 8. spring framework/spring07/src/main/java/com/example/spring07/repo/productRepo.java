package com.example.spring07.repo;


import com.example.spring07.model.product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//    we will only define methods here, JPA bana dega definition
@Repository
public interface productRepo extends JpaRepository<product,Integer>{

//    since we need JPA to take care of everything, we extend that class here, yaha we mention 2 things
//    <class name jisse kaam kar rhe,primary key ka type>

//    since JPA repo ko extend kiya hai toh iss interface ka child class inherited apne se bana dega JPA seedha use karo

}
