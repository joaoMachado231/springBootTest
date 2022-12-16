package com.example.demo.services;

import com.example.demo.entity.User;
import com.example.demo.repositories.UserRespository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListUserService {

    private UserRespository repository;

    public ListUserService(UserRespository repository) {
        this.repository = repository;
    }

    public List<User> listUsers() {
        return this.repository.findAll();
    }
}
