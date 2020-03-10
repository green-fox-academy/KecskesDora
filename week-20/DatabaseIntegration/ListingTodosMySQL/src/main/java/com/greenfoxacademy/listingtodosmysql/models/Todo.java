package com.greenfoxacademy.listingtodosmysql.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "todo")
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String title;
    private boolean isUrgent;
    private boolean isDone;

    @Temporal(TemporalType.DATE)
    private Date creationDate;

    //@ManyToOne
    //private Assignee assignee;

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

    public Todo(String title, boolean isUrgent, boolean isDone, String name) {
        this.title = title;
        this.isUrgent = isUrgent;
        this.isDone = isDone;
        //this.assignee = new Assignee(name);
    }

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

    /*public Assignee getAssignee() {
        return assignee;
    }

    public void setAssignee(Assignee assignee) {
        this.assignee = assignee;
    }*/

    @Override
    public String toString() {
        return title;
    }
}
