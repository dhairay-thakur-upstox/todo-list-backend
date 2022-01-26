package com.upstox.todolist.service;

import com.upstox.todolist.entity.ToDo;
import com.upstox.todolist.repository.ToDoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ToDoService {
    private final ToDoRepository toDoRepository;

    public ToDoService(ToDoRepository toDoRepository) {
        this.toDoRepository = toDoRepository;
    }

    public List<ToDo> getAllToDos() {
        return toDoRepository.findAll();
    }

    public ToDo getToDoById(Integer id) throws Throwable {
        return (ToDo) toDoRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    public ToDo createToDo(ToDo todo) {
        return (ToDo) toDoRepository.save(todo);
    }

    public ToDo updateToDo(ToDo todo) {
        return (ToDo) toDoRepository.save(todo);
    }

    public void deleteToDo(Integer id) {
        toDoRepository.deleteById(id);
    }

}
