package com.devrahul.inotebook.service;
import com.devrahul.inotebook.entity.UserEntity;
import com.devrahul.inotebook.model.GetUser;
import com.devrahul.inotebook.model.LoginUserDTO;
import com.devrahul.inotebook.model.UserSignup;
import com.devrahul.inotebook.repository.UserRepository;
import com.devrahul.inotebook.utility.DataValidation;
import com.devrahul.inotebook.utility.security.Security;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<Object> registerUser(UserSignup userSignup) {
        List<Object> regResult = new ArrayList<>();

        if (DataValidation.emailValidation(userSignup.getEmail()) && DataValidation.passwordValidation(userSignup.getPassword()) && DataValidation.nameValidation(userSignup.getName())) {
            if (userRepository.findByEmail(userSignup.getEmail()) == null) {
                try {
                    UserEntity newUser = new UserEntity();
                    newUser.setName(userSignup.getName());
                    newUser.setEmail(userSignup.getEmail());
                    newUser.setPassword(Security.passwordEncoding(userSignup.getPassword()));
                    newUser.setDate(new Date());
                    userRepository.save(newUser);
                    regResult.add(1);
                    regResult.add(Security.jwtTokenGenerator(newUser.getId()));

                    return regResult;
                } catch (Exception e) {
                    e.printStackTrace();
                    regResult.add(0);
                    regResult.add(e.getMessage());
                    return regResult;
                }
            } else {
                regResult.add(0);
                regResult.add("Email already registered");
            }

        }
        regResult.add(0);
        regResult.add("Please provide correct details to register");
        return regResult;
    }

    public List<Object> authUser(LoginUserDTO loginUserDTO) {
        List<Object> regResult = new ArrayList<Object>();
        if (DataValidation.emailValidation(loginUserDTO.getEmail()) && DataValidation.passwordValidation(loginUserDTO.getPassword())) {
            try {
                UserEntity user = userRepository.findByEmail(loginUserDTO.getEmail());
                boolean passwordVerify = Security.passwordMatcher(loginUserDTO.getPassword(), user.getPassword());
                if (!passwordVerify) {
                    regResult.add(0);
                    regResult.add("Email or Password doesn't match");
                    return regResult;
                } else {
                    String authToken = Security.jwtTokenGenerator(user.getId());
                    regResult.add(1);
                    regResult.add(authToken);
                    return regResult;
                }
            } catch (Exception e) {
                regResult.add(0);
                regResult.add(e.getMessage());
                return regResult;
            }
        }

        regResult.add(0);
        regResult.add("Please provide valid details to login");
        return regResult;

    }

    public List<Object> getUser(String token) {
        String userID = Security.getUserIdFromJwtToken(token);
        List<Object> regResult = new ArrayList<Object>();

        if (userID != null) {
            try {
                UserEntity userEntity =  userRepository.findById(userID).get();
                GetUser user = new GetUser();
                user.setId(userID);
                user.setEmail(userEntity.getEmail());
                user.setDate(userEntity.getDate());
                user.setName(userEntity.getName());
                regResult.add(1);
                regResult.add(user);
                return regResult;

            } catch (Exception e) {
                regResult.add(0);
                regResult.add(e.getMessage());
                return regResult;
            }
        }
        regResult.add(0);
        regResult.add("Please authenticate using valid token");
        return regResult;
    }
}