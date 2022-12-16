package com.example.demo;

import com.example.demo.entity.Cadastro;
import com.example.demo.entity.User;
import com.example.demo.exceptions.UserNamePassowordException;
import com.example.demo.services.RegisterUserService;
import com.sun.istack.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class HelloWorldController {
    private final RegisterUserService registerUserService;

    public HelloWorldController(RegisterUserService registerUserService) {
        this.registerUserService = registerUserService;
    }

    @GetMapping("/")
    public String helloWorld() {
        return "Hello World";
    }

    @GetMapping("/salve")
    public String salve() {
        return "Salve salve";
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<User> cadastrar(@RequestBody @NotNull final Cadastro cadastro) {

        try {
            User user = this.registerUserService.register(cadastro);
            return new ResponseEntity<User>(user, HttpStatus.OK);
        } catch (UserNamePassowordException exception) {
            throw exception;
        }
    }
}
