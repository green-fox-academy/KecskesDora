package com.greenfoxacademy.listingtodosmysql.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
//@Table(name = "assignee")
public class Assignee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String email;

    //@JoinColumn(name="assignee_id")
    @OneToMany (/*cascade = CascadeType.ALL, fetch = FetchType.EAGER,*/ mappedBy = "assignee")
    private List<Todo> todos;

    public Assignee() {
        todos = new ArrayList<>();
    }

    public Assignee(String name) {
        this.name = name;
        todos = new ArrayList<>();
    }

    public Assignee(String name, String email) {
        this.name = name;
        this.email = email;
        todos = new ArrayList<>();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Todo> getTodos() {
        return todos;
    }

    public void setTodos(List<Todo> todo) {
        this.todos = todo;
    }

    public void addTodo(Todo todo) {
        todos.add(todo);
        todo.setAssignee(this);
    }

    public void deleteTodo(Todo todo) {
        todos.remove(todo);
    }

    @Override
    public String toString() {
        return name;
    }
}
