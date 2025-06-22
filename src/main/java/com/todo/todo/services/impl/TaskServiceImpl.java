package com.todo.todo.services.impl;

import com.todo.todo.entities.Task;
import com.todo.todo.entities.User;
import com.todo.todo.repositories.TaskRepository;
import com.todo.todo.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    TaskRepository taskRepository;



    @Override
    public List<Task> findAll() {
        return taskRepository.findAll();
    }

    @Override
    public Optional<Task> findById(long id) {
        return taskRepository.findById(id);
    }

    @Override
    public void deleteById(long id) {
        taskRepository.deleteById(id);
    }

    @Override
    public Task add(Task task) {


        return taskRepository.save(task);
    }

    @Override
    public Task update(Task task) {

        return taskRepository.save(task);
    }

    @Override
    public List<Task> findByFinished(boolean finished) {
        return taskRepository.findByFinished(finished);
    }

    @Override
    public List<Task> findByTitleContainingIgnoreCaseAndUser(String title, User user) {
        return taskRepository.findByTitleContainingIgnoreCaseAndUser(title, user);
    }

    @Override
    public List<Task> findTasksByUser(User user) {
        return taskRepository.findByUser(user);
    }


}
