package com.todo.todo.services;

import com.todo.todo.entities.Category;
import com.todo.todo.entities.User;

import java.util.List;
import java.util.Optional;

public interface CategoryService {

    Category add(Category category);

    List<Category> findAll();

    Category update(Category category);

    void deleteById (long id);

    List<Category> findByUser (User user);

    Optional<Category> findById(long id);
}
