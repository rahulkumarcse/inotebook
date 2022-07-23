package com.devrahul.inotebook.utility.security;


import com.devrahul.inotebook.model.UserData;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class Security implements Serializable {

   // static String JWT_SECRET =System.getProperties().getProperty("auth.secret_key");
   // @Value("${jwt.secret}")
    static String JWT_SECRET ="Hello guys this is going to be secret key" ;

  public static  String passwordEncoding(String password){
      PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
      return  passwordEncoder.encode(password);
  }
  public  static boolean passwordMatcher(String plainText, String encryptedPassword){
      PasswordEncoder passwordMatcher = new BCryptPasswordEncoder();
      return passwordMatcher.matches(plainText,encryptedPassword);
  }
   public  static String jwtTokenGenerator(String userData){
       Map<String, Object> claims = new HashMap<>();
       System.out.println(JWT_SECRET);
       String jwtToken = Jwts.builder().setClaims(claims).setSubject(userData).setIssuedAt(new Date(System.currentTimeMillis()))
               .setExpiration(new Date(System.currentTimeMillis() + 5*60*60 * 1000))
               .signWith(SignatureAlgorithm.HS512, JWT_SECRET).compact();
       return jwtToken;

   }


    }

