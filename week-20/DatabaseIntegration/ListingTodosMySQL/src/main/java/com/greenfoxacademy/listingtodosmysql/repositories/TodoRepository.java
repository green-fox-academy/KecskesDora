package com.greenfoxacademy.listingtodosmysql.repositories;

import com.greenfoxacademy.listingtodosmysql.models.Todo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepository extends CrudRepository<Todo, Long> {

    Iterable<Todo> findAllByIsDone(boolean isActive);
}
