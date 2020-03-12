package com.greenfoxacademy.listingtodosmysql.repositories;

import com.greenfoxacademy.listingtodosmysql.models.Assignee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssigneeRepository extends CrudRepository<Assignee, Long> {

    Iterable<Assignee> findAllByOrderByIdAsc();
    Assignee findAssigneeById(Long id);
    Iterable<Assignee> findAssigneeByNameContains(String name);
}
