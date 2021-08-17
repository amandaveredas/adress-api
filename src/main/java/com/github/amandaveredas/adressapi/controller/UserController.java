package com.github.amandaveredas.adressapi.controller;

import com.github.amandaveredas.adressapi.entity.User;
import com.github.amandaveredas.adressapi.repository.UserRepository;
import com.github.amandaveredas.adressapi.service.UserService;
import org.aspectj.bridge.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/list")
    public List<User> getAll() {
        return userService.getAll();
    }

   @PostMapping("/user")
    public void insert(@RequestBody User user){
        userService.create(user);
    }

}
