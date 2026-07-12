package com.example.spring01;

import org.springframework.data.repository.CrudRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


//class ko interface bana do since
//extend kara do with CrudRepository<konsi class ke sath kaam karre for dbms, primary kry ka data type>
// (int nai dalna since primitive hai use Integer)
//isme boht methods hai baad me karna implement
public interface AlienRepo extends CrudRepository<Alien,Integer> {

}
