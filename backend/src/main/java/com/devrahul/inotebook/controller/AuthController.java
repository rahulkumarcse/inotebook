package com.devrahul.inotebook.controller;

import com.devrahul.inotebook.model.LoginUserDTO;
import com.devrahul.inotebook.model.UserSignup;
import com.devrahul.inotebook.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/auth")
public class AuthController {

    @Autowired
    UserService userService;

    @PostMapping("/addUser")
    private  ResponseEntity<?> registerUser(@RequestBody UserSignup userReg){
        List<Object> regResult = userService.registerUser(userReg);
        if(regResult.get(0).toString() .equals("1")){
            return new ResponseEntity<>(regResult.get(1),HttpStatus.OK);
        }
        else return new ResponseEntity<>(regResult.get(1),HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/login")
    private  ResponseEntity<?> authUser(LoginUserDTO loginUserDTO){
        List<Object> regResult = userService.authUser(loginUserDTO);
        if(regResult.get(0).toString() .equals("1")){
            return new ResponseEntity<>(regResult.get(1),HttpStatus.OK);
        }
        else return new ResponseEntity<>(regResult.get(1),HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/getUser")
    private ResponseEntity<?> getUser(@RequestHeader String token){

        List<Object> regResult = userService.getUser(token);
        if(regResult.get(0).toString() .equals("1")){
            return new ResponseEntity<>(regResult.get(1),HttpStatus.OK);
        }
        else return new ResponseEntity<>(regResult.get(1),HttpStatus.BAD_REQUEST);
    }
}
