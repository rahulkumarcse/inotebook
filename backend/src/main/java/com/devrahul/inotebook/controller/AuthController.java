package com.devrahul.inotebook.controller;

import com.devrahul.inotebook.entity.UserEntity;
import com.devrahul.inotebook.model.UserSignup;
import com.devrahul.inotebook.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/v1/auth")
public class AuthController {

    @Autowired
    UserService userService;
    @PostMapping("/login")
    private ResponseEntity<Object> sendDummy(){
        return ResponseEntity.ok("Sent");
    }

    @PostMapping("/regUser")
    private  ResponseEntity<?> registerUser(@RequestBody UserSignup userReg){
        UserEntity entity_entity=userService.registerUser(userReg);
        if(entity_entity!=null){
            return new ResponseEntity<UserEntity>(entity_entity, HttpStatus.OK);
        }
        else {
            return  new ResponseEntity<>("Please provide valid details for registration",HttpStatus.BAD_REQUEST);
        }
    }
}
