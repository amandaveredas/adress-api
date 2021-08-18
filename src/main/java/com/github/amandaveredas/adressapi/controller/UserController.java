package com.github.amandaveredas.adressapi.controller;

import com.github.amandaveredas.adressapi.entity.User;
import com.github.amandaveredas.adressapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody @Valid User user) {
        userService.create(user);

    }

}
