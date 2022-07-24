package com.devrahul.inotebook;

import com.devrahul.inotebook.utility.security.Security;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.internal.matchers.Equals;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.util.Assert;


public class EncryptionTest {

    @Test
    public void encrptionTest(){
        String password= "dummy";
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword=  passwordEncoder.encode(password);
        System.out.println(encodedPassword);
    }
    @Test
    public void decryptionTest(){
        String password="dummy";
        String encodedPassword="$2a$10$fKwPqU0cHLtdqcgMor9LO.xI1fmPPlhZPrzQHClX8/vbCXJzo89BO";
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        boolean decryptedPassword = passwordEncoder.matches(password,encodedPassword);
        Assert.isTrue(decryptedPassword,"Decryption is not working");
        Assertions.assertEquals(decryptedPassword ,true);

    }
    @Test
    public void checkJwtToken(){
        String name ="dum@my";
        String token = Security.jwtTokenGenerator(name);
        String reverseName=Security.getUserEmailFromJwtToken(token+"s");
        System.out.println(reverseName);
    }

}
