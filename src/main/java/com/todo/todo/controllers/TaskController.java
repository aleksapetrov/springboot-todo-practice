package com.todo.todo.controllers;

import com.todo.todo.entities.Category;
import com.todo.todo.entities.Task;
import com.todo.todo.services.CategoryService;
import com.todo.todo.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("tasks")
public class TaskController {

    // tu ce biti sve rute koje imaju veze sa taskovima...

    // tasks/id
    // tasks
    // tasks/id/statistics

    @Autowired
    TaskService taskService;

    @Autowired
    CategoryService categoryService;



    @GetMapping("{id}")
    public ResponseEntity<Task> getOneTask(@PathVariable long id){

        // NullPointerException
       Optional<Task> taskOptional= taskService.findById(id);
       if(taskOptional.isPresent()){
           Task task = taskOptional.get();
           return new ResponseEntity<>(task, HttpStatus.OK);

       }
       return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
     // tasks/4 - DELETE

    // zadatak
    // napraviti sledeću rutu
    // /tasks/id/finish - POST (za menjanje atributa finished)
    // menja sa finished vrednost task sa tim id-em
    // pa ako je true, promeni u false, ako je false, promeni true
    // da vrati taj izmenjen task
    // ako taj task ne postoji neka vrati 404 grešku

    // tasks/4/finish - POST
    // users/1/tasks


    @PostMapping("{id}/finish")
    public ResponseEntity<Task> finishTask(@PathVariable long id){
        Optional<Task> taskOptional = taskService.findById(id);
        if(taskOptional.isPresent()) {
            Task task = taskOptional.get();
            task.setFinished(!task.isFinished());
            Task savedTask = taskService.update(task);
            return new ResponseEntity<>(savedTask, HttpStatus.OK);

        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    // query parametri

    // koriste se za filtirianje resurse

    // tasks?finished=true - GET

    // /proizvodi/laptopovi?mincena=200&maxcena=400


    @DeleteMapping("{id}")
    public ResponseEntity deleteTask(@PathVariable long id){
        Optional<Task> taskOptional = taskService.findById(id);
        if (taskOptional.isPresent()) {
            taskService.deleteById(id);
            return new ResponseEntity(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    @PutMapping("{id}")
    public ResponseEntity<Task> updateTask(@PathVariable long id, @RequestBody Task task){
        Optional<Task> taskOptional = taskService.findById(id);
        if (taskOptional.isPresent()) {
            task.setId(id);
            Task savedTask = taskService.update(task);
            return new ResponseEntity<>(savedTask, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    // napravi nam rutu tasks/id/categories - GET
    // ova ruta vraća listu kategoriju
    // i ako task sa tim id-em ne postoji vraca 404
    @GetMapping("{id}/categories")
    public ResponseEntity<List<Category>> getCategoriesInTask(@PathVariable long id){
        Optional<Task> taskOptional = taskService.findById(id);
        if (taskOptional.isPresent()) {
            Task task = taskOptional.get();
            List<Category> categories = task.getCategories();
            return new ResponseEntity<>(categories, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    // TODO domaci2

    // treba nam ruta da se kategorija poveze sa odredjenim taskom
    // tasks/3/categeories/2
    // tasks/id/categories/id - POST

    // task_category
    // 3 2
    @PostMapping ("{idTask}/categories/{idCategory}")
    public ResponseEntity<Task> postTaskInCategory (@PathVariable long idTask, @PathVariable long idCategory) {
        Optional<Task> taskOptional = taskService.findById(idTask);
        if (taskOptional.isPresent()) {
            Optional<Category> categoryOptional = categoryService.findById(idCategory);
            if(categoryOptional.isEmpty()){
                return ResponseEntity.notFound().build();
            }
            Task task = taskOptional.get();
            Category category = categoryOptional.get();
            task.getCategories().add(category);

            Task updatedTask = taskService.update(task);
            return ResponseEntity.ok(updatedTask);

        }
        return ResponseEntity.notFound().build();
    }

    // tasks/id/categories/id - DELETE


    @DeleteMapping("{idTask}/categories/{idCategory}")
    public ResponseEntity deleteTaskInCategory(@PathVariable long idTask, @PathVariable long idCategory) {
        Optional<Task> taskOptional = taskService.findById(idTask);
        if (taskOptional.isPresent()) {
            Optional<Category> categoryOptional = categoryService.findById(idCategory);
            if(categoryOptional.isEmpty()){
                return ResponseEntity.notFound().build();
            }
            Task task = taskOptional.get();
            Category category = categoryOptional.get();
            for(Category tempCategory: task.getCategories()){
                if(category.getId() == tempCategory.getId()){
                    task.getCategories().remove(tempCategory);
                    taskService.update(task);
                    break;


                }
            }


            return ResponseEntity.ok().build();

        }
        return ResponseEntity.notFound().build();
    }

}
