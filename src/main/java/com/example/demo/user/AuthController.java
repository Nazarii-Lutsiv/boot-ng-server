package com.example.demo.user;

import com.example.demo.user.UserDAO;
import com.example.demo.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {


    @Autowired
    UserDAO userDAO;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/regist")
    public String saveUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        //encode password
        userDAO.save(user);
        return "regist";
    }
}
