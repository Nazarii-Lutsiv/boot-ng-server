package com.example.demo.user;

import com.example.demo.user.UserDAO;
import com.example.demo.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class AuthController {

    private final UserDAO userDAO;
    private final PasswordEncoder passwordEncoder;

    @PostMapping("/regist")
    public User saveUser(@Valid @RequestBody User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        //encode password
        return userDAO.save(user);
    }
}
