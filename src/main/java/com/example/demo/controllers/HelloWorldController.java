package com.example.demo.controllers;

import com.example.demo.dto.Cadastro;
import com.example.demo.entity.User;
import com.example.demo.exceptions.UserNamePassowordException;
import com.example.demo.services.UserService;
import com.sun.istack.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class HelloWorldController {
    private final UserService userService;


    public HelloWorldController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String helloWorld() {
        return "Hello World";
    }

    @GetMapping("/salve")
    public String salve() {
        return "Salve salve";
    }

    @GetMapping("/listar")
    public ResponseEntity<List<User>> listarUsuarios() {
        List<User> users = this.userService.listUsers();
        return new ResponseEntity<List<User>>(users, HttpStatus.OK);
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<User> cadastrar(@RequestBody @NotNull final Cadastro cadastro) {
        try {
            User user = this.userService.register(cadastro);
            return new ResponseEntity<User>(user, HttpStatus.OK);
        } catch (UserNamePassowordException exception) {
            throw exception;
        }
    }
}
