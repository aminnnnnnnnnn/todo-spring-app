package com.example.todospringapp.service;

import com.example.todospringapp.domain.TodoItem;
import com.example.todospringapp.repository.TodoRepository;
import lombok.NonNull;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
@Service
public class TodoService {
    TodoRepository todoRepository;

    public List<TodoItem> findAllTodos(){
        return todoRepository.findAll();
    }

    public Optional<TodoItem> findTodoById(Long id){
        return todoRepository.findById(id);
    }

    public TodoItem createTodo (@NonNull String description, LocalDateTime dueAtTime){
        TodoItem todo = new TodoItem();
        todo.setDescription(description);
        todo.setDueAt(dueAtTime);
        if (todo.getDueAt().isBefore(todo.getCreatedAt()) || todo.getDueAt().equals(todo.getCreatedAt())){
            throw new RuntimeException("the dueAt must be after the creation Time");
        }
        return todo;
    }

}
