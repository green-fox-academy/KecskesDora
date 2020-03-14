package com.greenfoxacademy.listingtodosmysql.services;

import com.fasterxml.jackson.databind.util.ArrayIterator;
import com.greenfoxacademy.listingtodosmysql.models.Assignee;
import com.greenfoxacademy.listingtodosmysql.models.Todo;
import com.greenfoxacademy.listingtodosmysql.repositories.AssigneeRepository;
import com.greenfoxacademy.listingtodosmysql.repositories.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TodoService {

    private TodoRepository todoRepository;
    private AssigneeRepository assigneeRepository;

    @Autowired
    public TodoService(TodoRepository todoRepository, AssigneeRepository assigneeRepository) {
        this.todoRepository = todoRepository;
        this.assigneeRepository = assigneeRepository;
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

    public List<Todo> findAllByDone(String isActive) {
        return todoRepository.findAllByIsDone(!Boolean.parseBoolean(isActive));
    }

    public List<Todo> findAll() {
        return todoRepository.findAllByOrderByIdAsc();
    }

    public List<Todo> search(String searchField, String searchKey) {

        switch (searchKey) {
            case "title":
                return searchByTitle(searchField);
            case "assignee":
                return searchByAssignee(searchField);
        }
        return null;
    }

    //not working!!!
    public List<Todo> searchDate(String searchDateField, String searchKey) {

        switch (searchKey) {
            case "creation":
                return findAll().stream().filter(todo -> todo.getStringCreationDate().contains(searchDateField)).collect(Collectors.toList());
            case "due":
                return findAll().stream().filter(todo -> todo.getStringDueDate().contains(searchDateField)).collect(Collectors.toList());
        }
        return null;
    }

    /*not working!!!
    public Iterable<Todo> searchDate(String searchDateField, String searchByDate) {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");
        Date parsed = new Date();
        try {
            parsed = sdf.parse(searchDateField);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        switch (searchByDate) {
            case "creation" :
                return searchByCreationDate(parsed);
            case "due":
                return searchByDueDate(parsed);
        }
        return null;
    }*/

    public List<Todo> searchByTitle(String title) {
        return todoRepository.findAllByTitleContainsIgnoreCase(title);
    }

    public List<Todo> searchByAssignee(String name) {
        return todoRepository.findAllByAssignee(findAssignee(name));
    }

    public Assignee findAssignee(String name) {
        return assigneeRepository.findAssigneeByNameContains(name);
    }

    public List<Todo> searchByCreationDate(Date creationDate) {
        return todoRepository.findAllByCreationDateContains(creationDate);
    }

    public List<Todo> searchByDueDate(Date dueDate) {
        return todoRepository.findAllByDueDateContains(dueDate);
    }
}
