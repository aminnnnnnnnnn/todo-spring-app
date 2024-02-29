package com.example.todospringapp.controller;

import com.example.todospringapp.domain.TodoItem;
import com.example.todospringapp.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    public ResponseEntity<List<TodoItem>> getAllTodo() {
        return ResponseEntity.ok(todoService.findAllTodos());
    }

    public ResponseEntity<Optional<TodoItem>> getTodoWithId(Long id){
        return ResponseEntity.ok(todoService.findTodoById(id));
    }


}
