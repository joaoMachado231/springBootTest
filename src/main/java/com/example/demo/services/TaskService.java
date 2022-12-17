package com.example.demo.services;

import com.example.demo.dto.TaskRequest;
import com.example.demo.entity.Task;
import com.example.demo.entity.User;
import com.example.demo.repositories.TaskRepository;
import com.example.demo.repositories.UserRespository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TaskService {

    private TaskRepository taskRepository;

    private UserRespository userRespository;

    public TaskService(TaskRepository taskRepository, UserRespository userRespository) {
        this.taskRepository = taskRepository;
        this.userRespository = userRespository;
    }

    public Task registerNewTask(TaskRequest taskRequest, int userId) {

        Optional<User> userOptional = userRespository.findById(userId);

        User user = userOptional.get();

        Task task = new Task(taskRequest.getName(), taskRequest.getDescription(), taskRequest.getInitDate(), taskRequest.getEndDate(), user);

        taskRepository.save(task);

        return task;
    }

//    public List<Task> listUserTasks(int userId) {
//        taskRepository.fin
//    }
}
