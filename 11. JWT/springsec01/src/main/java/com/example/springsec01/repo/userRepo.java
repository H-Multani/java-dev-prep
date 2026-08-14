package com.example.springsec01.repo;
import com.example.springsec01.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;


//jpa extend karva do, and since yaha user table rahega toh vo naam likh dena and primary key ka type which is
@Repository
public interface userRepo extends JpaRepository<Users,Integer>{
    Users findByUsername(String username);
}
