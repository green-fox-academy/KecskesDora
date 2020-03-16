package com.greenfoxacademy.listingtodosmysql.services;

import com.fasterxml.jackson.databind.util.ArrayIterator;
import com.greenfoxacademy.listingtodosmysql.models.Assignee;
import com.greenfoxacademy.listingtodosmysql.models.Todo;
import com.greenfoxacademy.listingtodosmysql.repositories.AssigneeRepository;
import com.greenfoxacademy.listingtodosmysql.repositories.TodoRepository;
import org.apache.tomcat.jni.Local;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
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
        /*ez végül nem kellett, mert CascadeType.ALL nélkül amúgy is működik
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

    public List<Todo> search(String searchField, String searchKey) throws ParseException {

        switch (searchKey) {
            case "title":
                return searchByTitle(searchField);
            case "assignee":
                return searchByAssignee(searchField);
            case "creation":
                return searchByCreationDate(searchField);
            case "due":
                return searchByDueDate(searchField);
        }
        return null;
    }

    //not working!!!
    /*public List<Todo> searchDate(String searchDateField, String searchKey) {

        //DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        //LocalDate parsed = LocalDate.parse(searchDateField, formatter);

        switch (searchKey) {
            case "creation":
                return findAll().stream().filter(todo -> todo.getStringCreationDate().contains(searchDateField)).collect(Collectors.toList());
            case "due":
                return findAll().stream().filter(todo -> todo.getStringDueDate().contains(searchDateField)).collect(Collectors.toList());
        }
        return null;
    }*/

    //not working!!!
    /*public Iterable<Todo> searchDate(String searchDateField, String searchKey) throws ParseException {

        Date searchedDate = new SimpleDateFormat("yyyy-MM-DD").parse(searchDateField);

        switch (searchKey) {
            case "creation" :
                return searchByCreationDate(searchedDate);
            case "due":
                return searchByDueDate(searchedDate);
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

    public List<Todo> searchByCreationDate(String searchField) throws ParseException {
        List<Todo> filteredTodos = new ArrayList<>();
        Date searchedDate = new SimpleDateFormat("yyyy-MM-dd").parse(searchField);

        for (Todo todo: findAll()) {
            if (todo.getCreationDate() != null) {
                if (todo.getCreationDate().compareTo(searchedDate) == 0) {
                    filteredTodos.add(todo);
                }
            }
        }
        return filteredTodos;
        //return todoRepository.findAllByCreationDateContains(creationDate);
    }

    public List<Todo> searchByDueDate(String searchField) throws ParseException {
        List<Todo> filteredTodos = new ArrayList<>();
        Date searchedDate = new SimpleDateFormat("yyyy-MM-dd").parse(searchField);

        for (Todo todo: findAll()) {
            if (todo.getDueDate() != null) {
                if (todo.getDueDate().compareTo(searchedDate) == 0) {
                    filteredTodos.add(todo);
                }
            }
        }
        return filteredTodos;
        //return todoRepository.findAllByDueDateContains(dueDate);
    }
}
