package com.github.amandaveredas.adressapi.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
public class ExceptionResponse {
private String message;

    public ExceptionResponse(String message) {
        super();
        this.message = message;
    }
}
