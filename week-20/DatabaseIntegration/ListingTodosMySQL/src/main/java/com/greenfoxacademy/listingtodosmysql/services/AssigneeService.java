package com.greenfoxacademy.listingtodosmysql.services;

import com.greenfoxacademy.listingtodosmysql.models.Assignee;
import com.greenfoxacademy.listingtodosmysql.models.Todo;
import com.greenfoxacademy.listingtodosmysql.repositories.AssigneeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AssigneeService {

    private AssigneeRepository assigneeRepository;

    @Autowired
    public AssigneeService(AssigneeRepository assigneeRepository) {
        this.assigneeRepository = assigneeRepository;
    }

    public Iterable<Assignee> findAll() {
        return assigneeRepository.findAllByOrderByIdAsc();
    }

    public void add(Assignee assignee) {
        assigneeRepository.save(assignee);
    }

    public void delete(Long id) {
        assigneeRepository.deleteById(id);
    }

    public Assignee find(Long id) {
        return assigneeRepository.findAssigneeById(id);
    }

    public void save(Assignee assignee) {
        assigneeRepository.save(assignee);
    }

    public void addTodo(Todo todo) {
        todo.getAssignee().addTodo(todo);
    }

    public List<Todo> getAssignedTodos(Long id) {
        return find(id).getTodos();
    }
}
