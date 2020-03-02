package com.greenfoxacademy.listingtodos;

import com.greenfoxacademy.listingtodos.models.Todo;
import com.greenfoxacademy.listingtodos.repositories.TodoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ListingtodosApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(ListingtodosApplication.class, args);
    }

    TodoRepository todoRepository;

    public ListingtodosApplication (TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        todoRepository.save(new Todo("I have to learn Object Relational Mapping"));
    }
}
