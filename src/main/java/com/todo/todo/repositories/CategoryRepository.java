package com.todo.todo.repositories;

import com.todo.todo.entities.Category;
import com.todo.todo.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    List<Category> findByUser(User user);

}
