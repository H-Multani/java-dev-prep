package com.example.backend.repo;


import com.example.backend.model.product;
import org.apache.catalina.LifecycleState;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

//ye extend karega JPA ko toh basic functions like save nd all automatically ban jaenge
@Repository
public interface productRepo extends JpaRepository<product,Integer> {

//    JPQL can be used to query for specific things like categories, names etc

//    funcn to search product accd to input, if input is catoegory we do by category, and so on

//    since this will run a custom query therefore we have to annotate using @query
//    and uske andar JPQL query custom likh sakte ezpz using keywords of funcn
//    jpa apne aap keyword ka use karke query bana kar run kar dega and output return kar dega
    @Query("select p from product p where "+
            "lower(p.name) like lower(concat('%',:keyword,'%')) or "+
            "lower(p.description) like lower(concat('%',:keyword,'%')) or "+
            "lower(p.brand) like lower(concat('%',:keyword,'%')) or "+
            "lower(p.category) like lower(concat('%',:keyword,'%'))"
    )
    List<product> searchProducts(String keyword);
}
