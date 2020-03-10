package com.greenfoxacademy.listingtodosmysql.services;

import com.greenfoxacademy.listingtodosmysql.models.Assignee;
import com.greenfoxacademy.listingtodosmysql.models.Todo;
import com.greenfoxacademy.listingtodosmysql.repositories.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TodoService {

    private TodoRepository todoRepository;

    @Autowired
    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public Iterable<Todo> list(String isActive, String searchedInput) {
        if (searchedInput != null) {
            return todoRepository.findAllByTitleContains(searchedInput);
        } else if (isActive == null) {
            return todoRepository.findAllByOrderByIdAsc();
        }
        return todoRepository.findAllByIsDone(!Boolean.parseBoolean(isActive));
    }

    public void save(Todo todo) {
        todoRepository.save(todo);
    }

    public void delete(Long id) {
        todoRepository.deleteById(id);
    }

    public Todo find(Long id) {
        return todoRepository.findTodoById(id);
    }
}
