package com.example.todospringapp.controller;

import com.example.todospringapp.domain.TodoItem;
import com.example.todospringapp.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("api/todos")
public class TodoController {
    @Autowired
    TodoService todoService;

    @GetMapping
    public String helloWorld() {
        return "hello new Todo App";
    }

    @GetMapping("/getAllTodos/")
    public ResponseEntity<List<TodoItem>> getAllTodo() {
        return ResponseEntity.ok(todoService.findAllTodos());
    }

    @GetMapping("/getTodo/{id}")
    public ResponseEntity<Optional<TodoItem>> getTodoWithId(@PathVariable Long id) {
        return ResponseEntity.ok(todoService.findTodoById(id));
    }
    @PostMapping("/createTodo/")
    public ResponseEntity<TodoItem> createTodo(@RequestParam String description,
                                               @RequestParam LocalDateTime dateTime){
        TodoItem todo = todoService.createTodo(description, dateTime);
        return ResponseEntity.ok(todo);
    }


}
