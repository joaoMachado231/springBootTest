package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userId")
    private int userId;

    @Column(name = "name")
    private String name;

    @JsonIgnore
    @Column(name = "password")
    private String password;

    @OneToMany(mappedBy = "user")
    private List<Task> taskList;

    public User() {};

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public int getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public List<Task> getTaskList() {
        return taskList;
    }
}
