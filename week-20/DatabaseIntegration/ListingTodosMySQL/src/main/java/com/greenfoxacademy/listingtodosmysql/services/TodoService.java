package com.greenfoxacademy.listingtodosmysql.services;

import com.greenfoxacademy.listingtodosmysql.models.Todo;
import com.greenfoxacademy.listingtodosmysql.repositories.AssigneeRepository;
import com.greenfoxacademy.listingtodosmysql.repositories.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;

@Service
public class TodoService {

    private TodoRepository todoRepository;

    @Autowired
    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public void save(Todo todo) {
        todoRepository.save(todo);
    }

    public void delete(Long id) {
        /*ez végül nem kellett, mert CascadeType.ALL nélkül is működik
        Todo todo = find(id);
        todo.getAssignee().deleteTodo(todo);
        todo.setAssignee(null);*/
        todoRepository.deleteById(id);
    }

    public Todo find(Long id) {
        return todoRepository.findTodoById(id);
    }

    public Iterable<Todo> findAllByDone(String isActive) {
        return todoRepository.findAllByIsDone(!Boolean.parseBoolean(isActive));
    }

    public Iterable<Todo> findAll() {
        return todoRepository.findAllByOrderByIdAsc();
    }


    public Iterable<Todo> search(String searchField, String searchBy) {
        switch (searchBy) {
            case "title":
                return searchByTitle(searchField);
            case "assignee":
                return searchByAssignee(searchField);
            case "creation":
                LocalDate date = LocalDate.parse(searchField);
                return searchByCreationDate(date);
            case "due":
                LocalDate dueDate = LocalDate.parse(searchField);
                return searchByDueDate(dueDate);
        }
        return null;
    }

    public Iterable<Todo> searchByTitle(String title) {
        return todoRepository.findAllByTitleContains(title);
    }

    public Iterable<Todo> searchByAssignee(String name) {
        return todoRepository.findAllByAssigneeContains(name);
    }

    public Iterable<Todo> searchByCreationDate(LocalDate date) {
        return todoRepository.findAllByCreationDateContains(date);
    }

    public Iterable<Todo> searchByDueDate(LocalDate date) {
        return todoRepository.findAllByDueDateContains(date);
    }
}
