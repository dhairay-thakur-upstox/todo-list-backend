package com.upstox.todolist.controller;

import com.upstox.todolist.entity.ToDo;
import com.upstox.todolist.service.ToDoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = {"http://localhost:3000"})
@RequestMapping("todos")
public class ToDoController {
    private final ToDoService toDoService;

    public ToDoController(ToDoService toDoService) {
        this.toDoService = toDoService;
    }

    @GetMapping
    public ResponseEntity<List<ToDo>> getAllToDos() {
        System.out.println("hello");
        return new ResponseEntity<>(
                toDoService.getAllToDos(),
                HttpStatus.OK
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<ToDo> getToDoById(@PathVariable Integer id) throws Throwable {
        return new ResponseEntity<>(
                toDoService.getToDoById(id),
                HttpStatus.OK
        );
    }

    @PostMapping
    public ResponseEntity<ToDo> createTodo(@RequestBody ToDo todo) {
        return new ResponseEntity<>(
                toDoService.createToDo(todo),
                HttpStatus.OK
        );
    }

    @PutMapping
    public ResponseEntity<ToDo> updateToDo(@RequestBody ToDo todo) {
        return new ResponseEntity<>(
                toDoService.updateToDo(todo),
                HttpStatus.OK
        );
    }

    @DeleteMapping
    public void deleteToDo(@RequestParam Integer id) {
        toDoService.deleteToDo(id);
    }
}
