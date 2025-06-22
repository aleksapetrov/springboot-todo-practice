package com.todo.todo.services;

import com.todo.todo.entities.Task;
import com.todo.todo.entities.User;

import java.util.List;
import java.util.Optional;

public interface TaskService {
    List<Task> findAll();
    Optional<Task> findById(long id);
    void deleteById(long id);
    Task add(Task task);
    Task update(Task task);

    List<Task> findByFinished(boolean finished);

    List<Task> findByTitleContainingIgnoreCaseAndUser(String title, User user);

    List<Task> findTasksByUser(User user);
}
