package com.learningsecurity.springsecurity.service;

import com.learningsecurity.springsecurity.model.Users;
import com.learningsecurity.springsecurity.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsersService {

    @Autowired
    private UserRepo repo;

    @Autowired
    private JWTService jwtService;

    @Autowired
     private AuthenticationManager authenticationManager;

    BCryptPasswordEncoder encoder =new BCryptPasswordEncoder(12);

    public Users addUser(Users user) {
        user.setPassword(encoder.encode(user.getPassword()));
       return repo.save(user);
    }

    public String verifyUser(Users user) {
        Authentication authentication=authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
        if(authentication.isAuthenticated()) {
            return jwtService.generateToken(user.getUsername());
        }
        return "fail";

    }
}
