package com.greenfoxacademy.listingtodosmysql;

import com.greenfoxacademy.listingtodosmysql.models.Assignee;
import com.greenfoxacademy.listingtodosmysql.models.Todo;
import com.greenfoxacademy.listingtodosmysql.repositories.AssigneeRepository;
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
    AssigneeRepository assigneeRepository;

    public ListingtodosmysqlApplication(TodoRepository todoRepository, AssigneeRepository assigneeRepository) {
        this.todoRepository = todoRepository;
        this.assigneeRepository = assigneeRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        /*todoRepository.save(new Todo("I have to learn Object Relational Mapping"));
        todoRepository.save(new Todo("buy milk", true, true));
        todoRepository.save(new Todo("clean windows", false, true));
        todoRepository.save(new Todo("do presentation", true, false));
        todoRepository.save(new Todo("sleep more", false, false));*/

        assigneeRepository.save(new Assignee("Nagy Rita", "rita.nagy@proba.hu"));
        assigneeRepository.save(new Assignee("Kis Ramona", "ramona.kis@proba.hu"));
    }
}
