package com.upstox.todolist.service;

import com.upstox.todolist.entity.ToDo;
import com.upstox.todolist.repository.ToDoRepository;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class ToDoServiceTest extends BaseServiceTest {

    @Autowired
    private ToDoService toDoService;

    @MockBean
    private ToDoRepository toDoRepository;

    private ToDo todo;

    @Test
    void getAllToDos() {
        todo = new ToDo("test todo");
        Mockito.when(toDoRepository.findAll()).thenReturn(List.of(todo));
        List<ToDo> todos = toDoService.getAllToDos();
        assertEquals(1, todos.size());
    }

    @SneakyThrows
    @Test
    void getToDoById() {
        todo = new ToDo(10, "test todo");
        Mockito.when(toDoRepository.findById(10)).thenReturn(Optional.ofNullable(todo));
        ToDo fetchedToDo = toDoService.getToDoById(10);
        assertNotNull(fetchedToDo);
        assertEquals(fetchedToDo, todo);
    }

    @Test
    void createToDo() {
        todo = new ToDo("test todo");
        ToDo savedToDo = new ToDo(10, "test todo");
        Mockito.when(toDoRepository.save(todo)).thenReturn(savedToDo);
        ToDo fetchedToDo = toDoService.createToDo(todo);
        Mockito.verify(toDoRepository, Mockito.times(1)).save(ArgumentMatchers.any(ToDo.class));
        assertEquals(fetchedToDo, savedToDo);
    }

    @Test
    void deleteToDo() {
        ToDo savedToDo = new ToDo(10, "test todo");
        Mockito.doNothing().when(toDoRepository).deleteById(savedToDo.getId());
        toDoService.deleteToDo(savedToDo.getId());
        Mockito.verify(toDoRepository).deleteById(ArgumentMatchers.any(Integer.class));
        Mockito.verify(toDoRepository, Mockito.times(1)).deleteById(ArgumentMatchers.any(Integer.class));
    }
}