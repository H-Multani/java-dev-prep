package com.example.springsec01.service;


import org.springframework.stereotype.Service;

@Service
public class JWTservice {
    public String generateToken() {
//        ye method token bana kar dega

//        abhi ke liye jwt.io se random token generate karke bhej diya
//        lekin isme dikkat hai ki sab users ka same token hai,
//        toh aage dekhenge ki different users ke liye different tokens kaise nikale
        return "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6IkpvaG4gRG9lIiwiYWRtaW4iOnRydWUsImlhdCI6MTUxNjIzOTAyMn0.KMUFsIDTnFmyG3nMiGM6H9FNFUROf3wh7SmqJp-QV30";
    }
}
