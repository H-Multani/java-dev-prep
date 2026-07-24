package com.example.spring06.repository;


import com.example.spring06.model.alien;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//yaha well connect to the database


//since we want spring to manage this we write @component,
// same EXACT cheex repository ke andar we use @Repository, both work EXACTLY same
@Repository
public class alienrepo {

//    jdbc se kaam karane ke liye we need JDBC template bana do
    private JdbcTemplate template;
//    iske getter setter bana lena


    public JdbcTemplate getTemplate() {
        return template;
    }

//    template ka object chahiye, spring bana kar dega for that @autowires
    @Autowired
    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }

    //    to save the alien object to database
    public void save(alien a){
//        added
//        System.out.println("added");


//        for non select query like insert update we used executeUpdate()
//        to do that here we do update();
        String query="insert into alien(id,name,tech) values (?,?,?)";
//        ?? hai means prepareStmt chalra by default

        template.update(query,a.getId(),a.getName(),a.getTech());



    }


//    funcn to see all aliens of db
    public List<alien> findall(){
        String sql="select * from alien";
//        data nikal kar daalna padega kahi,
//        ResultSet use kar sakte, but ill use rowmapper, ye interface hai toh yehi implement kardo kya hi hai temporarily
        RowMapper<alien> mapper=new RowMapper<alien>() {
            @Override
            public alien mapRow(ResultSet rs, int rowNum) throws SQLException {
//                yaha implement karna padega ye bakchodi

//                result set milega isko toh alien bana kar bhej do har bande ka,
//                apan ek ka logic likhenge, banda interally sabke liye kar dega
                alien a=new alien();
                a.setId(rs.getInt(1));
                a.setName(rs.getString(2));
                a.setTech(rs.getString(3));

                return a;
            }
        };

//        for select query we used executeQuery()
//        to do that here we do query()
        List<alien> aliens = template.query(sql,mapper);
//        output aayega list me daal do



        return aliens;
    }

}
