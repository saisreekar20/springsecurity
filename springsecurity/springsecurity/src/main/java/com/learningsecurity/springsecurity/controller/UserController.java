package com.learningsecurity.springsecurity.controller;

import com.learningsecurity.springsecurity.model.Users;

import com.learningsecurity.springsecurity.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UsersService usersService;

   @PostMapping("/register")
    public Users register(@RequestBody Users user) {
       return  usersService.addUser(user);
   }

   @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody Users user) {
       return new ResponseEntity<>(usersService.verifyUser(user),HttpStatus.FOUND);
   }
}
