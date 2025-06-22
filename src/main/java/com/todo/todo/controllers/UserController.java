package com.todo.todo.controllers;


import com.todo.todo.entities.Category;
import com.todo.todo.entities.Chat;
import com.todo.todo.entities.Task;
import com.todo.todo.entities.User;
import com.todo.todo.services.CategoryService;
import com.todo.todo.services.ChatService;
import com.todo.todo.services.TaskService;
import com.todo.todo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("users")
public class UserController {


    @Autowired
    TaskService taskService;
    @Autowired
    UserService userService;
    @Autowired
    CategoryService categoryService;

    @Autowired
    ChatService chatService;


    // zadatak
    // napraviti pod rutu id/tasks - GET
    // koja vraca sve taskove za tog korisnika sa tim id-em
    // (users/id/tasks)
    // i ako korisnik sa tim id-em ne postoji da vrati 404 status kod gre[ku


    // users/2/tasks - GET

    // users/2/tasks - POST

    // users/103/tasks - 404

    // users/id/tasks?search=naslov
    // /users

    // /users

    // /users?page=3&size=10


    // pageable je nosac informacija koja je strane, koliko ima podataka na strani, uredjenost itd.


    // users?page=3&search=john
    @GetMapping
    public ResponseEntity<Page<User>> getAll(Pageable pageable, @RequestParam String search) {
        Page<User> usersPage = userService.findByUsernameContainingIgnoreCase(pageable, search);
        return new ResponseEntity<>(usersPage, HttpStatus.OK);
    }




    // users/id/tasks?search=skola
    @GetMapping ("{id}/tasks")
    public ResponseEntity<List<Task>> getTask(@PathVariable long id, @RequestParam String search) {
        // nadji korisnika sa tim id-em
        Optional<User> userOptional = userService.findById(id);
        if(userOptional.isPresent()){
            User user = userOptional.get();
            List<Task> tasks = taskService.findByTitleContainingIgnoreCaseAndUser(search ,user);
            return new ResponseEntity<>(tasks, HttpStatus.OK);

        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);


        // TODO domaci dovrsi


    }

    // TODO domaci
    // napravi pod rutu id/tasks koja sluzi za dodavanje taska za korisnika sa tim id-em
    // i ako korisnik sa tim id-em ne postoji vrati 404 status kod gresku


    // users/2/tasks - GET
    @PostMapping("{id}/tasks")
    public ResponseEntity<Task> postTask(@PathVariable long id, @RequestBody Task task) {
        Optional<User> userOptional = userService.findById(id);
        if(userOptional.isPresent()) {
            task.setUser(userOptional.get());
            Task savedTask = taskService.add(task);
            return new ResponseEntity<>(savedTask, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // zadatak
    // users/id/categories - GET
    // dobavlja SVE kategorije
    @GetMapping ("{id}/categories")
    public ResponseEntity<List<Category>> getCategoriesByUser(@PathVariable long id) {
        Optional<User> userOptional =userService.findById(id);
        if(userOptional.isPresent()) {
            User user = userOptional.get();
            List<Category> categoryList = categoryService.findByUser(user);
            return new ResponseEntity<>(categoryList, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // TODO domaci
    // napraviti rutu users/id/categories - POST
    @PostMapping ("{id}/categories")
    public ResponseEntity<Category> postCategory(@PathVariable long id, @RequestBody Category category) {
        Optional<User> userOptional = userService.findById(id);
        if (userOptional.isPresent()) {
            category.setUser(userOptional.get());
            Category savedCategory = categoryService.add(category);
            return new ResponseEntity<>(savedCategory, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // users/id/chats - GET, daje sve cetove u kojem se korisnik sa tim id-em nalazi
    @GetMapping ("{id}/chats")
    public ResponseEntity<List<Chat>> getChatsByUser (@PathVariable long id) {
        Optional<User> userOptional = userService.findById(id);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            List<Chat> chatList = chatService.findByUser(user);
            return new ResponseEntity<>(chatList, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


}
