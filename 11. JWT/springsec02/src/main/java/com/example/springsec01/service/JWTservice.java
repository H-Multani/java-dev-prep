package com.example.springsec01.service;


import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.*;

@Service
public class JWTservice {

//    secret key bana do
    private String secretKey;

//    constructor bana lo key generate karne ke liye
    public JWTservice(){
//        key generator use karlo
        try {
//            keygen ko algo batana padega konsa use karre ho
            KeyGenerator keygen=KeyGenerator.getInstance("HmacSHA256");
            SecretKey sk=keygen.generateKey();

//            ab we can use base64 encoder to encode the key to string
            secretKey=Base64.getEncoder().encodeToString(sk.getEncoded());

        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public String generateToken(String username) {
//        ye method token bana kar dega


//        token me boht cheez rehti like name, issue date, expiry etc
//        so we can create a map of claims, jisme store kar lenge sab item,
//        key will be string, and value will be object since change hota rahega
        Map<String, Object> myclaims=new HashMap<>();


        return Jwts.builder()
//                 JWt ka builder use karenge
                .claims()
//                we need to add out custom claims here hence map add kardo, this is payload section
                .add(myclaims)
//                ab claims add karre hai apan custom

//                subject is basically username
                .subject(username)
//                issuance time lagana hai, ki kab issue kiya gaya ye token
//                abhi apan jo bhi current time hai daal denge, object bana kar
                .issuedAt(new Date(System.currentTimeMillis()))
//                expiration bhi de sakte hai, expiration ke sath extra time dena padega
                .expiration(new Date(System.currentTimeMillis()+(60*60*10)))

//                itne hi claims chahiye the, ab main builder par jane ke liye
                .and()
//                 sign bhi dena padega apan ko, and uske liye cryptographic key chahiye, funcn se bulva lo
                .signWith(getkey())
//                ab ye sab ke baad token generate karne ke liye, string is generated of token
                .compact();


//        return "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6IkpvaG4gRG9lIiwiYWRtaW4iOnRydWUsImlhdCI6MTUxNjIzOTAyMn0.KMUFsIDTnFmyG3nMiGM6H9FNFUROf3wh7SmqJp-QV30";
    }

    private Key getkey() {
//        string wali key ko pehle byte me convert karo, using Decoders
        byte[] keybytes= Decoders.BASE64.decode(secretKey);

        return Keys.hmacShaKeyFor(keybytes);
    }
}
