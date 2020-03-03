package com.greenfoxacademy.listingtodosmysql;

import com.greenfoxacademy.listingtodosmysql.models.Todo;
import com.greenfoxacademy.listingtodosmysql.repositories.TodoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ListingtodosmysqlApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(ListingtodosmysqlApplication.class, args);
    }

    TodoRepository todoRepository;

    public ListingtodosmysqlApplication(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        todoRepository.save(new Todo("I have to learn Object Relational Mapping"));
    }
}
