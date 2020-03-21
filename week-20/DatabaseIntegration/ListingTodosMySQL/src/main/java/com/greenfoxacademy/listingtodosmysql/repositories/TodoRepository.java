package com.greenfoxacademy.listingtodosmysql.repositories;

import com.greenfoxacademy.listingtodosmysql.models.Assignee;
import com.greenfoxacademy.listingtodosmysql.models.Todo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface TodoRepository extends CrudRepository<Todo, Long> {

    List<Todo> findAllByIsDone(boolean isActive);
    List<Todo> findAllByOrderByIdAsc();
    Todo findTodoById(Long aLong);
    List<Todo> findAllByTitleContainsIgnoreCase(String title);
    List<Todo> findAllByAssignee(Assignee assignee);
    List<Todo> findALLByCreationDate(Date date);
    List<Todo> findALLByDueDate(Date date);

    List<Todo> findByTitleContainsIgnoreCaseAndIsDone(String title, boolean isActive);
    List<Todo> findByAssigneeAndIsDone(Assignee assignee, boolean isActive);
}
