package com.example.demo.controllers;

import com.example.demo.dto.Cadastro;
import com.example.demo.entity.User;
import com.example.demo.services.UserService;
import com.sun.istack.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class UserController {
    private final UserService userService;


    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String helloWorld() {
        return "Hello World";
    }

    @GetMapping("/listar")
    public ResponseEntity<List<User>> listarUsuarios() {
        List<User> users = this.userService.listUsers();
        return new ResponseEntity<List<User>>(users, HttpStatus.OK);
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<User> cadastrar(@RequestBody @NotNull final Cadastro cadastro) {
        User user = this.userService.register(cadastro);
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }
}
