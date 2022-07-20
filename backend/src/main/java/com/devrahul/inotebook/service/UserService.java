package com.devrahul.inotebook.service;

import com.devrahul.inotebook.entity.UserEntity;
import com.devrahul.inotebook.model.UserSignup;
import com.devrahul.inotebook.repository.UserRepository;
import com.devrahul.inotebook.utility.DataValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.crypto.Data;
import java.time.Instant;
import java.util.Date;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public UserEntity registerUser(UserSignup userSignup){
        if(DataValidation.emailValidation(userSignup.getEmail()) && DataValidation.passwordValidation(userSignup.getPassword()) && DataValidation.nameValidation(userSignup.getName())){
            UserEntity newUser= new UserEntity();
            newUser.setName(userSignup.getName());
            newUser.setEmail(userSignup.getEmail());
            newUser.setPassword(userSignup.getPassword());
            newUser.setDate(new Date());
         userRepository.save(newUser);
return  newUser;
        }
        else return null;
    }
}
