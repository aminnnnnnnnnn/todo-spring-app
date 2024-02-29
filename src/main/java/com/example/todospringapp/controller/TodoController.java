package com.example.todospringapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("api/todos")
public class TodoController {

    @GetMapping
    public String helloWorld() {
        return "hello new Todo App";
    }
}
