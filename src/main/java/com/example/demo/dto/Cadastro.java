package com.example.demo.dto;

import com.sun.istack.NotNull;

public class Cadastro {

    private String name;

    private String password;

    public Cadastro(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }
}
