package com.greenfoxacademy.listingtodosmysql.models;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static java.time.LocalDate.now;

@Entity
//@Table(name = "todo")
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String title;
    private boolean isUrgent;
    private boolean isDone;

    //@Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date creationDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dueDate;

    @ManyToOne
    private Assignee assignee;

    public Todo() {
        isUrgent = false;
        isDone = false;
        creationDate = new Date();
    }

    public Todo(String title) {
        this.title = title;
        isUrgent = false;
        isDone = false;
        creationDate = new Date();
    }

    public Todo(String title, boolean isUrgent, boolean isDone) {
        this.title = title;
        this.isUrgent = isUrgent;
        this.isDone = isDone;
        creationDate = new Date();
    }

    /*public Todo(String title, boolean isUrgent, boolean isDone, Assignee assignee) {
        this.title = title;
        this.isUrgent = isUrgent;
        this.isDone = isDone;
        this.assignee = assignee;
    }

    public Todo(String title, boolean isUrgent, boolean isDone, Assignee assignee, Date dueDate) {
        this.title = title;
        this.isUrgent = isUrgent;
        this.isDone = isDone;
        this.assignee = assignee;
        this.dueDate = dueDate;
    }*/

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isUrgent() {
        return isUrgent;
    }

    public void setUrgent(boolean urgent) {
        isUrgent = urgent;
    }

    public boolean isDone() {
        return isDone;
    }

    public void setDone(boolean done) {
        isDone = done;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public Assignee getAssignee() {
        return assignee;
    }

    public Long getAssigneeId() {
        if (assignee == null) {
            return 0L;
        } else {
            return assignee.getId();
        }
    }

    public String getAssigneeName() {
        if (assignee == null) {
            return "";
        } else {
            return assignee.getName();
        }
    }

    public void setAssignee(Assignee assignee) {
        this.assignee = assignee;
    }

    @Override
    public String toString() {
        return title;
    }
}
