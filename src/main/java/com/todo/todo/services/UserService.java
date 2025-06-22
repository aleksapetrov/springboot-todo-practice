package com.todo.todo.services;

import com.todo.todo.entities.Task;
import com.todo.todo.entities.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface UserService {

    User add(User user);

    Optional<User> findByUsername(String username);

    Optional<User> findById(long id);

    Page<User> findAll(Pageable pageable);

    Page<User> findByUsernameContainingIgnoreCase(Pageable pageable, String username);


    // korisnici?page=3 size=30



}
