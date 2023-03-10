package com.example.demo.controllers;

import com.example.demo.dto.TaskRequest;
import com.example.demo.entity.Task;
import com.example.demo.exceptions.UserNotFoundException;
import com.example.demo.services.TaskService;
import com.sun.istack.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping("/task")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/list")
    public ResponseEntity<List<Task>> listTasks(@RequestHeader final int userId) {
        List<Task> taskList = this.taskService.listUserTasks(userId);
        return  new ResponseEntity<>(taskList, HttpStatus.OK);
    }

    @PostMapping("/register")
    public ResponseEntity registerTask(@RequestBody @NotNull final TaskRequest taskRequest, @RequestHeader final int userId) {
        Task newTask = this.taskService.registerNewTask(taskRequest, userId);
        return new ResponseEntity<>(newTask, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete")
    @Transactional
    public ResponseEntity deleteTask(@RequestHeader final int taskId) {
        this.taskService.deleteTask(taskId);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
