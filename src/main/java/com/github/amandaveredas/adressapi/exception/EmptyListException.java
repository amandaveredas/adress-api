package com.github.amandaveredas.adressapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class EmptyListException extends Exception {
    public EmptyListException(){
        super("No users were found!");
    }

}
