package com.example.demo.exceptionHandler;

import com.example.demo.exceptions.UserNamePassowordException;
import com.example.demo.exceptions.UserNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class ControllerExcpetionHandler {

    @ExceptionHandler(value = UserNotFoundException.class)
    public ResponseEntity userNotFoundHandler(UserNotFoundException exception, WebRequest request) {
        return new ResponseEntity(exception.getReason(), exception.getStatus());
    }

    @ExceptionHandler(value = UserNamePassowordException.class)
    public ResponseEntity userNamePasswordHandler(UserNamePassowordException exception, WebRequest request) {
        return new ResponseEntity(exception.getReason(), exception.getStatus());
    }

}
