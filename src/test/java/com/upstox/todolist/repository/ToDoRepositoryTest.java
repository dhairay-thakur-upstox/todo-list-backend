package com.upstox.todolist.repository;

import com.upstox.todolist.entity.ToDo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import javax.transaction.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ToDoRepositoryTest extends BaseRepositoryTest {

    @Autowired
    private TestEntityManager testEntityManager;

    @Autowired
    private ToDoRepository toDoRepository;

    private ToDo todo;

    @Test
    @Transactional
    public void testFindAll() {
        todo = new ToDo("test todo");
        ToDo savedToDo = testEntityManager.persist(todo);
        List<ToDo> todos = toDoRepository.findAll();
        assertEquals(1, todos.size());
    }

    @Test
    @Transactional
    public void testFindById() {
        todo = new ToDo("test todo");
        ToDo savedToDo = testEntityManager.persist(todo);
        ToDo fetchedToDo = toDoRepository.findById(savedToDo.getId()).orElseThrow();
        assertEquals(savedToDo, fetchedToDo);
    }

    @Test
    @Transactional
    public void testSave() {
        todo = new ToDo("test todo");
        ToDo savedToDo = toDoRepository.save(todo);
        ToDo fetchedToDo = testEntityManager.find(ToDo.class, savedToDo.getId());
        assertNotNull(fetchedToDo);
        assertEquals(fetchedToDo, savedToDo);
    }

    @Test
    @Transactional
    public void testUpdate() {
        todo = new ToDo("test todo");
        ToDo savedToDo = testEntityManager.persist(todo);
        savedToDo.setText("new todo");
        ToDo updatedToDo = toDoRepository.save(savedToDo);
        ToDo fetchedToDo = testEntityManager.find(ToDo.class, savedToDo.getId());
        assertEquals(updatedToDo, fetchedToDo);
    }

    @Test
    @Transactional
    public void testDelete() {
        todo = new ToDo("test todo");
        ToDo savedToDo = testEntityManager.persist(todo);
        toDoRepository.deleteById(savedToDo.getId());
        ToDo fetchedToDo = testEntityManager.find(ToDo.class, savedToDo.getId());
        assertNull(fetchedToDo);
    }
}