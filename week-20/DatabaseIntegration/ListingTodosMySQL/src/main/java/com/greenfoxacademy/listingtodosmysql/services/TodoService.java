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

        List<Todo> result = new ArrayList<>();

        switch (searchKey) {
            case "title":
                result = searchByTitle(searchField);
                break;
            case "assignee":
                result = searchByAssignee(searchField);
                break;
            case "creation":
                result = searchByCreationDate(searchField);
                break;
            case "due":
                result = searchByDueDate(searchField);
                break;
            case "null":
                return null;
        }
        return result;
    }

    public List<Todo> search(String isActive, String searchField, String searchKey) throws ParseException {

        List<Todo> result = new ArrayList<>();
        boolean activeSearch = Boolean.parseBoolean(isActive);

        switch (searchKey) {
            case "title":
                result = searchByTitleAndDone(searchField, activeSearch);
            case "assignee":
                result = searchByAssigneeAndDone(searchField, activeSearch);
                break;
            case "creation":
                result = searchByCreationDate(searchField);
                break;
            case "due":
                result = searchByDueDate(searchField);
                break;
            case "null":
                return null;
        }
        return result;
    }

    public List<Todo> searchByTitle(String title) {
        return todoRepository.findAllByTitleContainsIgnoreCase(title);
    }

    public List<Todo> searchByTitleAndDone(String title, boolean isActive) {
        return todoRepository.findByTitleContainsIgnoreCaseAndIsDone(title, !isActive);
    }

    public List<Todo> searchByAssignee(String name) {
        return todoRepository.findAllByAssignee(findAssignee(name));
    }

    public List<Todo> searchByAssigneeAndDone(String name, boolean isActive) {
        return todoRepository.findByAssigneeAndIsDone(findAssignee(name), !isActive);
    }

    public Assignee findAssignee(String name) {
        return assigneeRepository.findAssigneeByNameContains(name);
    }

    public List<Todo> searchByCreationDate(String searchField) throws ParseException {
        List<Todo> filteredTodos = todoRepository.findALLByCreationDate(dateFormatter(searchField));
        return filteredTodos;
    }

    public List<Todo> searchByDueDate(String searchField) throws ParseException {
        List<Todo> filteredTodos = todoRepository.findALLByDueDate(dateFormatter(searchField));
        return filteredTodos;
    }

    public Date dateFormatter(String date) throws ParseException{
        return new SimpleDateFormat("yyyy-MM-dd").parse(date);
    }
}
