package com.todo.todo.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
// users/id/categories - POST

// users/2/categories - POST
@Entity
@Table(name="category_entity")
public class Category {
    // user i kategorija
    //

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    @ManyToOne
    private User user;


    @ManyToMany
    private List<Task> tasks = new ArrayList<>();

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }
}