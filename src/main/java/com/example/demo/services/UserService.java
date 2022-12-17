package com.example.demo.services;

import com.example.demo.dto.Cadastro;
import com.example.demo.entity.User;
import com.example.demo.exceptions.UserNamePassowordException;
import com.example.demo.repositories.UserRespository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private UserRespository repository;

    public UserService(UserRespository repository) {
        this.repository = repository;
    }

    public User register(Cadastro cadastro) throws UserNamePassowordException {

        User user = new User(cadastro.getName(), cadastro.getPassword());
        this.repository.save(user);

        return user;
    }

    public List<User> listUsers() {
        return this.repository.findAll();
    }
}
