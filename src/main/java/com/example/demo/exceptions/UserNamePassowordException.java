package com.example.demo.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class UserNamePassowordException extends ResponseStatusException {
    public UserNamePassowordException() {
        super(HttpStatus.BAD_REQUEST, "Name/Password invalid");
    }
}
