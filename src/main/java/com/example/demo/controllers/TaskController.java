package com.example.demo.controllers;

import com.example.demo.dto.TaskRequest;
import com.example.demo.entity.Task;
import com.example.demo.services.TaskService;
import com.sun.istack.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/task")
public class TaskController {

    private final TaskService registerTaskService;

    public TaskController(TaskService registerTaskService) {
        this.registerTaskService = registerTaskService;
    }

    @PostMapping("/register")
    public ResponseEntity<Task> registerTask(@RequestBody @NotNull final TaskRequest taskRequest, @RequestHeader final int userId) {
        Task newTask = this.registerTaskService.registerNewTask(taskRequest, userId);
        return new ResponseEntity<>(newTask, HttpStatus.OK);
    }

//    @GetMapping("/register")
//    public ResponseEntity<List<Task>> listTasks() {
//
//    }

}
