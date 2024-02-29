package com.example.todospringapp.repository;

import com.example.todospringapp.domain.TodoItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<TodoItem, Long> {
}
