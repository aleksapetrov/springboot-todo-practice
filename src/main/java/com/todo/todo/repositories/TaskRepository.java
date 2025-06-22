package com.todo.todo.repositories;

import com.todo.todo.entities.Task;
import com.todo.todo.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {
    // jpa named queries
    // dobijamo metode save, findbyid, deletebyid....
    // ali mozemo i prosiriti dodatnim metodama
    List<Task> findByTitleContainingIgnoreCaseAndUser(String title, User user);
    List<Task> findByFinished(boolean finished);

    List<Task> findByUser(User user);


    // pogledaj na netu named jpa queries



}

