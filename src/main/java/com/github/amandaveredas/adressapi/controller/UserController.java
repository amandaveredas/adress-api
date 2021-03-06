package com.github.amandaveredas.adressapi.controller;

import com.github.amandaveredas.adressapi.entity.User;
import com.github.amandaveredas.adressapi.exception.EmptyListException;
import com.github.amandaveredas.adressapi.exception.UserNotFoundException;
import com.github.amandaveredas.adressapi.response.MessageResponse;
import com.github.amandaveredas.adressapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public ResponseEntity<User> getById(@PathVariable Integer id) throws UserNotFoundException {
        User userFound = userService.getById(id);
        return new ResponseEntity<User>(userFound, HttpStatus.OK);
    }

    @GetMapping("/list")
    public ResponseEntity<List> getAll() throws EmptyListException {
        List<User> users =  userService.getAll();
        return new ResponseEntity<List>(users, HttpStatus.OK);
    }

    @PostMapping("/user")
    public ResponseEntity<User> create(@RequestBody @Valid User user) {
        userService.create(user);
        return new ResponseEntity<User>(user, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Integer id) throws UserNotFoundException {
        userService.delete(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateById(@PathVariable Integer id, @RequestBody @Valid User user) throws UserNotFoundException {
        userService.updateById(id, user);
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }





}
