package com.github.amandaveredas.adressapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserNotFoundException extends Exception {
    public UserNotFoundException(Integer id) {
        super("User not found with id: " + id);
    }
}
