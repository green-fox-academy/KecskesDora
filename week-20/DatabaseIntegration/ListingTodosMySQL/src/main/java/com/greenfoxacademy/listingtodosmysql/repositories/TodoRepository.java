package com.greenfoxacademy.listingtodosmysql.repositories;

import com.greenfoxacademy.listingtodosmysql.models.Todo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Date;

@Repository
public interface TodoRepository extends CrudRepository<Todo, Long> {

    Iterable<Todo> findAllByIsDone(boolean isActive);
    Iterable<Todo> findAllByOrderByIdAsc();
    Todo findTodoById(Long aLong);
    Iterable<Todo> findAllByTitleContains(String title);
    Iterable<Todo> findAllByAssigneeContains(String name);
    Iterable<Todo> findAllByCreationDateContains(LocalDate date);
    Iterable<Todo> findAllByDueDateContains(LocalDate date);
}
