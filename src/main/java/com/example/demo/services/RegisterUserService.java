package com.example.demo.services;

import com.example.demo.entity.Cadastro;
import com.example.demo.entity.User;
import com.example.demo.exceptions.UserNamePassowordException;
import com.example.demo.repositories.UserRespository;
import org.springframework.stereotype.Service;

@Service
public class RegisterUserService {

    private UserRespository repository;

    public RegisterUserService(UserRespository repository) {
        this.repository = repository;
    }

    public User register(Cadastro cadastro) throws UserNamePassowordException {

        User user = new User(cadastro.getName(), cadastro.getPassword());
        this.repository.save(user);

        return user;
    }
}
