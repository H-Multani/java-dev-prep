package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


//nakli kyu bana rahe ho, asli banao mard bano
public class AlienRepo {
    private Connection conn;
    private PreparedStatement stmt;

    public AlienRepo(){
//        aliens=new ArrayList<Alien>();
//
//        Alien a1=new Alien();
//        a1.setId(1);
//        a1.setName(" harsh ");
//        a1.setPoints(70);
//
//        Alien a2=new Alien();
//        a2.setId(2);
//        a2.setName(" wao ");
//        a2.setPoints(87);
//        List<Alien> ls= Arrays.asList(a1,a2);
//
//        aliens.add(a1);
//        aliens.add(a2);

//        ye area sabse pehle chalega, hence yaha par connections bana lo

//        sabse pehle connection banao
        try {
            conn=jdbcUtil.connectionBanao();


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    public List<Alien> getAliens() {
        List<Alien> ls=new ArrayList<Alien>();
//        query banao and return kardo
        try{
            stmt = conn.prepareStatement("select * from alien");

//            execute the query and rs nikal lo
            ResultSet rs=stmt.executeQuery();

//            rs se bande nikal kar list me add kardo
            while(rs.next()){
//                3 data 3no nikal lo and object me daal do
                Alien a=new Alien();
                a.setId(rs.getInt(1));
                a.setName(rs.getString(2));
                a.setPoints(rs.getInt(3));

//                values daalne ke baad object ko list me daal do
                ls.add(a);
            }

        }
        catch (SQLException e) {
            System.out.println("kuch toh fata data chalate tiem");

        }
        return ls;
    }

    public Alien getAlien(int id){

//        1 alien nikal kar dena hai toh DBMS se nikal kar dedo
        try{
            stmt = conn.prepareStatement("select * from alien where id=?");
            stmt.setInt(1,id);

//            execute the query and rs nikal lo
            ResultSet rs=stmt.executeQuery();

//            rs se bande nikal kar list me add kardo
            if(rs.next()){
//                3 data 3no nikal lo and object me daal do
                Alien a=new Alien();
                a.setId(rs.getInt(1));
                a.setName(rs.getString(2));
                a.setPoints(rs.getInt(3));

//                object bana hai yehi se return kardo
                return a;
            }

        }
        catch (SQLException e) {
            System.out.println("kuch toh fata data chalate tiem");
        }
//        kuch nai mila toh new bana kar bhejdo
        return new Alien();
    }

    public void create(Alien a){
//        aliens.add(a);

//        alien aaya hai na insert kardo
        try{
            stmt = conn.prepareStatement("insert into alien(id,name,points) values(?,?,?)");
            stmt.setInt(1,a.getId());
            stmt.setString(2,a.getName());
            stmt.setInt(3,a.getPoints());

//            execute the query and rs nikal lo
            int updatedLines=stmt.executeUpdate();
//            agar line update ho gayi then GG, bata do

//            else batao ki insert nai kar paaye
            if(updatedLines>0) System.out.println("inserted into dbms");
            else{
                System.out.println("couldnt insert into dbms");
            }
        }
        catch (SQLException e){
            System.out.println("update nai kar paaye");
        }

    }

//    if we want to update an alien data, uska bhi funcn yaha aayega
//    we have to update name and points, id common rahega
    public void update(Alien a){

//        alien aaya hai na insert kardo
        try{
            stmt = conn.prepareStatement("update alien set name=?, points=? where id=?");
            stmt.setString(1,a.getName());
            stmt.setInt(2,a.getPoints());
            stmt.setInt(3,a.getId());

//            execute the query and rs nikal lo
            int updatedLines=stmt.executeUpdate();
//            agar line update ho gayi then GG, bata do

//            else batao ki insert nai kar paaye
            if(updatedLines>0) System.out.println("updated dbms");
            else{
                System.out.println("couldnt update data");
            }
        }
        catch (SQLException e){
            System.out.println("update nai kar paaye");
        }

    }



//    if we want to delete an alien data, uska bhi funcn yaha aayega
    public void delete(int id){
//        delete kardo bande ko

        try{
            stmt = conn.prepareStatement("delete from alien where id=?");
            stmt.setInt(1,id);

//            execute the query and rs nikal lo
            int updatedLines=stmt.executeUpdate();
//            agar line update ho gayi then GG, bata do

//            else batao ki delete nai kar paye
            if(updatedLines>0) System.out.println(" delete kar diye");
            else{
                System.out.println("delete nai kar paye, return 0");
            }
        }
        catch (SQLException e){
            System.out.println("update nai kar paaye");
        }

    }

}
